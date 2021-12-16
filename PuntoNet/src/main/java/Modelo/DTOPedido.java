/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class DTOPedido {
    
    private int numVenta; 
    private double monto;
    private String fecha; 
    private int cantidadProd;

    public DTOPedido(int numVenta, double monto, String fecha, int cantidadProd) {
        this.numVenta = numVenta;
        this.monto = monto;
        this.fecha = fecha;
        this.cantidadProd = cantidadProd;
    }

    
    
    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }
    
    
    
    
    
}
