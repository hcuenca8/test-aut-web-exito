package com.exito.test.automation.e2e.models.params.features.menu;

import com.exito.test.automation.e2e.models.params.javadoc.ParamsJavaDoc;
import lombok.Builder;
import lombok.Data;


/**
 * Para mas informacion:
 * @see ParamsJavaDoc#CLASE
 */
@Builder
@Data
public class MenuPortalParams
{

    private String categoria;

    private String subcategoria;


    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREAR_PARAMS
     */
    public static MenuPortalParams crearParams(String categoria, String subcategoria)
    {
        return MenuPortalParams.builder()
                .categoria(categoria)
                .subcategoria(subcategoria)
                .build();
    }
}
