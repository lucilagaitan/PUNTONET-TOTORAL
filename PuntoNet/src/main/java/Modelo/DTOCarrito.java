
package Modelo;

public class DTOCarrito {
    
    private int item;
    private int cantidad;
    private double subTotal;
    private Producto producto;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    

    public DTOCarrito(int item, int cantidad, double subTotal, Producto producto) {
        this.item = item;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.producto = producto;
    }

    public DTOCarrito() {
    }
       
    
}
