package com.iudigital.actividad.supermercado.hilos;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;
import java.util.ArrayList;
import java.util.List;

public class MainHilos {
    
    public static void main(String[] args) {
        
        Producto[] productos = generarProductos(90);
        System.out.println("Inventario inicial:");
        mostrarInventario(productos);
        
        List<Pedido> pedidos = generarPedidos(productos.length, 10);
        System.out.println("Pedidos generados:");
        
        List<HiloStock> hilos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            HiloStock hilo = new HiloStock(pedido, productos);
            hilos.add(hilo);
            hilo.start();
        }
        
        for (HiloStock hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Inventario final:");
        mostrarInventario(productos);
    }
    
    private static Producto[] generarProductos(int cantidad) {
        
        Producto[] productos = new Producto[cantidad];
        
        for (int i=0; i<cantidad; i++) {
            int idProducto = i + 1;
            int stockProducto = (int) (Math.random()*1000) + 1;
            productos[i] = new Producto(idProducto, stockProducto);
        }
        return productos;
    }
    
    private static List<Pedido> generarPedidos(int cantidadProductos, int cantidadPedidos) {
        
        List<Pedido> pedidos = new ArrayList<>();
        
        for (int i=0; i<cantidadPedidos; i++) {
            Pedido pedido = new Pedido(i + 1);
            pedidos.add(pedido);
        }
        return pedidos;
    }
    
    private static void mostrarInventario(Producto[] productos) {
        for (Producto producto : productos) {
            System.out.println("Producto " + producto.getId() + " - Stock: " + producto.getStock());
        }
    }
}
