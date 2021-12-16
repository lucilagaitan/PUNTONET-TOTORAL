
package Modelo;

public class Rubro 
{
    private int idRubro;
    private String descripcionRubro;

    public Rubro() {
    }

    public Rubro(int idRubro, String descripcionRubro) {
        this.idRubro = idRubro;
        this.descripcionRubro = descripcionRubro;
    }

    public void setDescripcionRubro(String descripcionRubro) {
        this.descripcionRubro = descripcionRubro;
    }

    public String getDescripcionRubro() {
        return descripcionRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public int getIdRubro() {
        return idRubro;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
