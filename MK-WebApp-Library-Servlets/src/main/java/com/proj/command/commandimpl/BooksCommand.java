package com.proj.command.commandimpl;

import com.proj.command.Command;
import com.proj.entity.jpa.Book;
import com.proj.jpaservice.BookServiceJPA;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class BooksCommand implements Command {

    private static List<Book> books;
    @Override
    public String execute(HttpServletRequest request) {

        BookServiceJPA bs = new BookServiceJPA();
        if(request.getSession().getAttribute("book")==null) {
            books = bs.selectBooks();
        }
        request.getSession().setAttribute("books", books);
        bs.selectBooks().forEach(System.out::println);

        return ConstantsUtil.BOOKS_PAGE;
    }
}
