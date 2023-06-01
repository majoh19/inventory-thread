package com.iudigital.actividad.supermercado.sinHilos.utils;

import com.iudigital.actividad.supermercado.sinHilos.models.Pedido;
import com.iudigital.actividad.supermercado.sinHilos.models.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerarPedidos {
    
    public static List<Pedido> generarPedidos(List<Producto> productos, int existencia) {
        
        List<Pedido> pedidos = new ArrayList<>();
        Random random = new Random();
        
        for (int i=0; i<existencia; i++) {
            String nombreCliente = "Cliente " + (i+1);
            List<Producto> productosPedido = generarProductosPedido(productos);
            
            Pedido pedido = new Pedido(nombreCliente, productosPedido);
            pedidos.add(pedido);
        }
        return pedidos;
    }
    
    private static List<Producto> generarProductosPedido(List<Producto> productos) {
        List<Producto> productosPedido = new ArrayList<>();
        Random random = new Random();
        
        int cantidadProductos = random.nextInt(10) + 1;
        
        for (int i=0; i<cantidadProductos; i++) {
            int indexProducto = random.nextInt(productos.size());
            Producto producto = productos.get(indexProducto);
            productosPedido.add(producto);
        }
        return productosPedido;
    }
}
