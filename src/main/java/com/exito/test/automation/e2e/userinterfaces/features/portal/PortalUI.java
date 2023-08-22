package com.exito.test.automation.e2e.userinterfaces.features.portal;

import com.exito.test.automation.e2e.userinterfaces.javadoc.UIJavaDoc;
import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;

public enum PortalUI implements IUserInterface
{
    BTN_MENU_PORTAL("Menu portal",
        "category-menu"
    ){
        @Override
        public Target getStrategy(TargetBuilder target, String stringSelector) {
            return target.located(By.id(stringSelector));
        }
    },

    BTN_RESUMEN_TOTAL_COMPRA("Resumen items",
        "//div[contains(@class,'minicartQuantity')][text()='{0}']"
    ),

    LNK_CARRITO("Ir al carrito",
        "//div[contains(@class,'minicartContainer')]//a[contains(@class,'minicartLink')]"
    ),
    ;

    private final String nombre;
    private final String stringSelector;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    PortalUI(String nombre, String stringSelector){
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
