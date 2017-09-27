package com.proj.jpaservice;

import com.proj.entity.Book;
import com.proj.exception.DbException;
import com.proj.jpa.BookJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookService {

    @Autowired
    BookJPA bookJPA ;

    public void insertBook(Book book)throws DbException {

        bookJPA.insertBook(book);
    }

    public Book findBookById(int id) throws DbException {

        return bookJPA.findBookById(id);
    }

    public void updateBook(Book book)throws DbException{
        
        bookJPA.updateBook(book);
    }

    public void deleteBook(int id)throws DbException{

        bookJPA.deleteBook(id);
    }

    public List<Book> selectBooks()throws DbException{

        return bookJPA.selectBooks();
    }

}
