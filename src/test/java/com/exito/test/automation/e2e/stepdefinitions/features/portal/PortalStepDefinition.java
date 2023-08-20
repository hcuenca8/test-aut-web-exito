package com.exito.test.automation.e2e.stepdefinitions.features.portal;

import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.stepdefinitions.general.web.NavegadorStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.test.automation.e2e.tasks.features.portal.IrALMenuPortal;
import com.exito.test.automation.e2e.tasks.features.portal.IrDetalleCarrito;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class PortalStepDefinition
{

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra sobre el portal.*")
    public static void dadoQueSeEncuentraSobreElPortal(String actor)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        NavegadorStepDefinition.dadoQueIngresoAlNavegador(actor);
        NavegadorStepDefinition.cuandoIngresaAlPortal();
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^se dirige al menu de opciones del portal.*")
    public static void cuandoSeDirigeAlMenuDeOpcionesDelPortal()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            IrALMenuPortal.deOpciones()
        );
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^ingresa al detalle de su carrito de compras.*")
    public static void cuandoIngresaAlDetalleDeSuCarritoDeCompras()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            IrDetalleCarrito.deCompra()
        );
    }
}
