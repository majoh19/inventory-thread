package com.iudigital.actividad.supermercado.hilos;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;

public class HiloStock extends Thread {

    private Producto[] A;
    private Pedido[] B;
    private int inicio;
    private int fin;

    public HiloStock(Producto[] A, Pedido[] B, int inicio, int fin) {
        this.A = A;
        this.B = B;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {

        for (int i = inicio; i < fin; i++) {
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
        }
    }

    private int obtenerCantidadPedido(Pedido pedido, Producto producto) {

        int cantidad = 0;

        for (Producto p : pedido.getProductos()) {
            if (p.getNombre().equals(producto.getNombre())) {
                cantidad++;
            }
        }
        return cantidad;
    }

}
