package com.iudigital.actividad.supermercado.hilos;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;

public class HiloStock extends Thread {
    
    private Pedido pedido;
    private Producto[] productos;

    public HiloStock(Pedido pedido, Producto[] productos) {
        this.pedido = pedido;
        this.productos = productos;
    }

    @Override
    public void run() {
        
        System.out.println("Calculando stock para el cliente " + pedido.getIdCliente());
        
        for (Producto productoPedido : pedido.getProductos()) {
            int idProducto = productoPedido.getId();
            Producto productoInventario = productos[idProducto - 1];
            
            synchronized (productoInventario) {
                int stockActual = productoInventario.getStock();
                int cantidadPedido = productoPedido.getStock();
                int cantidadComprar = calcularCantidadComprar(stockActual, cantidadPedido);
                
                productoInventario.setStock(stockActual - cantidadComprar);
                
                System.out.println("Cliente: " + pedido.getIdCliente() + 
                        " - Producto: " + idProducto + 
                        " - Stock Actual: " + stockActual + 
                        " - Cantidad Pedido: " + cantidadPedido + 
                        " - Cantidad a comprar: " + cantidadComprar + 
                        " - Nuevo Stock: " + productoInventario.getStock());
            }
        }
        
        System.out.println("Finalizó el cálculo de stock para el cliente: " + pedido.getIdCliente());
    }
    
    private int calcularCantidadComprar(int stockActual, int cantidadPedido) {
    if (stockActual >= cantidadPedido) {
        return cantidadPedido;
    } else {
        return 0;
    }
}

}