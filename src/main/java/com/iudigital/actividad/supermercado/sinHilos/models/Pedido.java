package com.iudigital.actividad.supermercado.sinHilos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private int idCliente;
    private List<Producto> productos;

    public Pedido(int idCliente) {
        this.idCliente = idCliente;
        this.productos = generarProductosAleatorios();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    private List<Producto> generarProductosAleatorios() {
        List<Producto> productos = new ArrayList<>();
        Random random = new Random();
        int cantidadProductos = random.nextInt(10) + 1; // Genera una cantidad aleatoria entre 1 y 10 (puedes ajustar el rango según tus necesidades)

        for (int i = 0; i < cantidadProductos; i++) {
            int idProducto = i + 1;
            int stockProducto = random.nextInt(100) + 1;
            Producto producto = new Producto(idProducto, stockProducto);
            productos.add(producto);
        }

        return productos;
    }
}
