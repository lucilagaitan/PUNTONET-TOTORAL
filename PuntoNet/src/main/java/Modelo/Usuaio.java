package Modelo;

public class Usuaio 
{
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private Sexo sexoUsuario;
    private TiposDoc tipoDocumentoUsuario;
    private int documentUsuario;
    private String telefonoUsuario;
    private String direccionUsuario;
    private String locaidadUsuario;
    private String loginUsuario;
    private String contraseñaUsuario;
    
    
    public Usuaio() {
    }

    public Usuaio(int idUsuario, String loginUsuario, String contraseñaUsuario) {
        this.idUsuario = idUsuario;
        this.loginUsuario = loginUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }
    
    //constructor para el alta de usuarios
    public Usuaio(String apellidoUsuario, String nombreUsuario, Sexo sexoUsuario, TiposDoc tipoDocumentoUsuario, int documentUsuario, String telefonoUsuario, String direccionUsuario, String locaidadUsuario, String loginUsuario, String contraseñaUsuario) {
              
        this.apellidoUsuario = apellidoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.sexoUsuario = sexoUsuario;
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
        this.documentUsuario = documentUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.locaidadUsuario = locaidadUsuario;
        this.loginUsuario = loginUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }
    

    
    
    public Usuaio(int idUsuario, String nombreUsuario, String apellidoUsuario, Sexo sexoUsuario, TiposDoc tipoDocumentoUsuario, int documentUsuario, String telefonoUsuario, String direccionUsuario, String locaidadUsuario, String loginUsuario, String contraseñaUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.sexoUsuario = sexoUsuario;
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
        this.documentUsuario = documentUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.locaidadUsuario = locaidadUsuario;
        this.loginUsuario = loginUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }

   

   
    
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public void setDocumentUsuario(int documentUsuario) {
        this.documentUsuario = documentUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setLocaidadUsuario(String locaidadUsuario) {
        this.locaidadUsuario = locaidadUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setSexoUsuario(Sexo sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }
    

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public void setTipoDocumentoUsuario(TiposDoc tipoDocumentoUsuario) {
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public int getDocumentUsuario() {
        return documentUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getLocaidadUsuario() {
        return locaidadUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Sexo getSexoUsuario() {
        return sexoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public TiposDoc getTipoDocumentoUsuario() {
        return tipoDocumentoUsuario;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
