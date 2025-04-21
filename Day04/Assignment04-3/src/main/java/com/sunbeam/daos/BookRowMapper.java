package com.sunbeam.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.sunbeam.entities.Book;

@Component
public class BookRowMapper implements org.springframework.jdbc.core.RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("author"),
            rs.getString("subject"),
            rs.getDouble("price")
        );
    }
}
