package com.exito.test.automation.e2e.tasks.features.portal;

import com.exito.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.features.portal.PortalUI;
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
public class IrALMenuPortal implements Task
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
            Click.on(PortalUI.BTN_MENU_PORTAL.getTarget())
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static IrALMenuPortal deOpciones()
    {
       return Tasks.instrumented(
               IrALMenuPortal.class
       );
    }
}
