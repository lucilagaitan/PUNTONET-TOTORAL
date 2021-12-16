package Modelo;

public class DetalleVentas {
    
    private int numero_Detalle;
    private Producto producto;
    private int cantidad;
    private double monto;
    private Venta venta;

    public DetalleVentas() {
    }

    public DetalleVentas(int numero_Detalle, Producto producto, int cantidad, double monto, Venta venta) {
        this.numero_Detalle = numero_Detalle;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = monto;
        this.venta = venta;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setNumero_Detalle(int numero_Detalle) {
        this.numero_Detalle = numero_Detalle;
    }

    public int getNumero_Detalle() {
        return numero_Detalle;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Venta getVenta() {
        return venta;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
