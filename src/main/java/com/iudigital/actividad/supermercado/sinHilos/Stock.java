package com.iudigital.actividad.supermercado.sinHilos;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;
import java.util.List;

public class Stock {
    
    public static void calcularStock(List<Pedido> pedidos, Producto[] productos) {
        
        for (Pedido pedido : pedidos) {
            for (Producto productoPedido : pedido.getProductos()) {
                int idProducto = productoPedido.getId();
                Producto productoInventario = productos[idProducto - 1];
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
            System.out.println("Finalizó el cálculo de stock para el cliente: " + pedido.getIdCliente());
        }
    }
    
    private static int calcularCantidadComprar(int stockActual, int cantidadPedido) {
        if (stockActual >= cantidadPedido) {
            return cantidadPedido;
        } else {
            return 0;
        }
    }
}
