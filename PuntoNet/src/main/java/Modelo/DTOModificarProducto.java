package Modelo;

import java.util.ArrayList;

public class DTOModificarProducto 
{
    public Producto producto;
    public ArrayList<Marca> marca;
    public ArrayList<Rubro> rubro;

    public DTOModificarProducto() {
    }

    public DTOModificarProducto(Producto producto, ArrayList<Marca> marca, ArrayList<Rubro> rubro) {
        this.producto = producto;
        this.marca = marca;
        this.rubro = rubro;
    }

    public void setMarca(ArrayList<Marca> marca) {
        this.marca = marca;
    }

    public ArrayList<Marca> getMarca() {
        return marca;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setRubro(ArrayList<Rubro> rubro) {
        this.rubro = rubro;
    }

    public ArrayList<Rubro> getRubro() {
        return rubro;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
