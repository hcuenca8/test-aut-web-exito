package com.exito.test.automation.e2e.userinterfaces.features.catalogo;

import com.exito.test.automation.e2e.userinterfaces.javadoc.UIJavaDoc;
import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum CatalogoProductosUI implements IUserInterface
{
    BTN_MOSRAR_MAS("Mostrar más",
        "//button//div[text()='Mostrar más']"
    ),

    LST_BTN_COMPRA_RAPIDA("Compra rapida",
        "//div[contains(@class,'buyButton')]//div[@class]"
    ),
    ;

    private final String nombre;
    private final String stringSelector;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    CatalogoProductosUI(String nombre, String stringSelector){
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
