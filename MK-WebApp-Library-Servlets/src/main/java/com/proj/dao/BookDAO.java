package com.proj.dao;

import com.proj.entity.jdbc.Book;

import java.util.Collection;


public interface BookDAO {

    int insertBook(Book book);
    boolean deleteBook(int id);
    Book findBook(int id);
    boolean updateBook(int id);
    Collection<Book> selectBooks();

}
