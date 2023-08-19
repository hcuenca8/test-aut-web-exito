package com.exito.test.automation.e2e.userinterfaces.features.portal;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PortalUI
{
    private PortalUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target BTN_MENU_PORTAL=
        Target.the("Menu portal")
            .located(By.id("category-menu"));

}
