package com.sunbeam.entities;

public class Book {
    private int id;
    private String name;
    private String author;
    private String subject;
    private double price;

    public Book() {
    	
    }
    public Book(int id, String name, String author, String subject, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.subject = subject;
        this.price = price;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

    
}
