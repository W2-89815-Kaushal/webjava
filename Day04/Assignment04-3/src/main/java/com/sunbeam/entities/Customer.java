package com.sunbeam.entities;

import java.time.LocalDate;

public class Customer {
    private int id;
    private String name;
    private String password;
    private String mobile;
    private String address;
    private String email;
    private LocalDate birth;

    public Customer() {}
    public Customer(int id, String name, String password, String mobile, String address, String email, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.email = email;
        this.birth = birth;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

}
