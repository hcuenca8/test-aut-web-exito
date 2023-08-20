package com.exito.test.automation.e2e.questions.features.compra.carrito;

import com.exito.test.automation.e2e.models.dto.pedido.DetallePedido;
import com.exito.test.automation.e2e.models.dto.pedido.ProductoPedido;
import com.exito.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.compra.carrito.CarritoCompraUI;
import com.exito.test.automation.e2e.userinterfaces.general.web.pantalla.ContenidoWebUI;
import com.exito.test.automation.e2e.utils.parametros.ParamsUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SeListanLosProductos implements Question<Boolean>
{
    private DetallePedido detallePedido;

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ANSWERED_BY
     */
    @Override
    public Boolean answeredBy(Actor actor)
    {
        /**
         * Para mas informacion:
         * @see QuestionsJavaDoc#ENLAZAR_VALIDACIONES_VERIFICACIONES
         */

        boolean resultado = true;

        /*
        HashMap<String, ProductoPedido> hmProductosPedido =
            (HashMap<String, ProductoPedido>)this.detallePedido.getHmProductos().clone();

        List<WebElementFacade> lstArticulos =
            CarritoCompraUI.LST_ARTICULOS_CARRITO.getTarget().resolveAllFor(actor);
        */
        for(ProductoPedido productoPedido : this.detallePedido.getHmProductos().values())
        {
            Target articuloCarrito = CarritoCompraUI.ARTICULO_CARRITO.getTarget(productoPedido.getNombre());
            actor.attemptsTo(
                Scroll.to(articuloCarrito).andAlignToBottom()
            );

            WebElementFacade elemento = articuloCarrito.resolveFor(actor);

            if(!this.verificaQue(actor,elemento,productoPedido))
            {
                resultado = false;
                break;
            }
        }

        return resultado;
    }

    protected boolean verificaQue(Actor actor, WebElementFacade elemento, ProductoPedido productoPedido){
        return elemento.isVisible();
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static SeListanLosProductos agregados(DetallePedido detallePedido)
    {
        return SeListanLosProductos.builder()
            .detallePedido(detallePedido)
            .build();
    }
}
