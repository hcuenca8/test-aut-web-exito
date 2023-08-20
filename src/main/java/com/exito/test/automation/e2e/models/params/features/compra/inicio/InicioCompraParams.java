package com.exito.test.automation.e2e.models.params.features.compra.inicio;

import com.exito.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class InicioCompraParams
{

    private String email;

    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static InicioCompraParams crearParams(String email)
    {
        return InicioCompraParams.builder()
                .email(email)
                .build();
    }
}
