package com.exito.test.automation.e2e.questions.features.compra.carrito;

import com.exito.test.automation.e2e.models.dto.pedido.DetallePedido;
import com.exito.test.automation.e2e.models.dto.pedido.ProductoPedido;
import com.exito.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.general.web.pantalla.ContenidoWebUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;

import java.text.DecimalFormat;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
public class SeCompruebaLasCantidades extends SeListanLosProductos
{
    protected SeCompruebaLasCantidades(DetallePedido detallePedido) {
        super(detallePedido);
    }

    protected boolean verificaQue(Actor actor, WebElementFacade elemento,ProductoPedido productoPedido)
    {
        return elemento.containsElements(
            ContenidoWebUI.LBL_TEXTO_EXACTO.of(
                String.valueOf(productoPedido.getCantidad())
            ).getCssOrXPathSelector()
        );
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static SeCompruebaLasCantidades
    porArticulo(DetallePedido detallePedido)
    {
        return new SeCompruebaLasCantidades(detallePedido);
    }
}
