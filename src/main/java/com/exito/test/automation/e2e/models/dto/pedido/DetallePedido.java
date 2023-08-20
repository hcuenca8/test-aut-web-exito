package com.exito.test.automation.e2e.models.dto.pedido;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;


@Builder
@Data
public class DetallePedido
{
    private HashMap<String,ProductoPedido> hmProductos;

    private int cantidadTotal;

    private double valorTotal;

    public void agregarProducto(String nombre, String precio, int cantidad)
    {
        ProductoPedido productoPedido = this.getHmProductos().get(nombre);

        if(productoPedido==null) {
            productoPedido = ProductoPedido.crearProducto(nombre,precio,cantidad);
            this.getHmProductos().put(
                productoPedido.getNombre(),
                productoPedido
            );
        }else{
            productoPedido.setCantidad(productoPedido.getCantidad()+cantidad);
        }

        this.cantidadTotal += productoPedido.getCantidad();
        this.valorTotal += productoPedido.getTotal();
    }
}
