package com.iudigital.actividad.supermercado.sinHilos.models;

import java.util.List;

public class Pedido {
    
    private String nombreCliente;
    private List<Producto> productos;

    public Pedido(String nombreCliente, List<Producto> productos) {
        this.nombreCliente = nombreCliente;
        this.productos = productos;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }
    
}
