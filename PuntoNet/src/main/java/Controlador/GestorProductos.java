package Controlador;

import Modelo.DTOproducto;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.Rubro;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

public class GestorProductos {

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

    //Agregar
    public void agregarProducto(Producto p) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Productos VALUES(?,?,?,?,?,?,?)");

            st.setString(1, p.getDescripcionProducto());
            st.setInt(2, p.getMarcaProducto().getIdMarca());
            st.setInt(3, p.getRubroProducto().getIdRubro());
            st.setInt(4, p.getCantidadProducto());
            st.setDouble(5, p.getCostoProducto());
            st.setDouble(6, p.getUtilidadProducto());
            st.setBytes(7, p.getFoto());
            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener Combo 
    public ArrayList<Marca> getObtenerComboMarca() {

        ArrayList<Marca> listaMarca = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Marcas");
            while (rs.next()) {
                int id = rs.getInt("id_Marca");
                String descripcion = rs.getString("descripcion_Marca");

                Marca m = new Marca(id, descripcion);

                listaMarca.add(m);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaMarca;

    }

    //Obtener Combo
    public ArrayList<Rubro> getObtenerComboRubro() {

        ArrayList<Rubro> listaRubro = new ArrayList<>();

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Rubros");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Rubro");
                String descripcion = rs.getString("descripcion_Rubro");

                Rubro r = new Rubro(id, descripcion);

                listaRubro.add(r);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaRubro;

    }

    //Agregar Marca
    public void agregarMarca(Marca m) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Marcas VALUES(?)");

            st.setString(1, m.getDescripcionMarca());

            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Agregar Rubro
    public void agregarRubro(Rubro r) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Rubros VALUES(?)");

