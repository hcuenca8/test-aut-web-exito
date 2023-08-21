package com.exito.test.automation.e2e.userinterfaces.features.compra.rapida;

import com.exito.test.automation.e2e.userinterfaces.javadoc.UIJavaDoc;
import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum CompraRapidaUI implements IUserInterface
{
    BTN_AGREGAR_AL_CARRITO("Agregar",
        "//button[.//span[text()='Agregar']]"
    ),
    BTN_SUMAR_CANTIDAD("+",
        "//button[contains(@class,'SummaryAddToCar')]"
    ),
    LNK_CONTINUAR_COMPRANDO("Continuar comprando",
        "//p[text()='Continuar comprando']"
    ),
    LBL_VALOR_ARTICULO("Valor articulo",
        "//div[contains(@class,'quickPurchaseModalContainermodal')]//div[contains(@class,'PricePDP')]//span[contains(@class,'currencyContainer')]"
    ),
    LBL_NOMBRE_ARTICULO("Nombre articulo",
        "//div[contains(@class,'quickPurchaseModalContainermodal')]//h3//span[contains(@class,'productBrand')]"
    ),

    ;

    private final String nombre;
    private final String stringSelector;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    CompraRapidaUI(String nombre, String stringSelector){
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
