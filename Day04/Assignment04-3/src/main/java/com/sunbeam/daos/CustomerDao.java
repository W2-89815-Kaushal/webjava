package com.sunbeam.daos;

import com.sunbeam.entities.Customer;

public interface CustomerDao {
    int save(CustomerDao c);
    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);
    int updatePassword(String email, String newPassword);
    int updateCustomer(Customer c);
    int deleteById(int id);
}
