package com.iudigital.actividad.supermercado.sinHilos;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;
import com.iudigital.actividad.supermercado.sinHilos.utils.GenerarPedidos;
import com.iudigital.actividad.supermercado.sinHilos.utils.GenerarProductos;

public class Stock {
    
    private static final int numeroProductos = 90;
    
    public static void main(String[] args) {
        Producto[] A = GenerarProductos.generarProductos(numeroProductos).toArray(new Producto[0]);
        Pedido[] B = GenerarPedidos.generarPedidos(GenerarProductos.generarProductos(numeroProductos), numeroProductos).toArray(new Pedido[0]);
        
        int[] C = new int[numeroProductos];
        
        long tiempoInicio = System.currentTimeMillis();
        calcularStock(A, B, C);
        long tiempoFin = System.currentTimeMillis();
        
        int maxPedido = encontrarMaximoPedido(B);
        
        System.out.println("Stock: ");
        imprimirVector(C);
        
        System.out.println("Valor más alto en los pedidos: " + maxPedido);
        System.out.println("Tiempo de ejecución sin hilos: " + (tiempoFin - tiempoInicio)/1000 + " segundos");
    }
    
    private static void calcularStock(Producto[] A, Pedido[] B, int[] C) {
        
        for (int i=0; i<numeroProductos; i++) {
            Producto producto = A[i];
            Pedido pedido = B[i];
            
            int existenciaProducto = producto.getExistencia();
            int cantidadPedido = obtenerCantidadPedido(pedido, producto);
            
            if (existenciaProducto == cantidadPedido) {
                producto.setExistencia(0);
            } else if (existenciaProducto > cantidadPedido) {
                producto.setExistencia(existenciaProducto - cantidadPedido);
            } else {
                producto.setExistencia(0);
            }
            
            C[i] = cantidadPedido;
        }
    }
    
    private static int obtenerCantidadPedido(Pedido pedido, Producto producto) {
        
        int cantidad = 0;
        
        for (Producto p : pedido.getProductos()) {
            if (p.getNombre().equals(producto.getNombre())) {
                cantidad++;
            }
        }
        
        return cantidad;
    }
    
    private static int encontrarMaximoPedido(Pedido[] B) {
        
        int maxPedido = 0;
        
        for (Pedido pedido : B) {
            for (Producto producto : pedido.getProductos()) {
                if (producto.getExistencia()>maxPedido) {
                    maxPedido = producto.getExistencia();
                }
            }
        }
        return maxPedido;
    }
    
    private static void imprimirVector(int[] vector) {
        
        for (int i=0; i<vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}