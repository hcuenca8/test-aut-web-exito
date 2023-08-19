package com.exito.test.automation.e2e.stepdefinitions.features.menu;

import com.exito.test.automation.e2e.models.scena.Libreto;
import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.questions.PlantillaQuestion;
import com.exito.test.automation.e2e.stepdefinitions.features.portal.PortalStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.general.web.pantalla.PantallaStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.test.automation.e2e.tasks.PlantillaTask;
import com.exito.test.automation.e2e.tasks.features.menu.IrASubcategoria;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class MenuStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra sobre el menu de opciones del portal.*")
    public static void dadoQueSeEncuentraSobreElMenuDeOpcionesDelPortal(String actor)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        PortalStepDefinition.dadoQueSeEncuentraSobreElPortal(actor);
        PortalStepDefinition.cuandoSeDirigeAlMenuDeOpcionesDelPortal();
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^ingresa a una subcategoria.*")
    public static void cuandoIngresaAUnaSubcategoria(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            IrASubcategoria.delMenu(libreto.getParametrosMenuPortal())
        );
    }
}
