package Controlador;

import Modelo.DTODetalleVentas;
import Modelo.DTOReporteDos;
import Modelo.DTOproducto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GestionReportes {

    //Conectividad
    private final String CONN = "jdbc:sqlserver://DESKTOP-HS8DT3G;databaseName=PuntoNetTotoral";
    private final String USER = "sa";
    private final String PASS = "41964968lucilagaitan";

    private Connection con;

    public void abrirConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-	Emitir un reporte estadístico de los productos por marca y categoría
    public ArrayList<DTOproducto> getReporteUno() {

        ArrayList<DTOproducto> lista = new ArrayList<DTOproducto>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select p.id_Producto, p.descripcion_Producto, m.descripcion_Marca, r.descripcion_Rubro, p.cantidad_Producto, p.costo_Producto, p.utilidad_Producto\n"
                    + "from Productos p, Marcas m, Rubros r\n"
                    + "where p.marca_Producto = m.id_Marca\n"
                    + "and p.rubro_Producto = r.id_Rubro\n"
                    + "group by m.descripcion_Marca, r.descripcion_Rubro, p.id_Producto, p.descripcion_Producto, p.cantidad_Producto, p.costo_Producto, p.utilidad_Producto\n"
                    + "order by p.descripcion_Producto asc");

            while (rs.next()) {
                int id = rs.getInt("id_Producto");
                String nombre = rs.getString("descripcion_Producto");
                String marca = rs.getString("descripcion_Marca");
                String rubro = rs.getString("descripcion_Rubro");
                int cantidad = rs.getInt("cantidad_Producto");
                double costo = rs.getDouble("costo_Producto");
                double utilidad = rs.getDouble("utilidad_Producto");

                DTOproducto dto = new DTOproducto(id, nombre, marca, rubro, cantidad, costo, utilidad);
                lista.add(dto);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    //-	Emitir un reporte estadístico de los productos más vendidos
    public ArrayList<DTOReporteDos> getReporteDos() {

        ArrayList<DTOReporteDos> lista = new ArrayList<DTOReporteDos>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select top 1 cantidad_Detalle_Ventas,  p.descripcion_Producto\n"
                    + "from DetallesVentas d, Productos p\n"
                    + "where d.id_Producto_Detalle_Ventas = p.id_Producto\n"
                    + "order by d.cantidad_Detalle_Ventas desc");

            while (rs.next()) {
                int cantidad = rs.getInt("cantidad_Detalle_Ventas");
                String producto = rs.getString("descripcion_Producto");

                DTOReporteDos r = new DTOReporteDos(producto, cantidad);
                lista.add(r);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

//-     Emitir un reporte estadístico de las ventas realizadas en un día determinado / final de cada día
//-	Emitir un reporte estadístico de las ventas realizadas en un lapso de tiempo determinado
    //monto total de facturas por mes con pedidos entregados
    public double obtenerTotalVentasPorMes(int mes) {
        double montoTotalFacturasxMes = 0;
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("select sum(dv.monto_Detalle_Ventas) as montoTotalMensual\n"
                    + "from DetallesVentas dv, Ventas v\n"
                    + "where MONTH(v.fecha_Venta) = ?\n"
                    + "and v.numero_Venta=dv.numero_Venta");
            st.setInt(1, mes);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                montoTotalFacturasxMes = rs.getDouble("montoTotalMensual");
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return montoTotalFacturasxMes;
    }

    public double obtenerTotalVentasPeriodo(int mes1, int mes2) {
        double montoTotalFacturasxMes = 0;
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("select sum(dv.monto_Detalle_Ventas) as montoTotalMensual\n"
                    + "from DetallesVentas dv, Ventas v\n"
                    + "where MONTH(v.fecha_Venta)  BETWEEN ? and ?\n"
                    + "and v.numero_Venta=dv.numero_Venta");
            st.setInt(1, mes1);
            st.setInt(2, mes2);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                montoTotalFacturasxMes = rs.getDouble("montoTotalMensual");
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return montoTotalFacturasxMes;
    }

    public JFreeChart graficoFormasDePago() {
        DefaultPieDataset data = new DefaultPieDataset();
        JFreeChart grafico = ChartFactory.createPieChart("", data, true, true, true);
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("select p.descripcion_Tipo_Pago as formaPago, count(v.tipo_Pago_Venta) as cantidadVeces\n "
                    + "from Ventas v, TiposPagos p\n"
                    + "where v.tipo_Pago_Venta = p.id_Tipo_Pago\n"
                    + "group by p.descripcion_Tipo_Pago");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.setValue(rs.getString("formaPago"), rs.getInt(2));
            }
            grafico = ChartFactory.createPieChart("Formas de pago de preferencia", data, true, false, true);
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return grafico;
    }

    public JFreeChart graficoBarraFormasPago() {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        JFreeChart grafico = ChartFactory.createBarChart("", "", "", data);
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("select p.descripcion_Tipo_Pago as formaPago, count(v.tipo_Pago_Venta) as cantidadVeces\n "
                    + "from Ventas v, TiposPagos p\n"
                    + "where v.tipo_Pago_Venta = p.id_Tipo_Pago\n"
                    + "group by p.descripcion_Tipo_Pago");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.setValue(rs.getInt(2), rs.getString("formaPago"), rs.getString("formaPago") + "=" + rs.getInt(2));
            }
            grafico = ChartFactory.createBarChart("Formas de Pago", "Formas de Pago", "Cantidad vendida", data, PlotOrientation.VERTICAL, true, true, true);
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return grafico;
    }

}
