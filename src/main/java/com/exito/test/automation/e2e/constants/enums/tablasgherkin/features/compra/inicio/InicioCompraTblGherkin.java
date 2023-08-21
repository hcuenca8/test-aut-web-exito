package com.exito.test.automation.e2e.constants.enums.tablasgherkin.features.compra.inicio;

import com.exito.test.automation.e2e.constants.enums.tablasgherkin.javadoc.TblGherkinJavaDoc;
import com.exito.test.automation.e2e.models.params.features.compra.inicio.InicioCompraParams;
import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.exito.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;


/**
 * Para mas informacion:
 * @see TblGherkinJavaDoc#CLASE
 */
public enum InicioCompraTblGherkin implements ITablaGherkin<InicioCompraParams>
{
    EMAIL("email_compra"),

    ;

    private final String columna;

    InicioCompraTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public InicioCompraParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        InicioCompraParams parametros = InicioCompraParams.crearParams(
                deLaTablaGherkin.obtener(EMAIL)
        );

        Protagonista.principal().getLibreto().setParametrosInicioCompra(parametros);

        return parametros;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
