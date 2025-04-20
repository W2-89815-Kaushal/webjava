package com.sunbeam.daos;
import java.sql.*;
import java.util.*;
import com.sunbeam.*;

public class BookDao implements AutoCloseable {
	 private Connection con;

	    public BookDao() throws Exception {
	        con = DbUtil.getConnection();
	    }

	    public int addBook(Book b) throws Exception {
	        String sql = "INSERT INTO books (id, name, author, subject, price) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setInt(1, b.getId());
	            stmt.setString(2, b.getName());
	            stmt.setString(3, b.getAuthor());
	            stmt.setString(4, b.getSubject());
	            stmt.setDouble(5, b.getPrice());
	            return stmt.executeUpdate();
	        }
	    }

	    public int updateBook(Book b) throws Exception {
	        String sql = "UPDATE books SET name=?, author=?, subject=?, price=? WHERE id=?";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setString(1, b.getName());
	            stmt.setString(2, b.getAuthor());
	            stmt.setString(3, b.getSubject());
	            stmt.setDouble(4, b.getPrice());
	            stmt.setInt(5, b.getId());
	            return stmt.executeUpdate();
	        }
	    }

	    public int deleteBook(int bookId) throws Exception {
	        String sql = "DELETE FROM books WHERE id=?";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setInt(1, bookId);
	            return stmt.executeUpdate();
	        }
	    }

	    public Book findBookById(int bookId) throws Exception {
	        String sql = "SELECT * FROM books WHERE id=?";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setInt(1, bookId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                Book b = new Book();
	                b.setId(rs.getInt("id"));
	                b.setName(rs.getString("name"));
	                b.setAuthor(rs.getString("author"));
	                b.setSubject(rs.getString("subject"));
	                b.setPrice(rs.getDouble("price"));
	                return b;
	            }
	            return null;
	        }
	    }

	    public List<Book> findAllBooks() throws Exception {
	        List<Book> list = new ArrayList<>();
	        String sql = "SELECT * FROM books";
	        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Book b = new Book();
	                b.setId(rs.getInt("id"));
	                b.setName(rs.getString("name"));
	                b.setAuthor(rs.getString("author"));
	                b.setSubject(rs.getString("subject"));
	                b.setPrice(rs.getDouble("price"));
	                list.add(b);
	            }
	        }
	        return list;
	    }

	    public List<Book> findBooksBySubject(String subject) throws Exception {
	        List<Book> list = new ArrayList<>();
	        String sql = "SELECT * FROM books WHERE subject=?";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setString(1, subject);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Book b = new Book();
	                b.setId(rs.getInt("id"));
	                b.setName(rs.getString("name"));
	                b.setAuthor(rs.getString("author"));
	                b.setSubject(rs.getString("subject"));
	                b.setPrice(rs.getDouble("price"));
	                list.add(b);
	            }
	        }
	        return list;
	    }

	    public List<String> findAllSubjects() throws Exception {
	        List<String> subjects = new ArrayList<>();
	        String sql = "SELECT DISTINCT subject FROM books";
	        try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                subjects.add(rs.getString("subject"));
	            }
	        }
	        return subjects;
	    }

	    @Override
	    public void close() throws Exception {
	        if (con != null) con.close();
	    }
}
