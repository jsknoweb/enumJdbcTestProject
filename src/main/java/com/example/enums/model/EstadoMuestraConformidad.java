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
public enum EstadoMuestraConformidad implements EstadosReferencia {

    OK_MUESTRA_CONFORMIDAD("OK_MUESTRA_CONFORMIDAD", "DESCRIPCION OK"),
    KO_MUESTRA_CONFORMIDAD("KO_MUESTRA_CONFORMIDAD", "DESCRIPCION KO")
    ;

    private String key;
    private String value;

    EstadoMuestraConformidad(String key, String value) {
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
