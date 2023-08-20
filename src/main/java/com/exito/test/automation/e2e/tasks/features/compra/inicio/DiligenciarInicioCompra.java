package com.exito.test.automation.e2e.tasks.features.compra.inicio;

import com.exito.test.automation.e2e.models.params.features.compra.inicio.InicioCompraParams;
import com.exito.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.compra.inicio.InicioCompraUI;
import com.exito.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class DiligenciarInicioCompra implements Task
{
    private InicioCompraParams parametros;

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

            Check.whether(TablaGherkinUtil.campoNoNull(this.parametros.getEmail()))
                .andIfSo(
                    Enter.theValue(this.parametros.getEmail())
                        .into(InicioCompraUI.TXT_EMAIL.getTarget())
                )
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static DiligenciarInicioCompra deArticulos(InicioCompraParams parametros)
    {
       return Tasks.instrumented(
           DiligenciarInicioCompra.class,
           parametros
       );
    }
}
