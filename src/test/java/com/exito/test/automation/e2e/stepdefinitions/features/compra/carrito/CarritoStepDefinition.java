package com.exito.test.automation.e2e.stepdefinitions.features.compra.carrito;

import com.exito.test.automation.e2e.models.scena.Libreto;
import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.questions.PlantillaQuestion;
import com.exito.test.automation.e2e.questions.features.compra.carrito.SeCompruebaLasCantidades;
import com.exito.test.automation.e2e.questions.features.compra.carrito.SeConservanPrecios;
import com.exito.test.automation.e2e.questions.features.compra.carrito.SeListanLosProductos;
import com.exito.test.automation.e2e.stepdefinitions.features.catalogo.CatalogoProductosStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.features.compra.inicio.InicioCompraStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.features.portal.PortalStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.general.web.pantalla.PantallaStepDefinition;
import com.exito.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.exito.test.automation.e2e.tasks.features.compra.inicio.IniciarCompra;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class CarritoStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que \"(.*)\" se encuentra revisando los articulos de su carrito de compras.*")
    public static void dadoQueSeEncuentraRevisandoLosArticulosDeSuCarrito(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        InicioCompraStepDefinition.dadoQueSeEncuentraIniciandoSuProcesoDeCompra(actor,libreto);
        InicioCompraStepDefinition.cuandoIniciaSuProcesoDeCompra(libreto);
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^deberían verse listados los productos que fueron agregados al carrito.*")
    public static void entoncesDeberianVerseListadosLosProductosQueFueronAgregadosAlCarrito()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        Protagonista.enEscena().should(
            GivenWhenThen.seeThat(
                SeListanLosProductos.agregados(
                    Protagonista.enEscena().getLibreto().getParametrosPedido().getDetalle()
                )
            )
        );
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^deberian conservarse los precios de los productos de cuando fueron elegidos.*")
    public static void entoncesDeberianConservarseLosPreciosDeLosProductosDeCuandoFueronElegidos()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        Protagonista.enEscena().should(
            GivenWhenThen.seeThat(
                SeConservanPrecios.deLosArticulos(
                    Protagonista.enEscena().getLibreto().getParametrosPedido().getDetalle()
                )
            )
        );
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^deberian verse las cantidades de cada producto que fueron elegidas.*")
    public static void entoncesDeberianVerseLasCantidadesDeCadaProductoQueFueronELegidas()
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        Protagonista.enEscena().should(
            GivenWhenThen.seeThat(
                SeCompruebaLasCantidades.porArticulo(
                    Protagonista.enEscena().getLibreto().getParametrosPedido().getDetalle()
                )
            )
        );
    }

}
