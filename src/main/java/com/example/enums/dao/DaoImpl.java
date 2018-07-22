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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Jose on 21/07/18.
 */
@Repository
public class DaoImpl {

    private static final Logger log = LoggerFactory.getLogger(DaoImpl.class);

    @Autowired JdbcTemplate jdbcTemplate;

    @Autowired NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void executeProcess() {
//        List<String> firstName =joinTables();
//        System.out.println(firstName);
        createTemporaryTable();
        Map<Integer, List<JoinObject>> result = joinAndReturnResult();
        System.out.println(result);
    }

    public Integer getUsers() {

        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM DEMO", Integer.class);
        return result;
    }

    public Integer createTemporaryTable() {

        jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
        jdbcTemplate.execute("CREATE TABLE customers(" +
                "id bigint(2), first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("1 John Woo", "2 John Woo", "3 John Woo", "4 Jeff Dean", "5 Josh Bloch", "6 Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s %s", name[0], name[1], name[2])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT INTO customers(id, first_name, last_name) VALUES (?,?,?)", splitUpNames);

        int result = jdbcTemplate.queryForObject("SELECT SUM(id) FROM customers", Integer.class);
        return result;
    }

    private List<String> joinTables() {
        SqlParameterSource nameParameters = new MapSqlParameterSource().addValue("edad", 18);
        return namedParameterJdbcTemplate.queryForList(
                "SELECT nombre FROM DEMO WHERE EDAD = :edad", nameParameters, String.class);

    }

    private Map<Integer, List<JoinObject>> joinAndReturnResult() {

        String joinQuery = "SELECT d.id, d.nombre, d.edad, cu.first_name, cu.last_name FROM DEMO d "
                + "JOIN CUSTOMERS cu ON d.id = cu.id "
                + "WHERE EDAD = :edad";
        SqlParameterSource nameParameters = new MapSqlParameterSource().addValue("edad", 18);
//        return namedParameterJdbcTemplate.query(joinQuery, nameParameters, new JoinObjectMapper());
        return namedParameterJdbcTemplate.query(joinQuery, nameParameters, new JoinObjectMapExtractor());

    }
}
