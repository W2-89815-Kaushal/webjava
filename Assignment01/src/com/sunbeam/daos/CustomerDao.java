package com.sunbeam.daos;
import java.sql.*;
import java.util.*;
import com.sunbeam.*;

public class CustomerDao implements AutoCloseable {
	private Connection con;

    public CustomerDao() throws Exception {
        con = DbUtil.getConnection();
    }

    public int addCustomer(Customer c) throws Exception {
        String sql = "INSERT INTO customers (id, name, password, mobile, address, email, birth) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, c.getId());
            stmt.setString(2, c.getName());
            stmt.setString(3, c.getPassword());
            stmt.setString(4, c.getMobile());
            stmt.setString(5, c.getAddress());
            stmt.setString(6, c.getEmail());
            stmt.setString(7, c.getBirth());
            return stmt.executeUpdate();
        }
    }

    public Customer findCustomerByEmail(String email) throws Exception {
        String sql = "SELECT * FROM customers WHERE email=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setPassword(rs.getString("password"));
                c.setMobile(rs.getString("mobile"));
                c.setAddress(rs.getString("address"));
                c.setEmail(rs.getString("email"));
                c.setBirth(rs.getString("birth"));
                return c;
            }
            return null;
        }
    }

    public Customer findCustomerByEmailAndPassword(String email, String password) throws Exception {
        String sql = "SELECT * FROM customers WHERE email=? AND password=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setPassword(rs.getString("password"));
                c.setMobile(rs.getString("mobile"));
                c.setAddress(rs.getString("address"));
                c.setEmail(rs.getString("email"));
                c.setBirth(rs.getString("birth"));
                return c;
            }
            return null;
        }
    }

    public int updateCustomer(Customer c) throws Exception {
        String sql = "UPDATE customers SET name=?, password=?, mobile=?, address=?, email=?, birth=? WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getPassword());
            stmt.setString(3, c.getMobile());
            stmt.setString(4, c.getAddress());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getBirth());
            stmt.setInt(7, c.getId());
            return stmt.executeUpdate();
        }
    }

    public int changePassword(int id, String newPassword) throws Exception {
        String sql = "UPDATE customers SET password=? WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, newPassword);
            stmt.setInt(2, id);
            return stmt.executeUpdate();
        }
    }

    public int deleteCustomer(int id) throws Exception {
        String sql = "DELETE FROM customers WHERE id=?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }

    @Override
    public void close() throws Exception {
        if (con != null) con.close();
    }
}
