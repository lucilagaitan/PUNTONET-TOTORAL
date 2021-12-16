package Modelo;

import java.io.InputStream;


public class DTOproducto 
{
    private int idProducto;
    private String descripcionProducto;
    private String marcaProducto;
    private String rubroProducto;
    private int cantidadProducto;
    private double costoProducto;
    private double utilidadProducto;
      private byte[] foto;
    private InputStream fotoRecuperar;
    
      public DTOproducto(byte[] foto) {
        this.foto = foto;
    }

    public DTOproducto() {
    }

    public DTOproducto(int idProducto, String descripcionProducto, String marcaProducto, String rubroProducto, int cantidadProducto, double costoProducto, double utilidadProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.rubroProducto = rubroProducto;
        this.cantidadProducto = cantidadProducto;
        this.costoProducto = costoProducto;
        this.utilidadProducto = utilidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCostoProducto(double costoProducto) {
        this.costoProducto = costoProducto;
    }

    public double getCostoProducto() {
        return costoProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setRubroProducto(String rubroProducto) {
        this.rubroProducto = rubroProducto;
    }

    public String getRubroProducto() {
        return rubroProducto;
    }

    public void setUtilidadProducto(double utilidadProducto) {
        this.utilidadProducto = utilidadProducto;
    }

    public double getUtilidadProducto() {
        return utilidadProducto;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
