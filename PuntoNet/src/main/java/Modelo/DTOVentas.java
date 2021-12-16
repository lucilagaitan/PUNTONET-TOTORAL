package Modelo;

public class DTOVentas 
{
    private int numero_Venta;
    private String fecha_Venta;
    private int usuario;
    private int tipoPago;
    private int tipoEntrega;
    private float total;

    public DTOVentas() {
    }

    public DTOVentas(int usuario, int tipoPago, int tipoEntrega, float total) {
        this.usuario = usuario;
        this.tipoPago = tipoPago;
        this.tipoEntrega = tipoEntrega;
        this.total = total;
    }
    
    //(id, fecha, nombre, pago, entrega)
    
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setFecha_Venta(String fecha_Venta) {
        this.fecha_Venta = fecha_Venta;
    }

    public String getFecha_Venta() {
        return fecha_Venta;
    }

    public void setNumero_Venta(int numero_Venta) {
        this.numero_Venta = numero_Venta;
    }

    public int getNumero_Venta() {
        return numero_Venta;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(int tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    
}
