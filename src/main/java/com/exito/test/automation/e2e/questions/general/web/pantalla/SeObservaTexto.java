package com.exito.test.automation.e2e.questions.general.web.pantalla;

import com.exito.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.exito.test.automation.e2e.userinterfaces.general.web.pantalla.ContenidoWebUI;
import com.exito.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.exito.test.automation.e2e.utils.questions.estadoelementos.questions.ElEstado;
import com.exito.test.automation.e2e.utils.userinterfaces.web.interfaces.IUserInterface;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
@Builder
public class SeObservaTexto implements Question<Boolean>
{
    private List<String> textos;

    private EstadoElemento este;

    private boolean exacto;

    private static final String INDICADOR_TEXTO_EXACTO = "\\|";

    private static final String RGX_INDICADOR_TEXTO_EXACTO = "(^\\\\"+INDICADOR_TEXTO_EXACTO+")|(\\\\"+INDICADOR_TEXTO_EXACTO+"$)";

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ANSWERED_BY
     */
    @Override
    public Boolean answeredBy(Actor actor)
    {
        /**
         * Para mas informacion:
         * @see QuestionsJavaDoc#ENLAZAR_VALIDACIONES_VERIFICACIONES
         */

        boolean resultado = true;

        for(String texto : this.textos)
        {
            if( texto!=null &&  !texto.isEmpty()  )
            {
                resultado = this.validarTexto(actor,texto);

                if( !resultado ) {
                    break;
                }
            }
        }

        return resultado;
    }

    private boolean validarTexto(Actor actor,String texto){
        IUserInterface lblTexto;

        boolean fueXIndicadorTextoExacto = texto.startsWith(SeObservaTexto.INDICADOR_TEXTO_EXACTO)
            && texto.endsWith(SeObservaTexto.INDICADOR_TEXTO_EXACTO);

        if( fueXIndicadorTextoExacto
            ||  this.exacto
        ) {
            if(fueXIndicadorTextoExacto){
                texto = texto.replaceAll(SeObservaTexto.RGX_INDICADOR_TEXTO_EXACTO,StringUtils.EMPTY);
            }

            lblTexto = ContenidoWebUI.LBL_TEXTO_EXACTO;
        }else{
            lblTexto = ContenidoWebUI.LBL_TEXTO;
        }

        return ElEstado.deLosElementos(
                lblTexto.getTarget(texto)
            ).sea(this.este)
            .answeredBy(actor);
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static SeObservaTexto enPantalla(EstadoElemento este, boolean exacto,String texto)
    {
        char chrPrimerCaracter = texto.charAt(0);
        String strPrimerCaracter = String.valueOf(chrPrimerCaracter);

        String separador = Character.isLetterOrDigit(chrPrimerCaracter)
            || strPrimerCaracter.equals(SeObservaTexto.INDICADOR_TEXTO_EXACTO)
            ? null
            : Pattern.quote(strPrimerCaracter);

        List<String> textos = separador==null
            ?   Arrays.asList(texto)
            :   Arrays.asList(texto.split(separador))
            ;

        return SeObservaTexto.builder()
            .este(este)
            .textos(textos)
            .exacto(exacto)
            .build();
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static SeObservaTexto enPantalla(EstadoElemento este, boolean exacto, String ... textos)
    {
        return SeObservaTexto.builder()
            .este(este)
            .textos(Arrays.asList(textos))
            .exacto(exacto)
            .build();
    }
}

