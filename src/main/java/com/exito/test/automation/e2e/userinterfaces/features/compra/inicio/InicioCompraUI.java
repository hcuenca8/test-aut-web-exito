package com.exito.test.automation.e2e.userinterfaces.features.compra.inicio;

import com.exito.test.automation.e2e.userinterfaces.javadoc.UIJavaDoc;
import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum InicioCompraUI implements IUserInterface
{
    TXT_EMAIL("Email: {0}",
        "//input[@name='email']"
    ),
    BTN_CONFIRMAR("Confirmar",
        "//button[@type='submit']"
    ),

    ;

    private final String nombre;
    private final String stringSelector;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    InicioCompraUI(String nombre, String stringSelector){
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
