package Modelo;

import java.io.InputStream;

public class Producto 
{
    private int idProducto;
    private String descripcionProducto;
    private Marca marcaProducto;
    private Rubro rubroProducto;
    private int cantidadProducto;
    private double costoProducto;
    private double utilidadProducto;
    private byte[] foto;
    private InputStream fotoRecuperar;

    public Producto(byte[] foto) {
        this.foto = foto;
    }

    public Producto() {
    }

    public Producto(int idProducto, String descripcionProducto, Marca marcaProducto, Rubro rubroProducto, int cantidadProducto, double costoProducto, double utilidadProducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.rubroProducto = rubroProducto;
        this.cantidadProducto = cantidadProducto;
        this.costoProducto = costoProducto;
        this.utilidadProducto = utilidadProducto;
    }
    
       public Producto(int idProducto, String descripcionProducto, Marca marcaProducto, Rubro rubroProducto, int cantidadProducto, double costoProducto, double utilidadProducto, InputStream fotoRecuperar) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.rubroProducto = rubroProducto;
        this.cantidadProducto = cantidadProducto;
        this.costoProducto = costoProducto;
        this.utilidadProducto = utilidadProducto;
        this.fotoRecuperar = fotoRecuperar;
        
    }
    

    public Producto(String descripcionProducto, Marca marcaProducto, Rubro rubroProducto, int cantidadProducto, double costoProducto, double utilidadProducto, byte[] foto) {
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.rubroProducto = rubroProducto;
        this.cantidadProducto = cantidadProducto;
        this.costoProducto = costoProducto;
        this.utilidadProducto = utilidadProducto;
        this.foto = foto;
    }

    public Producto(int id, String nombre, String marca, String rubro, int cantidad, double costo, double utilidad, InputStream foto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void setMarcaProducto(Marca marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public Marca getMarcaProducto() {
        return marcaProducto;
    }

    public void setRubroProducto(Rubro rubroProducto) {
        this.rubroProducto = rubroProducto;
    }

    public Rubro getRubroProducto() {
        return rubroProducto;
    }

    public void setUtilidadProducto(double utilidadProducto) {
        this.utilidadProducto = utilidadProducto;
    }

    public double getUtilidadProducto() {
        return utilidadProducto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

 
   


}
