package com.exito.test.automation.e2e.stepdefinitions.features.catalogo;

import com.exito.test.automation.e2e.models.scena.Libreto;
import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.stepdefinitions.features.menu.MenuStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.test.automation.e2e.tasks.features.catalogo.SeleccionarProductos;
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
public class CatalogoProductosStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra sobre el catalogo de productos del portal.*")
    public static void dadoQueSeEncuentraSobreElCatalogoProductosDelPortal(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        MenuStepDefinition.dadoQueSeEncuentraSobreElMenuDeOpcionesDelPortal(actor);
        MenuStepDefinition.cuandoIngresaAUnaSubcategoria(libreto);
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" ha terminado de agregar articulos a su carrito de compras.*")
    public static void dadoQueHaTerminadoDeAgregarArticulosASuCarritoDeCompras(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        CatalogoProductosStepDefinition.dadoQueSeEncuentraSobreElCatalogoProductosDelPortal(actor,libreto);
        CatalogoProductosStepDefinition.cuandoSeleccionaProductosDelCatalogo(libreto);
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^selecciona productos del catalogo.*")
    public static void cuandoSeleccionaProductosDelCatalogo(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            SeleccionarProductos.paraPedido(libreto.getParametrosPedido())
        );
    }

    @Entonces("^debería indicarse en el resumen del carrito, el total de articulos agregados.*")
    public static void entoncesDeberiaIndicarseEnELResumenDelCarritoElTotalDeArticulosAgregados()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        Protagonista.enEscena().should(
            GivenWhenThen.seeThat(
                ElEstado.deLosElementos(
                    PortalUI.BTN_RESUMEN_TOTAL_COMPRA.getTarget(
                        Protagonista.enEscena().getLibreto().getParametrosPedido().getDetalle().getCantidadTotal()
                    )
                ).sea(EstadoElemento.VISIBLE)
            )
        );
    }
}
