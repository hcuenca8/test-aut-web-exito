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
public class SeConservanPrecios extends SeListanLosProductos
{
    protected SeConservanPrecios(DetallePedido detallePedido) {
        super(detallePedido);
    }

    @Override
    protected boolean verificaQue(Actor actor, WebElementFacade elemento,ProductoPedido productoPedido)
    {
        String totalPrecioFormateado =
            new DecimalFormat("#,###.###")
                .format(productoPedido.getTotal());

        return elemento.containsElements(
            ContenidoWebUI.LBL_TEXTO.getTarget(
                    totalPrecioFormateado
            ).getCssOrXPathSelector()
        );
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static SeConservanPrecios deLosArticulos(DetallePedido detallePedido)
    {
        return new SeConservanPrecios(detallePedido);
    }
}
