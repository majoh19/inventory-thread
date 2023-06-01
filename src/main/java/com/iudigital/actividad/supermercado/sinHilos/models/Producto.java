package com.iudigital.actividad.supermercado.sinHilos.models;

public class Producto {
    
    private int existencia;
    private String nombre;
    private float precio;

    public Producto(int existencia, String nombre, float precio) {
        this.existencia = existencia;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    
}
