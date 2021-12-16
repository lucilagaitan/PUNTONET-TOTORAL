package Modelo;
public class Venta {
    
    private int numero_Venta;
    private String fecha_Venta;
    private Usuaio usuario;
    private TipoPago tipoPago;
    private TipoEntrega tipoEntrega;
    private double montoTotal;

    public Venta() {
    }

    public Venta(int numero_Venta, Usuaio usuario, TipoPago tipoPago, TipoEntrega tipoEntrega) {
        this.numero_Venta = numero_Venta;
        this.usuario = usuario;
        this.tipoPago = tipoPago;
        this.tipoEntrega = tipoEntrega;
    }
    
    
    public Venta(int numero_Venta, String fecha_Venta, Usuaio usuario, TipoPago tipoPago, TipoEntrega tipoEntrega, Double montoTotal) {
        this.numero_Venta = numero_Venta;
        this.fecha_Venta = fecha_Venta;
        this.usuario = usuario;
        this.tipoPago = tipoPago;
        this.tipoEntrega = tipoEntrega;
        this.montoTotal = montoTotal;
    }

    public Venta(int numero_Venta,  Usuaio usuario, TipoPago tipoPago, TipoEntrega tipoEntrega, Double montoTotal) {
        this.numero_Venta = numero_Venta;
        this.usuario = usuario;
        this.tipoPago = tipoPago;
        this.tipoEntrega = tipoEntrega;
        this.montoTotal = montoTotal;
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

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setUsuario(Usuaio usuario) {
        this.usuario = usuario;
    }

    public Usuaio getUsuario() {
        return usuario;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
