package com.exito.test.automation.e2e.models.params.features.catalogo;

import com.exito.test.automation.e2e.models.dto.pedido.DetallePedido;
import com.exito.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class PedidoParams
{
    private int cantidad;

    private DetallePedido detalle;

    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static PedidoParams crearParams(String cantidad)
    {
        return PedidoParams.builder()
                .cantidad(Integer.parseInt(cantidad))
                .build();
    }

    public DetallePedido getDetalle() {
        if(detalle==null){
            detalle = DetallePedido.builder()
                .hmProductos(new LinkedHashMap<>())
                .build();
        }
        return detalle;
    }
}
