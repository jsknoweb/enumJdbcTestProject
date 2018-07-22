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

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jose on 22/07/18.
 */
public class JoinObjectMapExtractor implements ResultSetExtractor<Map<Integer, List<JoinObject>>> {

    @Override
    public Map<Integer, List<JoinObject>> extractData(ResultSet resultSet)
            throws SQLException, DataAccessException {

        JoinObjectMapper joinObjectMapper = new JoinObjectMapper();
        Map<Integer, List<JoinObject>> dataMap = new HashMap<>();

        while(resultSet.next()) {
            if(dataMap.get(resultSet.getInt("edad")) == null) {
                dataMap.put(resultSet.getInt("edad"), new ArrayList<>());
            }
            dataMap.get(resultSet.getInt("edad")).add(joinObjectMapper.mapRow(resultSet, resultSet.getRow()));
        }

        return dataMap;
    }
}
