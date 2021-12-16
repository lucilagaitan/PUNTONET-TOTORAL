package Modelo;

public class Marca 
{
    private int idMarca;
    private String descripcionMarca;

    public Marca() {
    }

    public Marca(int idMarca, String descripcionMarca) {
        this.idMarca = idMarca;
        this.descripcionMarca = descripcionMarca;
    }

    public void setDescripcionMarca(String descripcionMarca) {
        this.descripcionMarca = descripcionMarca;
    }

    public String getDescripcionMarca() {
        return descripcionMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdMarca() {
        return idMarca;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
