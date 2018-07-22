//@formatter:off
/**
 *  $$Id$$
 *       . * .
 *     * RRRR  *    Copyright (c) 2018 EUIPO: European Union Intellectual
 *   .   RR  R   .  Property Office (trade marks and designs)
 *   *   RRR     *
 *    .  RR RR  .   ALL RIGHTS RESERVED
 *     * . _ . *
 */
//@formatter:on
package com.example.enums.model;

import org.springframework.stereotype.Component;

/**
 * Created by Jose on 10/05/18.
 */
public enum EstadoOKCalidad implements EstadosReferencia {

    OK_ESTADO_CALIDAD("ESTADO_CALIDAD", "DESCRIPCION ESTADO_CALIDAD OK"),
    KO_ESTADO_CALIDAD("KO_MUESTRA_CONFORMIDAD", "DESCRIPCION ESTADO_CALIDAD KO")
    ;

    private String key;
    private String value;

    EstadoOKCalidad(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override public String getKey() {
        return null;
    }

    @Override public String getValue() {
        return null;
    }
}
