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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jose on 10/05/18.
 */
@Component
public class EstadosFactory {

    public List<EstadosReferencia> tipoEstados = new ArrayList<>();

    @PostConstruct
    public void init() {
        tipoEstados.add(EstadoMuestraConformidad.OK_MUESTRA_CONFORMIDAD);
        tipoEstados.add(EstadoMuestraConformidad.KO_MUESTRA_CONFORMIDAD);
        tipoEstados.add(EstadoOKCalidad.OK_ESTADO_CALIDAD);
        tipoEstados.add(EstadoOKCalidad.KO_ESTADO_CALIDAD);

    }

}
