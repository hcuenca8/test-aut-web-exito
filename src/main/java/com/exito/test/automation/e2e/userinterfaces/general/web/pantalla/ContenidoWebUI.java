package com.exito.test.automation.e2e.userinterfaces.general.web.pantalla;

import com.exito.test.automation.e2e.userinterfaces.javadoc.UIJavaDoc;
import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;

public enum ContenidoWebUI implements IUserInterface
{

    LBL_TEXTO("texto similar a: {0}",
        "//*[contains(text(),'{0}')]"
    ),
    LBL_TEXTO_EXACTO("exactamente el texto: {0}",
        "//*[text()='{0}']"
    ),


//    public static final Target LBL_TEXTO=
//        Target.the("texto similar a: {0}")
//            .locatedBy("//*[contains(text(),'{0}')]");
//
//    public static final Target LBL_TEXTO_EXACTO=
//        Target.the("exactamente el texto: {0}")
//            .locatedBy("//*[text()='{0}']");

    ;

    private final String nombre;
    private final String stringSelector;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    ContenidoWebUI(String nombre, String stringSelector){
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
