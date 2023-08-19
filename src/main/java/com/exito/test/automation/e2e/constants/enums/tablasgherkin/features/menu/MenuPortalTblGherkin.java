package com.exito.test.automation.e2e.constants.enums.tablasgherkin.features.menu;

import com.exito.test.automation.e2e.constants.enums.tablasgherkin.javadoc.TblGherkinJavaDoc;
import com.exito.test.automation.e2e.models.params.features.menu.MenuPortalParams;
import com.exito.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.exito.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.exito.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;


/**
 * Para mas informacion:
 * @see TblGherkinJavaDoc#CLASE
 */
public enum MenuPortalTblGherkin implements ITablaGherkin<MenuPortalParams>
{
    CATEGORIA("categoria_menu"),
    SUBCATEGORIA("subcategoria_menu"),
    ;

    private final String columna;

    MenuPortalTblGherkin(String columna)
    {
        this.columna = columna;
    }

    @Override
    public MenuPortalParams crearScreen(TablaGherkinUtil deLaTablaGherkin)
    {
        MenuPortalParams parametros = MenuPortalParams.crearParams(
                deLaTablaGherkin.obtener(CATEGORIA),
                deLaTablaGherkin.obtener(SUBCATEGORIA)
        );

        Protagonista.principal().getLibreto().setParametrosMenuPortal(parametros);

        return parametros;
    }

    @Override
    public String getColumna() {
        return columna;
    }
}
