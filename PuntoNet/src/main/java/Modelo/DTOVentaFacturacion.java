/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David
 */
public class DTOVentaFacturacion {

    private int nFactura;
    private String cliente;
    private String tipoPago;
    private String tipoEntrega;
    private float total;

    public DTOVentaFacturacion(int nFactura, String cliente, String tipoPago, String tipoEntrega, float total) {
        this.nFactura = nFactura;
        this.cliente = cliente;
        this.tipoPago = tipoPago;
        this.tipoEntrega = tipoEntrega;
        this.total = total;
    }

    public int getnFactura() {
        return nFactura;
    }

    public void setnFactura(int nFactura) {
        this.nFactura = nFactura;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
}
