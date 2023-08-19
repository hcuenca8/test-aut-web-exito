package com.exito.test.automation.e2e.constants.enums.tablasgherkin;


import com.exito.test.automation.e2e.constants.enums.tablasgherkin.features.menu.MenuPortalTblGherkin;
import com.exito.test.automation.e2e.utils.gherkin.tabla.interfaces.ITablaGherkin;

public enum TablasGherkin
{

    MENU_PORTAL(MenuPortalTblGherkin.values()),

    ;

    private final ITablaGherkin<?>[] tablaGherkin;

    TablasGherkin(ITablaGherkin<?>[] tablaGherkin)
    {
        this.tablaGherkin = tablaGherkin;
    }

    public ITablaGherkin<?>[] getTablaGherkin() {
        return tablaGherkin;
    }
}
