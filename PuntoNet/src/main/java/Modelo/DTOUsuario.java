package Modelo;

public class DTOUsuario 
{
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String sexoUsuario;
    private String tipoDocumentoUsuario;
    private int documentUsuario;
    private String telefonoUsuario;
    private String direccionUsuario;
    private String locaidadUsuario;
    private String loginUsuario;
    private String contraseñaUsuario;

    public DTOUsuario() {
    }

    public DTOUsuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String sexoUsuario, String tipoDocumentoUsuario, int documentUsuario, String telefonoUsuario, String direccionUsuario, String locaidadUsuario, String loginUsuario, String contraseñaUsuario) {
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public String getTipoDocumentoUsuario() {
        return tipoDocumentoUsuario;
    }

    public void setTipoDocumentoUsuario(String tipoDocumentoUsuario) {
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
    }

    public int getDocumentUsuario() {
        return documentUsuario;
    }

    public void setDocumentUsuario(int documentUsuario) {
        this.documentUsuario = documentUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getLocaidadUsuario() {
        return locaidadUsuario;
    }

    public void setLocaidadUsuario(String locaidadUsuario) {
        this.locaidadUsuario = locaidadUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getContraseñaUsuario() {
        return contraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
