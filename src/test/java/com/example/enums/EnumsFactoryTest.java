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
package com.example.enums;

import com.example.enums.model.EstadosFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Jose on 10/05/18.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { ApplicationConfig.class })
//@WebAppConfiguration

public class EnumsFactoryTest {


    @Autowired EstadosFactory estadosFactory;

    @Test
    public void setEstadosFactory() {
        System.out.println(estadosFactory.tipoEstados);
    }
}
