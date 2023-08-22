package com.exito.test.automation.e2e.constants.enums.tablasgherkin;


import com.exito.test.automation.e2e.constants.enums.tablasgherkin.features.catalogo.PedidoTblGherkin;
import com.exito.test.automation.e2e.constants.enums.tablasgherkin.features.compra.inicio.InicioCompraTblGherkin;
import com.exito.test.automation.e2e.constants.enums.tablasgherkin.features.menu.MenuPortalTblGherkin;
import com.exito.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;
import com.exito.test.automation.e2e.utils.models.params.interfaces.IParam;

public enum TablasGherkin
{
    MENU_PORTAL(MenuPortalTblGherkin.values()),
    PEDIDO(PedidoTblGherkin.values()),
    INICIO_COMPRA(InicioCompraTblGherkin.values()),
    ;

    private final ITablaGherkin<? extends IParam>[] tablaGherkin;

    TablasGherkin(ITablaGherkin<? extends IParam>[] tablaGherkin)
    {
        this.tablaGherkin = tablaGherkin;
    }

    public ITablaGherkin<? extends IParam>[] getTablaGherkin() {
        return tablaGherkin;
    }
}
