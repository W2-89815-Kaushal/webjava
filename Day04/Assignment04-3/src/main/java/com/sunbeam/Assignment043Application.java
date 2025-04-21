package com.sunbeam;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.daos.BookDao;
import com.sunbeam.daos.CustomerDao;
import com.sunbeam.entities.Book;
import com.sunbeam.entities.Customer;

@SpringBootApplication
public class Assignment043Application implements CommandLineRunner {

	@Autowired private BookDao bookDao;
    @Autowired private CustomerDao customerDao;
    
	public static void main(String[] args) {
		SpringApplication.run(Assignment043Application.class, args);
	}
	
	public void run(String... args) throws Exception {
        Book b = new Book(0, "JAVA COMPLETE REFERENCE", "SCHILDT", "JAVA", 520.0);
        bookDao.save(b);

        List<Book> books = bookDao.findAll();
        books.forEach(System.out::println);

        Customer c = new Customer(0, "Kaushal", "kaushal", "9999999999", "Pune", "kaushal@sunbeam.com", LocalDate.of(2000, 1, 1));
        customerDao.save(c);

}
}
