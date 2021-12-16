
package Modelo;

public class DTODetalleVentas {
    
    private int numero_Detalle;
    private String producto;
    private int idProd;
    private int cantidad;
    private double monto;
    private int venta;

    public DTODetalleVentas(int numero_Detalle, String producto, int idProd, int cantidad, double monto, int venta) {
        this.numero_Detalle = numero_Detalle;
        this.producto = producto;
        this.idProd = idProd;
        this.cantidad = cantidad;
        this.monto = monto;
        this.venta = venta;
    }

    
    
    

    public DTODetalleVentas(int idProd, int cantidad, double monto, int venta) {
        this.idProd = idProd;
        this.cantidad = cantidad;
        this.monto = monto;
        this.venta = venta;
    }

    public DTODetalleVentas() {
    }

    public DTODetalleVentas(int numero_Detalle, String producto, int cantidad, double monto, int venta) {
        this.numero_Detalle = numero_Detalle;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = monto;
        this.venta = venta;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
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

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getVenta() {
        return venta;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
