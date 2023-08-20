package com.exito.test.automation.e2e.userinterfaces.features.compra.carrito;

import com.exito.test.automation.e2e.userinterfaces.javadoc.UIJavaDoc;
import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum CarritoCompraUI implements IUserInterface
{
    LST_ARTICULOS_CARRITO("Articulos",
        "//div[contains(@class,'itemCartContent')]"
    ),
    ARTICULO_CARRITO("articulo: {0}",
        "//div[contains(@class,'itemCartContent')][.//*[text()='{0}']]"
    ),

    ;

    private final String nombre;
    private final String stringSelector;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    CarritoCompraUI(String nombre, String stringSelector){
        this.nombre = nombre;
        this.stringSelector = stringSelector;
    }

    @Override
    public String getStringSelector() {
        return this.stringSelector;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
