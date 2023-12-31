package com.exito.test.automation.e2e.tasks.features.portal;

import com.exito.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.exito.test.automation.e2e.interactions.Esperar;
import com.exito.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.portal.PortalUI;
import com.exito.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class IrDetalleCarrito implements Task
{
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
        actor.attemptsTo(
            Esperar.hastaQue(PortalUI.LNK_CARRITO.getTarget())
                .este(EstadoElemento.VISIBLE)
                .porNoMasDe(Esperas.GENERAL.getTiempo()).segundos(),

            Click.on(PortalUI.LNK_CARRITO.getTarget())
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static IrDetalleCarrito deCompra()
    {
       return Tasks.instrumented(
               IrDetalleCarrito.class
       );
    }
}
