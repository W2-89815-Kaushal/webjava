package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.entities.Customer;
@Component
public class CustomerRowMapper implements RowMapper<Customer> {
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("password"),
            rs.getString("mobile"),
            rs.getString("address"),
            rs.getString("email"),
            rs.getDate("birth").toLocalDate()
        );
    }
}
