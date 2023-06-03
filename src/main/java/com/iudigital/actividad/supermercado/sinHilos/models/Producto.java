package com.iudigital.actividad.supermercado.sinHilos.models;

import java.util.Random;

public class Producto {
    
    private int id;
    private int stock;

    public Producto(int id, int stock) {
        this.id = id;
        this.stock = generarStockAleatorio();
    }

    public int getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    private int generarStockAleatorio() {
        Random random = new Random();
        return random.nextInt(100);
    }
}

