package com.exito.test.automation.e2e.tasks.features.compra.rapida;

import com.exito.test.automation.e2e.constants.enums.EtiquetadoComo;
import com.exito.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.exito.test.automation.e2e.interactions.Detener;
import com.exito.test.automation.e2e.interactions.Esperar;
import com.exito.test.automation.e2e.models.params.features.catalogo.PedidoParams;
import com.exito.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.compra.rapida.CompraRapidaUI;
import com.exito.test.automation.e2e.userinterfaces.general.web.pantalla.ContenidoWebUI;
import com.exito.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import org.apache.commons.lang3.RandomUtils;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class AgregarArticulo implements Task
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
        actor.attemptsTo(
            Scroll.to(CompraRapidaUI.LNK_CONTINUAR_COMPRANDO.getTarget())
                .andAlignToBottom()
        );

        if(CompraRapidaUI.BTN_AGREGAR_AL_CARRITO.getTarget().resolveFor(actor).isVisible()){
            actor.attemptsTo(
                Click.on(CompraRapidaUI.BTN_AGREGAR_AL_CARRITO.getTarget())
            );
        }

        int cantidad = this.calcularCantidadXArticulo(actor);

        for(;cantidad>1;cantidad--)
        {
            actor.attemptsTo(
                Detener.por(1).segundos(),

                Click.on(CompraRapidaUI.BTN_SUMAR_CANTIDAD.getTarget())
            );
        }

        actor.attemptsTo(
            Scroll.to(CompraRapidaUI.LNK_CONTINUAR_COMPRANDO.getTarget())
                .andAlignToBottom(),

            Click.on(CompraRapidaUI.LNK_CONTINUAR_COMPRANDO.getTarget())
        );
    }

    private <T extends Actor> int calcularCantidadXArticulo(T actor){
        int cantidad = RandomUtils.nextInt(1,11);

        String precioArticulo =
            CompraRapidaUI.LBL_VALOR_ARTICULO.getTarget()
                .resolveFor(actor).getText();

        String nombreArticulo = CompraRapidaUI.LBL_NOMBRE_ARTICULO.getTarget()
            .resolveFor(actor).getText();

        this.parametros.getDetalle().agregarProducto(nombreArticulo,precioArticulo,cantidad);

        return cantidad;
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static AgregarArticulo alCarrito(PedidoParams parametros)
    {
       return Tasks.instrumented(
           AgregarArticulo.class,
           parametros
       );
    }
}
