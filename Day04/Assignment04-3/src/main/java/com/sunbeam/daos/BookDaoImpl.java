package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Book;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private BookRowMapper bookRowMapper;

//    public int save(Book b) {
//        String sql = "insert into books(name, author, subject, price) values(?,?,?,?)";
//        return jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getSubject(), b.getPrice());
//    }

    public int update(Book b) {
        String sql = "update books set name=?, author=?, subject=?, price=? where id=?";
        return jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getSubject(), b.getPrice(), b.getId());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from books where id=?", id);
    }

    public Book findById(int id) {
        return jdbcTemplate.queryForObject("select * from books where id=?", bookRowMapper, id);
    }

    public List<Book> findAll() {
        return jdbcTemplate.query("select * from books", bookRowMapper);
    }

    public List<Book> findBySubject(String subject) {
        return jdbcTemplate.query("select * from books where subject=?", bookRowMapper, subject);
    }

    public List<String> findAllSubjects() {
        return jdbcTemplate.query("select distinct subject from books", (rs, rowNum) -> rs.getString("subject"));
    }

	@Override
	public int save(BookDao b) {
		String sql = "insert into books(name, author, subject, price) values(?,?,?,?)";
        return jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getSubject(), b.getPrice());
	}


}
