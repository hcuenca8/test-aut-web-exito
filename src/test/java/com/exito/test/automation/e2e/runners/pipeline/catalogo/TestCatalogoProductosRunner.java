package com.exito.test.automation.e2e.runners.pipeline.catalogo;

import com.exito.test.automation.e2e.runners.RunnerConstants;
import com.exito.test.automation.e2e.runners.javadoc.RunnersJavaDoc;
import com.exito.test.automation.e2e.utils.GeneralUtil;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


/**
 * Para mas informacion:
 * @see RunnersJavaDoc#CLASE
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    features = RunnerConstants.PACKAGE_FEATURES+"/catalogo/catalogo_productos.feature",
    glue = {RunnerConstants.PACKAGE_STEP_DEFINITIONS,RunnerConstants.PACKAGE_SETUPS},
    tags = "@CatalogoProductos and @Regresion",
    dryRun = false //Desactive, despues de comprobar la existencia/relacion entre enunciado gherkin y StepDefinition
)
public class TestCatalogoProductosRunner
{
    /**
     * Para mas informacion:
     * @see RunnersJavaDoc#CONSTRUCTOR
     */
    private TestCatalogoProductosRunner()
    {
        GeneralUtil.noPermitaInstanciar();
    }
}
