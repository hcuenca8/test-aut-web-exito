package com.exito.test.automation.e2e.tasks.features.menu;

import com.exito.test.automation.e2e.models.params.features.menu.MenuPortalParams;
import com.exito.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.menu.MenuPortalUI;
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
public class IrASubcategoria implements Task
{
    private MenuPortalParams parametros;

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
            Click.on(MenuPortalUI.LNK_CATEGORIA
                .getTarget(this.parametros.getCategoria())
            ),

            Click.on(MenuPortalUI.LNK_SUBCATEGORIA
                .getTarget(this.parametros.getSubcategoria())
            )
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static IrASubcategoria delMenu(MenuPortalParams parametros)
    {
       return Tasks.instrumented(
               IrASubcategoria.class,
               parametros
       );
    }
}
