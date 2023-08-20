package com.exito.test.automation.e2e.constants.enums;


public enum EtiquetadoComo
{
    //Etiquetas en Pantalla

    COMPRA_RAPIDA("Compra rápida"),
    ;

    private final String etiqueta;

    EtiquetadoComo(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public String enPantalla()
    {
        return this.etiqueta;
    }
}
