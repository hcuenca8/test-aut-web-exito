package com.exito.test.automation.e2e.tasks.features.catalogo;

import com.exito.test.automation.e2e.interactions.Detener;
import com.exito.test.automation.e2e.models.params.features.catalogo.PedidoParams;
import com.exito.test.automation.e2e.tasks.features.compra.rapida.AgregarArticulo;
import com.exito.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.catalogo.CatalogoProductosUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class SeleccionarProductos implements Task
{
    private PedidoParams parametros;

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * Para mas informacion:
         * @see TasksJavaDoc#ENLAZAR_ACCIONES
         */
        for(int i=0 ; i<parametros.getCantidad() ; i++)
        {
            List<WebElementFacade> webElements =
                CatalogoProductosUI.LST_BTN_COMPRA_RAPIDA.getTarget().resolveAllFor(actor);

            if(!webElements.isEmpty())
            {
                WebElementFacade elemento = webElements.get(
                    RandomUtils.nextInt(0,webElements.size())
                );

                actor.attemptsTo(
                    Detener.por(1).segundos(),

                    Scroll.to(elemento).andAlignToBottom(),

                    Detener.por(1).segundos(),

                    Click.on(elemento),

                    AgregarArticulo.alCarrito(parametros)
                );
            }
        }
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static SeleccionarProductos paraPedido(PedidoParams parametros)
    {
       return Tasks.instrumented(
           SeleccionarProductos.class,
           parametros
       );
    }
}
