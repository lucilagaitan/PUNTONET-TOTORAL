package Controlador;

import Modelo.DTODetalleVentas;
import Modelo.DTOPedido;
import Modelo.DTOVentaFacturacion;
import Modelo.DTOVentas; 
import Modelo.DetalleVentas;
import Modelo.TipoEntrega;
import Modelo.TipoPago;
import Modelo.Usuaio;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorVentas {

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

    //Agregar Ventas
    public void agregarVenta(DTOVentas v) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Ventas VALUES (convert(varchar, getdate(), 103), ?, ?, ?, ?)");

            st.setInt(1, v.getUsuario());
            st.setInt(2, v.getTipoPago());
            st.setInt(3, v.getTipoEntrega());
            st.setFloat(4, v.getTotal());

            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Agregar DetalleVentas
    public void agregarDetalleVenta(DTODetalleVentas dv) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO DetallesVentas VALUES(?,?,?,?)");

            st.setInt(1, dv.getIdProd());
            st.setInt(2, dv.getCantidad());
            st.setDouble(3, dv.getMonto());
            st.setInt(4, dv.getVenta());

            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener Combo 
    public ArrayList<TipoPago> getObtenerComboPago() {

        ArrayList<TipoPago> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TiposPagos");
            while (rs.next()) {
                int id = rs.getInt("id_Tipo_Pago");
                String descripcion = rs.getString("descripcion_Tipo_Pago");

                TipoPago p = new TipoPago(id, descripcion);

                lista.add(p);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;

    }

    public ArrayList<TipoEntrega> getObtenerComboEntrega() {

        ArrayList<TipoEntrega> lista = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TiposEntregas");
            while (rs.next()) {
                int id = rs.getInt("id_Tipo_Entrega");
                String descripcion = rs.getString("descripcion_Tipo_Entrega");

                TipoEntrega e = new TipoEntrega(id, descripcion);

                lista.add(e);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;

    }

    public TipoEntrega obtenerEnvioUpdate(int idEnvio) {
        TipoEntrega fe = new TipoEntrega();
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM TiposEntregas WHERE id_Tipo_Entrega = ?");
            ps.setInt(1, idEnvio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fe.setId_TipoEntrega(rs.getInt("id_Tipo_Entrega"));
                fe.setDescripcion(rs.getString("descripcion_Tipo_Entrega"));
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return fe;
    }
    
    public int obtenerIdFactura(DTOVentas dto) {
        int idFactura = 0;
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("select v.numero_Venta \n"
                    + "from Ventas v\n"
                    + "where v.tipo_Pago_Venta = ?\n"
                    + "and v.id_Usuario_Venta = ?\n"
                    + "and v.fecha_Venta = convert(varchar, getdate(), 103)\n"
                    + "and v.total = ?");
            
            st.setInt(1, dto.getTipoPago());
            st.setInt(2, dto.getUsuario());
            st.setFloat(3, dto.getTotal());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                idFactura = rs.getInt("numero_Venta");
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return idFactura;
    }

    //Mètodo Obtener Listado
    public DTOVentaFacturacion getObtenerListadoVentas(int idFactura) {

       DTOVentaFacturacion ventaFacturacion = null;

        try {

            abrirConexion();            
            PreparedStatement ps = con.prepareStatement("select v.numero_Venta, v.fecha_Venta, u.apellido_Usuario + ' ' + u.nombre_Usuario 'Nombre', p.descripcion_Tipo_Pago, e.descripcion_Tipo_Entrega, v.total\n" +
"                                        from Ventas v, Usuarios u, TiposPagos p, TiposEntregas e\n" +
"                                        where v.id_Usuario_Venta = u.id_Usuario\n" +
"                                        and v.tipo_Pago_Venta = p.id_Tipo_Pago\n" +
"                                        and v.tipo_Entrega_Venta = e.id_Tipo_Entrega\n" +
"                                        and v.numero_Venta = ?");
            ps.setInt(1, idFactura);
            ResultSet rs = ps.executeQuery();            
          
            while (rs.next()) {
                int id = rs.getInt("numero_Venta");
                String nombre = rs.getString("Nombre");
                String pago = rs.getString("descripcion_Tipo_Pago");
                String entrega = rs.getString("descripcion_Tipo_Entrega");
                float monto = rs.getFloat("total");
                ventaFacturacion = new DTOVentaFacturacion(id, nombre, pago, entrega, monto);
                
            }

            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return ventaFacturacion;
    }

    public ArrayList<DTODetalleVentas> getObtenerListadoDetalleVentas(int idCliente, int idFactura) {

        ArrayList<DTODetalleVentas> lista = new ArrayList<DTODetalleVentas>();

        try {

            abrirConexion();         
            PreparedStatement ps = con.prepareStatement("select p.id_Producto, d.numero_Detalle_Ventas, p.descripcion_Producto, d.cantidad_Detalle_Ventas, (d.cantidad_Detalle_Ventas * ((p.Costo_Producto*p.Utilidad_Producto)/100 + p.costo_Producto)) 'Monto', v.numero_Venta\n" +
"                    from DetallesVentas d, Productos p, Ventas v\n" +
"                    where d.id_Producto_Detalle_Ventas = p.id_Producto\n" +
"                    and d.numero_Venta = v.numero_Venta\n" +
"                    and v.id_Usuario_Venta = ?\n" +
"                    and v.numero_Venta = ?");
            ps.setInt(1, idCliente);
            ps.setInt(2, idFactura);
            ResultSet rs = ps.executeQuery();  

            while (rs.next()) {
                int idP = rs.getInt("id_Producto");
                int numVenta = rs.getInt("numero_Detalle_Ventas");
                String producto = rs.getString("descripcion_Producto");
                int cantidad = rs.getInt("cantidad_Detalle_Ventas");
                double monto = rs.getDouble("Monto");
                int venta = rs.getInt("numero_Venta");
                
                DTODetalleVentas dto = new DTODetalleVentas(numVenta, producto, idP, cantidad, monto, venta);
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
    
    //obtener mis pedidos
    public ArrayList<DTOPedido> obtenerMisPedidos(int id) {

        ArrayList<DTOPedido> listaPedidos = new ArrayList<DTOPedido>();

        try {
            abrirConexion();         
            PreparedStatement ps = con.prepareStatement("select v.numero_Venta, v.total, v.fecha_Venta, sum(dv.cantidad_Detalle_Ventas) as cantidadProd\n" +
                                                            "from Ventas v, DetallesVentas dv\n" +
                                                            "where v.numero_Venta = dv.numero_Venta\n" +
                                                            "and v.id_Usuario_Venta = ?\n" +
                                                            "group by v.numero_Venta, v.total, v.fecha_Venta");
           
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();             
            while (rs.next()) {                
                int numVenta = rs.getInt("numero_Venta");
                double total = rs.getDouble("total");
                String fecha = rs.getString("fecha_Venta");
                int cantidadProd = rs.getInt("cantidadProd");
                DTOPedido dto = new DTOPedido(numVenta, total, fecha, cantidadProd);
                listaPedidos.add(dto);
            }

            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaPedidos;
    }

}
