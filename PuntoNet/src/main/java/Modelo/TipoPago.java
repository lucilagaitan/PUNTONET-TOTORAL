package Modelo;

public class TipoPago 
{
    private int id_TipoPago;
    private String descripcion;

    public TipoPago() {
    }

    public TipoPago(int id_TipoPago, String descripcion) {
        this.id_TipoPago = id_TipoPago;
        this.descripcion = descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_TipoPago(int id_TipoPago) {
        this.id_TipoPago = id_TipoPago;
    }

    public int getId_TipoPago() {
        return id_TipoPago;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
    
}
