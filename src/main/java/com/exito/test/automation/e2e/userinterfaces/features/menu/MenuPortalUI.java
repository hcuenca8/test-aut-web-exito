package com.exito.test.automation.e2e.userinterfaces.features.menu;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class MenuPortalUI
{
    private MenuPortalUI()
    {
        throw new UnsupportedOperationException();
    }

    public static final Target LNK_CATEGORIA=
        Target.the("Categoria: {0}")
            .locatedBy("//li//div[@class='exito-category-menu-3-x-contentCategory'][.//p[text()='{0}']]");

    public static final Target LNK_SUBCATEGORIA=
        Target.the("SubCategoria: {0}")
            .located(By.linkText("Cabeceros"));

}
