package com.proj.service;

import com.proj.dao.BookDAO;
import com.proj.dao.daoimpl.BookMySQLDAO;
import com.proj.entity.jdbc.Book;

import java.util.Collection;

public class BookService {

    BookDAO bd = new BookMySQLDAO();


    public int insertBook(Book pBook) {
        return this.bd.insertBook(pBook);
    }

    public boolean deleteBook(int id) {
        return bd.deleteBook(id);
    }

    public Book findBook(int id) {
        return this.bd.findBook(id);
    }

    public boolean updateBook(int id) {
        return this.bd.updateBook(id);
    }

    public Collection<Book> selectBooks() {
        return this.bd.selectBooks();
    }
}
