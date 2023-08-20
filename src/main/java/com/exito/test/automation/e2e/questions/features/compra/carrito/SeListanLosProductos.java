package com.exito.test.automation.e2e.questions.features.compra.carrito;

import com.exito.test.automation.e2e.interactions.Detener;
import com.exito.test.automation.e2e.models.dto.pedido.DetallePedido;
import com.exito.test.automation.e2e.models.dto.pedido.ProductoPedido;
import com.exito.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.compra.carrito.CarritoCompraUI;
import com.exito.test.automation.e2e.userinterfaces.general.web.pantalla.ContenidoWebUI;
import com.exito.test.automation.e2e.utils.parametros.ParamsUtil;
import com.exito.test.automation.e2e.utils.trazas.TrazaUtil;
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

        for(ProductoPedido productoPedido : this.detallePedido.getHmProductos().values())
        {

            Target articuloCarrito = CarritoCompraUI.ARTICULO_CARRITO.getTarget(productoPedido.getNombre());
            actor.attemptsTo(
                Scroll.to(articuloCarrito).andAlignToBottom(),

                Detener.por(1).segundos()
            );

            WebElementFacade elemento = articuloCarrito.resolveFor(actor);

            if(!this.verificaQue(actor,elemento,productoPedido))
            {
                TrazaUtil.informacion("Producto: {0}, Valor: {1}, Cantidad: {2}, Total: {3}",
                    productoPedido.getNombre(), productoPedido.getValorPrecio(), productoPedido.getCantidad(),
                    productoPedido.getTotal());

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
