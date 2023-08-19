package com.exito.test.automation.e2e.userinterfaces.features.menu;

import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import com.exito.test.automation.e2e.userinterfaces.javadoc.UIJavaDoc;

/**
 * Para mas informacion:
 * @see UIJavaDoc#CLASE
 */
public enum MenuPortalUI implements IUserInterface
{
    LNK_CATEGORIA("Categoria: {0}",
        "//li//div[@class='exito-category-menu-3-x-contentCategory'][.//p[text()='{0}']]"
    ),
    LNK_SUBCATEGORIA("SubCategoria: {0}",
        "{0}"
    ){
        @Override
        public Target getStrategy(TargetBuilder target, String stringSelector) {
            return target.located(By.linkText(stringSelector));
        }
    },

//    public static final Target LNK_CATEGORIA=
//        Target.the("Categoria: {0}")
//            .locatedBy("//li//div[@class='exito-category-menu-3-x-contentCategory'][.//p[text()='{0}']]");
//
//    public static final Target LNK_SUBCATEGORIA=
//        Target.the("SubCategoria: {0}")
//            .located(By.linkText("Cabeceros"));

    ;

    private final String nombre;
    private final String stringSelector;

    /**
     * Para mas informacion:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    MenuPortalUI(String nombre, String stringSelector){
        this.nombre = nombre;
        this.stringSelector = stringSelector;
    }

    @Override
    public String getStringSelector() {
        return this.stringSelector;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
