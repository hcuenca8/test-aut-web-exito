package com.exito.test.automation.e2e.models.dto.pedido;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ProductoPedido
{
    private String nombre;

    private String precio;

    private double valorPrecio;

    private int cantidad;

    public static ProductoPedido crearProducto(String nombre, String precio, int cantidad)
    {
        //$ 239.000
        double valorPrecio = Double.parseDouble(
            precio.trim()
                .replaceAll("[$ .]","")
                .replace(",",".")
        );

        return ProductoPedido.builder()
                .nombre(nombre)
                .precio(precio)
                .valorPrecio(valorPrecio)
                .cantidad(cantidad)
                .build();
    }

    public double getTotal(){
        return this.getCantidad()*this.getValorPrecio();
    }
}