            st.setString(1, r.getDescripcionRubro());

            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Mètodo Obtener Listado
    public ArrayList<DTOproducto> getObtenerListadoProductos() {

        ArrayList<DTOproducto> lista = new ArrayList<DTOproducto>();

        try {

            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT   p.id_Producto, \n"
                    + "p.descripcion_Producto, \n"
                    + "m.descripcion_Marca, \n"
                    + "r.descripcion_Rubro, \n"
                    + "p.cantidad_Producto, \n"
                    + "p.costo_Producto, \n"
                    + "p.utilidad_Producto\n"
                    + "FROM 	Productos p, Marcas m, Rubros r\n"
                    + "WHERE 	p.marca_Producto = m.id_Marca\n"
                    + "AND 	p.rubro_Producto = r.id_Rubro");

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

    public ArrayList<DTOproducto> getObtenerProductosParaTienda() {
        ArrayList<DTOproducto> listado = new ArrayList<DTOproducto>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT   p.id_Producto, \n"
                    + "p.descripcion_Producto, \n"
                    + "m.descripcion_Marca, \n"
                    + "r.descripcion_Rubro, \n"
                    + "p.cantidad_Producto, \n"
                    + "p.costo_Producto, \n"
                    + "p.utilidad_Producto,\n"
                    + "p.foto \n"
                    + "FROM 	Productos p, Marcas m, Rubros r\n"
                    + "WHERE 	p.marca_Producto = m.id_Marca\n"
                    + "AND 	p.rubro_Producto = r.id_Rubro");
            while (rs.next()) {
                int id = rs.getInt("id_Producto");
                String nombre = rs.getString("descripcion_Producto");
                String marca = rs.getString("descripcion_Marca");
                String rubro = rs.getString("descripcion_Rubro");
                int cantidad = rs.getInt("cantidad_Producto");
                double costo = rs.getDouble("costo_Producto");
                double utilidad = rs.getDouble("utilidad_Producto");
                InputStream foto = rs.getBinaryStream("foto");

                DTOproducto dto = new DTOproducto(id, nombre, marca, rubro, cantidad, costo, utilidad);
                listado.add(dto);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listado;
    }
    
    
    //Eliminar Marca
    public void eliminarMarca(int idMarca) {
        try {

            abrirConexion();
            String sql = "DELETE FROM Marcas WHERE id_Marca=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idMarca);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Eliminar Marca
    public void eliminarRubro(int idRubro) {
        try {

            abrirConexion();
            String sql = "DELETE FROM Rubros WHERE id_Rubro=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idRubro);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener Marca
    public Marca obtenerMarcaPorId(int idMarca) {
        Marca m = null;
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Marcas WHERE id_Marca=?");

            st.setInt(1, idMarca);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString("descripcion_Marca");

                m = new Marca(idMarca, nombre);

            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return m;
    }

    //Modificar Marca
    public void modificarMarca(Marca m) {
        try {
            abrirConexion();
            String sql = "UPDATE Marcas SET descripcion_Marca=? WHERE id_Marca=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, m.getDescripcionMarca());
            st.setInt(2, m.getIdMarca());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener Marca
    public Rubro obtenerRubroPorId(int idRubro) {
        Rubro r = null;
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Rubros WHERE id_Rubro=?");

            st.setInt(1, idRubro);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString("descripcion_Rubro");

                r = new Rubro(idRubro, nombre);

            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return r;
    }

    //Modificar Marca
    public void modificarRubro(Rubro r) {
        try {

            abrirConexion();
            String sql = "UPDATE Rubros SET descripcion_Rubro=? WHERE id_Rubro=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, r.getDescripcionRubro());
            st.setInt(2, r.getIdRubro());

            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Eliminar Producto
    public void eliminarProducto(int idProducto) {
        try {

            abrirConexion();
            String sql = "DELETE FROM Productos WHERE id_Producto=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idProducto);
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener Producto
    public Producto obtenerProductoPorId(int idProducto) {
        Producto p = null;
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Productos p, Marcas m, Rubros r WHERE id_Producto=? AND p.marca_Producto=m.id_Marca AND p.rubro_Producto=r.id_Rubro  ");

            st.setInt(1, idProducto);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                String nombre = rs.getString("descripcion_Producto");
                int marca = rs.getInt("id_Marca");
                String marcaProducto = rs.getString("descripcion_Marca");
                Marca m = new Marca(marca, marcaProducto);
                int rubro = rs.getInt("id_Rubro");
                String rubroProducto = rs.getString("descripcion_Rubro");
                Rubro r = new Rubro(rubro, rubroProducto);
                int cantidad = rs.getInt("cantidad_Producto");
                double costo = rs.getDouble("costo_Producto");
                double utilidad = rs.getDouble("utilidad_Producto");

                p = new Producto(idProducto, nombre, m, r, cantidad, costo, utilidad);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return p;
    }

    //Modificar Producto
    public void modificarProducto(Producto p) {
        try {
            abrirConexion();
            String sql = " UPDATE Productos SET descripcion_Producto=?, marca_Producto=?, rubro_Producto=?, cantidad_Producto=?, costo_Producto=?, utilidad_Producto=? WHERE id_Producto=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, p.getDescripcionProducto());
            st.setInt(2, p.getMarcaProducto().getIdMarca());
            st.setInt(3, p.getRubroProducto().getIdRubro());
            st.setInt(4, p.getCantidadProducto());
            st.setDouble(5, p.getCostoProducto());
            st.setDouble(6, p.getUtilidadProducto());
            st.setInt(7, p.getIdProducto());

            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Buscar Producto
    public ArrayList<Producto> getobtenerProductosPorBusquedaDeNombre(String descripProducto) {
        ArrayList<Producto> listado = new ArrayList<Producto>();
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("select * from Productos where descripcion_Producto like" + "'%" + descripProducto + "%'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Producto");
                String nombre = rs.getString("descripcion_Producto");
                String marcaProducto = rs.getString("descripcion_Marca");
                Marca m = new Marca(0, marcaProducto);
                String rubroProducto = rs.getString("descripcion_Rubro");
                Rubro r = new Rubro(0, rubroProducto);
                int cantidad = rs.getInt("cantidad_Producto");
                double costo = rs.getDouble("costo_Producto");
                double utilidad = rs.getDouble("utilidad_Producto");

                Producto p = new Producto(id, nombre, m, r, cantidad, costo, utilidad);
                listado.add(p);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listado;
    }


    
    
    
    public void listarImagen(int id, HttpServletResponse response) throws IOException {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            abrirConexion();
            outputStream = response.getOutputStream();
            PreparedStatement ps = con.prepareStatement("SELECT foto FROM Productos WHERE id_Producto = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void actualizarStockProducto(int cantDeCompra, int idProducto) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Productos \n"
                                                        + "SET cantidad_Producto = cantidad_Producto - ?\n"
                                                        + "WHERE id_Producto = ?");
            ps.clearParameters();
            ps.setInt(1, cantDeCompra);
            ps.setInt(2, idProducto);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public void modificarFoto(int idP, Producto p) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Productos \n"
                    + "		SET foto = Convert(Varbinary(max), ?)\n"
                    + "		WHERE id_Producto = ?");
            ps.clearParameters();
            ps.setBytes(1, p.getFoto());
            ps.setInt(2, idP);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
    
    
    
    public ArrayList<DTOproducto> obtenerProductosPorCategoria(int idRubro) {
        ArrayList<DTOproducto> listado = new ArrayList<DTOproducto>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCTOS WHERE ID_RUBRO=?");
            while (rs.next()) {
                int id = rs.getInt("id_Producto");
                String nombre = rs.getString("descripcion_Producto");
                String marca = rs.getString("descripcion_Marca");
                String rubro = rs.getString("descripcion_Rubro");
                int cantidad = rs.getInt("cantidad_Producto");
                double costo = rs.getDouble("costo_Producto");
                double utilidad = rs.getDouble("utilidad_Producto");
                InputStream foto = rs.getBinaryStream("foto");

                DTOproducto dto = new DTOproducto(id, nombre, marca, rubro, cantidad, costo, utilidad);
                listado.add(dto);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listado;
    }
    
   

}
