package com.proj.jpaservice;

import com.proj.entity.jpa.Book;
import com.proj.jpa.BookJPA;

import java.util.List;

/**
 * Created by ASUS on 02.05.2017.
 */
public class BookServiceJPA {

    BookJPA bjpa = new BookJPA();

    public Book insertBook(Book book){

        return bjpa.insertBook(book);
    }

    public List<Book> selectBooks(){

        return bjpa.selectBooks();
    }

}
