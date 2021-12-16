package Modelo;

public class TipoEntrega {
    
    private int id_TipoEntrega;
    private String descripcion;

    public TipoEntrega() {
    }

    public TipoEntrega(int id_TipoEntrega, String descripcion) {
        this.id_TipoEntrega = id_TipoEntrega;
        this.descripcion = descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_TipoEntrega(int id_TipoEntrega) {
        this.id_TipoEntrega = id_TipoEntrega;
    }

    public int getId_TipoEntrega() {
        return id_TipoEntrega;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
