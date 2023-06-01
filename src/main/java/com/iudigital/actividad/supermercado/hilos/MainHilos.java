package com.iudigital.actividad.supermercado.hilos;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;
import com.iudigital.actividad.supermercado.sinHilos.utils.GenerarPedidos;
import com.iudigital.actividad.supermercado.sinHilos.utils.GenerarProductos;

public class MainHilos {
    
    private static final int numeroProductos = 90;
    private static final int numeroHilos = 4;
    
    public static void main(String[] args) throws InterruptedException {
        Producto[] A = GenerarProductos.generarProductos(numeroProductos).toArray(new Producto[0]);
        Pedido[] B = GenerarPedidos.generarPedidos(GenerarProductos.generarProductos(numeroProductos), numeroProductos).toArray(new Pedido[0]);
        
        int[] C = new int[numeroProductos];
        
        long tiempoInicio = System.currentTimeMillis();
        calcularStockHilos(A, B, C);
        long tiempoFin = System.currentTimeMillis();
        
        int maxPedido = encontrarMaximoPedido(B);
        
        System.out.println("Stock: ");
        imprimirVector(C);
        
        System.out.println("Valor más alto en los pedidos: " + maxPedido);
        //System.out.println("Tiempo de ejecución con hilos: " + (tiempoFin - tiempoInicio) + " segundos");
    }
    
    private static void calcularStockHilos(Producto[] A, Pedido[] B, int[] C) throws InterruptedException {
        int tamanoSubarreglo = numeroProductos/numeroHilos;
        HiloStock[] hilos = new HiloStock[numeroHilos];
        
        for (int i=0; i<numeroHilos; i++) {
            int inicio = i*tamanoSubarreglo;
            int fin = (i+1)*tamanoSubarreglo;
            
            hilos[i] = new HiloStock(A, B, inicio, fin);
            hilos[i].start();
        }
        
        for (HiloStock hilo : hilos) {
            hilo.join();
        }
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
