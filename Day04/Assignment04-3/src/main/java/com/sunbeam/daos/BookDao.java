package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Book;

public interface BookDao {
    int save(BookDao b);
    int update(Book b);
    int deleteById(int id);
    Book findById(int id);
    List<Book> findAll();
    List<Book> findBySubject(String subject);
    List<String> findAllSubjects();
}
