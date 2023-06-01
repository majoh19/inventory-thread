package com.iudigital.actividad.supermercado.sinHilos;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;

public class Stock {
    
    public static int calcularCompra(Producto producto, Pedido pedido) {
        
        int existencia = producto.getExistencia();
        int cantidad = pedido.getCantidad();
        
        if (existencia == cantidad) {
            return existencia;
        } else if (cantidad > existencia) {
            return 2 * (cantidad - existencia);
        } else {
            return cantidad;
        }
    }
    
    public static int encontrarMayorPedido(Pedido[] pedidos) {
        int mayorPedido = 0;
        
        for (Pedido pedido : pedidos) {
            int cantidad = pedido.getCantidad();
            if (cantidad > mayorPedido) {
                mayorPedido = cantidad;
            }
        }
        return mayorPedido;
    }
}
