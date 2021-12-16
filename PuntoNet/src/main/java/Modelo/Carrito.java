package Modelo;

public class Carrito 
{
    private int item;
    private int idProducto;
    private String descripcionProducto;
    private Marca marcaProducto;
    private Rubro rubroProducto;
    private double precioVenta;
    private int cantidadProducto;
    private double subTotal;

    public Carrito() {
    }

    public Carrito(int item, int idProducto, String descripcionProducto, Marca marcaProducto, Rubro rubroProducto, double precioVenta, int cantidadProducto, double subTotal) {
        this.item = item;
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.rubroProducto = rubroProducto;
        this.precioVenta = precioVenta;
        this.cantidadProducto = cantidadProducto;
        this.subTotal = subTotal;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Marca getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(Marca marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public Rubro getRubroProducto() {
        return rubroProducto;
    }

    public void setRubroProducto(Rubro rubroProducto) {
        this.rubroProducto = rubroProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
    
}
