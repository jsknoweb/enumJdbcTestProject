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
package com.example.enums.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jose on 22/07/18.
 */
public class JoinObjectMapper implements RowMapper<JoinObject> {

    @Override public JoinObject mapRow(ResultSet resultSet, int i) throws SQLException {
        JoinObject joinObject = new JoinObject();
        joinObject.setId(resultSet.getInt("id"));
        joinObject.setFirstName(resultSet.getString("first_name"));
        joinObject.setLastName(resultSet.getString("last_name"));
        joinObject.setNombre(resultSet.getString("nombre"));
        joinObject.setEdad(resultSet.getInt("edad"));
        return joinObject;
    }
}