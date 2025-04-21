package com.sunbeam.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired private JdbcTemplate jdbcTemplate;
    @Autowired private CustomerRowMapper rowMapper;

    public int save(Customer c) {
        String sql = "INSERT INTO customers(name, password, mobile, address, email, birth) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, c.getName(), c.getPassword(), c.getMobile(), c.getAddress(), c.getEmail(), c.getBirth());
    }

    public Customer findByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE email=?", rowMapper, email);
    }

    public Customer findByEmailAndPassword(String email, String password) {
        return jdbcTemplate.queryForObject("SELECT * FROM customers WHERE email=? AND password=?", rowMapper, email, password);
    }

    public int updatePassword(String email, String newPassword) {
        return jdbcTemplate.update("UPDATE customers SET password=? WHERE email=?", newPassword, email);
    }

    public int updateCustomer(Customer c) {
        return jdbcTemplate.update("UPDATE customers SET name=?, mobile=?, address=?, email=?, birth=? WHERE id=?",
                c.getName(), c.getMobile(), c.getAddress(), c.getEmail(), c.getBirth(), c.getId());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM customers WHERE id=?", id);
    }

	@Override
	public int save(CustomerDao c) {
		return 0;
	}
}
