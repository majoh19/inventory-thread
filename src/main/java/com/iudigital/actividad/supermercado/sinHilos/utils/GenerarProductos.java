package com.iudigital.actividad.supermercado.sinHilos.utils;

import com.iudigital.actividad.supermercado.sinHilos.models.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerarProductos {
    
    public static List<Producto> generarProductos(int cantidad) {
        List<Producto> productos = new ArrayList<>();
        Random random = new Random();
        
        for (int i=0; i<cantidad; i++) {
            int existencia = random.nextInt(1000);
            float precio = random.nextFloat()*100;
            String nombre = "Producto " + (i+1);
            
            Producto producto = new Producto(existencia, nombre, precio);
            productos.add(producto);
        }
        return productos;
    }
}
