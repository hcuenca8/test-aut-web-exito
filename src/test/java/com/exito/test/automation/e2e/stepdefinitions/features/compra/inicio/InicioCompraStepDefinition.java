package com.exito.test.automation.e2e.stepdefinitions.features.compra.inicio;

import com.exito.test.automation.e2e.models.scena.Libreto;
import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.stepdefinitions.features.catalogo.CatalogoProductosStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.features.menu.MenuStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.features.portal.PortalStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.test.automation.e2e.tasks.features.catalogo.SeleccionarProductos;
import com.exito.test.automation.e2e.tasks.features.compra.inicio.IniciarCompra;
import com.exito.test.automation.e2e.userinterfaces.features.portal.PortalUI;
import com.exito.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.exito.test.automation.e2e.utils.questions.estadoelementos.questions.ElEstado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class InicioCompraStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra iniciando su proceso de compra.*")
    public static void dadoQueSeEncuentraIniciandoSuProcesoDeCompra(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        CatalogoProductosStepDefinition.dadoQueHaTerminadoDeAgregarArticulosASuCarritoDeCompras(actor,libreto);
        PortalStepDefinition.cuandoIngresaAlDetalleDeSuCarritoDeCompras();
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^da inicio a su proceso de compra.*")
    public static void cuandoIniciaSuProcesoDeCompra(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            IniciarCompra.deArticulos(libreto.getParametrosInicioCompra())
        );
    }
}
