package Controlador;

import Modelo.DTOUsuario;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.Rubro;
import Modelo.Usuaio;
import Modelo.Sexo;
import Modelo.TiposDoc;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBD {

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
    public void agregarUsuario(Usuaio u) {

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("INSERT INTO Usuarios VALUES(?,?,?,?,?,?,?,?,?,?)");
            
            st.setString(1, u.getApellidoUsuario());
            st.setString(2, u.getNombreUsuario());            
            st.setInt(3, u.getSexoUsuario().getIdSexo());
            st.setInt(4, u.getTipoDocumentoUsuario().getIdTipoDoc());            
            st.setInt(5, u.getDocumentUsuario());
            st.setString(6, u.getTelefonoUsuario());
            st.setString(7, u.getDireccionUsuario());
            st.setString(8, u.getLocaidadUsuario());
            st.setString(9, u.getLoginUsuario());
            st.setString(10, u.getContraseñaUsuario());

            st.executeUpdate();

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener Combo 
    public ArrayList<Sexo> getObtenerComboSexo() {

        ArrayList<Sexo> listaSexos = new ArrayList<>();

        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM TiposSexos");
            while (rs.next()) {
                int id = rs.getInt("id_Tipo_Sexo");
                String descripcion = rs.getString("descripcion_Tipo_Sexos");

                Sexo s = new Sexo(id, descripcion);

                listaSexos.add(s);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaSexos;

    }

    //Obtener Combo
    public ArrayList<TiposDoc> getObtenerComboDocumento() {

        ArrayList<TiposDoc> listaDoc = new ArrayList<>();

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM TiposDocumentos");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Tipo_Doc");
                String descripcion = rs.getString("descripcion_Tipo_Doc");

                TiposDoc d = new TiposDoc(id, descripcion);

                listaDoc.add(d);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return listaDoc;

    }

    //validar inicio de sesion usuario cliente
    public int validarInicioSesionCliente(Usuaio u) {
        int r = 1;
        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT login_Usuario, contraseña_Usuario FROM Usuarios WHERE login_Usuario=? AND contraseña_Usuario=?");
            st.setString(1, u.getLoginUsuario());
            st.setString(2, u.getContraseñaUsuario());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                r = r + 1;
                u.setLoginUsuario(rs.getString("login_Usuario"));
                u.setContraseñaUsuario(rs.getString("contraseña_Usuario"));
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        if (r == 2) {
            return 2;
        } else {
            return 0;
        }
    }

    public Usuaio getObtenerUsuario(String loginUsuario) {

        Usuaio u = null;

        try {
            abrirConexion();
            PreparedStatement st = con.prepareStatement("SELECT * FROM Usuarios WHERE login_Usuario = ?");
            st.setString(1, loginUsuario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id_Usuario");
                String apellido = rs.getString("apellido_Usuario");
                String nomb = rs.getString("nombre_Usuario");

                u = new Usuaio(id, apellido, nomb);

            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return u;

    }

    //Obtener datos cliente mediante correo para ${cliente}
//    public ArrayList<Usuaio> obtenerCliente(String logueo) {
//        ArrayList<Usuaio> listadoCliente = new ArrayList<Usuaio>();
//        try {
//            abrirConexion();
//            PreparedStatement st = con.prepareStatement("select c.id_Usuario, c.nombre_Usuario, c.apellido_Usuario, c.telefono\n"
//                                                        + "from Clientes c, LoginUsers lu\n"
//                                                        + "where c.idUsuario = lu.idUsuario\n"
//                                                        + "and lu.correo = ?");
//            st.setString(1, logueo);
//            ResultSet rs = st.executeQuery();
//            if (rs.next()) {
//                
//                int idCliente = rs.getInt("idCliente");                
//                String nom = rs.getString("nombre");
//                String ape = rs.getString("apellido");
//
//                Usuaio u = new Usuaio(idCliente, nom, ape);
//                
//                listadoCliente.add(u);
//            }
//            rs.close();
//        } catch (Exception exc) {
//            exc.printStackTrace();
//        } finally {
//            cerrarConexion();
//        }
//        return listadoCliente;
//    }
    //obtener clientes update mediante correo
    public DTOUsuario obtenerClientesUpdate(int u) {
        DTOUsuario usuario = null;
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT U.APELLIDO_USUARIO,\n"
                    + "	   U.NOMBRE_USUARIO,\n"
                    + "	   S.DESCRIPCION_TIPO_SEXOS,\n"
                    + "	   D.DESCRIPCION_TIPO_DOC,\n"
                    + "	   U.DOCUMENTO_USUARIO,\n"
                    + "	   U.TELEFONO_USUARIO,\n"
                    + "	   U.DIRECCION_USUARIO,\n"
                    + "	   U.LOCALIDAD_USUARIO,\n"
                    + "	   US.DESCRIPCION_TIPO_USUARIO\n"
                    + "FROM USUARIOS U,\n"
                    + "	 TIPOSDOCUMENTOS D,\n"
                    + "	 TIPOSSEXOS S,\n"
                    + "	 TIPOSUSUARIOS US\n"
                    + "WHERE U.TIPO_SEXO_USUARIO = S.ID_TIPO_SEXO\n"
                    + "AND U.TIPO_DOC_USUARIO = D.ID_TIPO_DOC\n"
                    + "AND U.TIPO_USUARIO = US.ID_TIPO_USUARIO");
            ps.setInt(1, u);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nombre = rs.getString("");
                String apellido = rs.getString("");
                String tipoDoc = rs.getString("");
                String sexo = rs.getString("");
                int documento = rs.getInt("");
                String telefono = rs.getString("");
                String direccion = rs.getString("");
                String localidad = rs.getString("");
                String usuar = rs.getString("");
                String contra = rs.getString("");

                usuario = new DTOUsuario(u, nombre, apellido, tipoDoc, sexo, documento, telefono, direccion, localidad, usuar, contra);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return usuario;
    }

    //obtener clientes update mediante correo
    public Usuaio obtenerCliente(int u) {
        Usuaio usuario = null;
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT U.APELLIDO_USUARIO,\n"
                    + "U.NOMBRE_USUARIO,\n"
                    + "S.ID_TIPO_SEXO,\n"
                    + "D.ID_TIPO_DOC,\n"
                    + "U.DOCUMENTO_USUARIO,\n"
                    + "U.TELEFONO_USUARIO,\n"
                    + "U.DIRECCION_USUARIO,\n"
                    + "U.LOCALIDAD_USUARIO, \n"
                    + "U.LOGIN_USUARIO,\n"
                    + "U.CONTRASEÑA_USUARIO\n"
                    + "FROM USUARIOS U,\n"
                    + "TIPOSDOCUMENTOS D,\n"
                    + "TIPOSSEXOS S\n"
                    + "WHERE U.TIPO_SEXO_USUARIO = S.ID_TIPO_SEXO\n"
                    + "AND U.TIPO_DOC_USUARIO = D.ID_TIPO_DOC\n"
                    + "AND U.ID_USUARIO = ?");

            ps.setInt(1, u);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String nombre = rs.getString("nombre_Usuario");
                String apellido = rs.getString("apellido_Usuario");

                int sex = rs.getInt("id_Tipo_Sexo");
                //String s = rs.getString("descripcion_Tipo_Sexos");
                Sexo sexo = new Sexo(sex, "");

                int tipoDoc = rs.getInt("id_Tipo_Doc");
                //String d = rs.getString("descripcion_Tipo_Doc");
                TiposDoc doc = new TiposDoc(tipoDoc, "");

                int documento = rs.getInt("documento_Usuario");
                String telefono = rs.getString("telefono_Usuario");
                String direccion = rs.getString("direccion_Usuario");
                String localidad = rs.getString("localidad_Usuario");
                String usuar = rs.getString("login_Usuario");
                String contra = rs.getString("contraseña_Usuario");

                usuario = new Usuaio(u, nombre, apellido, sexo, doc, documento, telefono, direccion, localidad, usuar, contra);

            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return usuario;
    }

    //Modificar Producto
    public void modificarUsuario(Usuaio u) {
        try {

            abrirConexion();
            String sql = "UPDATE Usuarios SET apellido_Usuario=?,"
                    + " nombre_Usuario=?, tipo_Sexo_Usuario=?,"
                    + " tipo_Doc_Usuario=?, documento_Usuario=?,"
                    + " telefono_Usuario=?, direccion_Usuario=?,"
                    + " localidad_Usuario=?, login_Usuario=?,"
                    + " contraseña_Usuario=?  WHERE id_Usuario=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, u.getApellidoUsuario());
            st.setString(2, u.getNombreUsuario());
            st.setInt(3, u.getSexoUsuario().getIdSexo());
            st.setInt(4, u.getTipoDocumentoUsuario().getIdTipoDoc());
            st.setInt(5, u.getDocumentUsuario());
            st.setString(6, u.getTelefonoUsuario());
            st.setString(7, u.getDireccionUsuario());
            st.setString(8, u.getLocaidadUsuario());
            st.setString(9, u.getLoginUsuario());
            st.setString(10, u.getContraseñaUsuario());
            st.setInt(11, u.getIdUsuario());

            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

}
