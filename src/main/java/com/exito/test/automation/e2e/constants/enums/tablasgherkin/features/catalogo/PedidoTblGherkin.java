package com.exito.test.automation.e2e.constants.enums.tablasgherkin.features.catalogo;

import com.exito.test.automation.e2e.constants.enums.tablasgherkin.javadoc.TblGherkinJavaDoc;
import com.exito.test.automation.e2e.models.params.features.catalogo.PedidoParams;
import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.exito.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;


/**
 * Para mas informacion:
 * @see TblGherkinJavaDoc#CLASE
 */
public enum PedidoTblGherkin implements ITablaGherkin<PedidoParams>
{
    CANTIDAD("cantidad_productos_pedido"),
    ;

    private final String columna;

    PedidoTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public PedidoParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        PedidoParams parametros = PedidoParams.crearParams(
                deLaTablaGherkin.obtener(CANTIDAD)
        );

        Protagonista.principal().getLibreto().setParametrosPedido(parametros);

        return parametros;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
