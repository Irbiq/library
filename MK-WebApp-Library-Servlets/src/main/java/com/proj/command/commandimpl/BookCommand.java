package com.proj.command.commandimpl;

import com.proj.command.Command;
import com.proj.entity.jpa.Book;
import com.proj.jpaservice.BookServiceJPA;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by ASUS on 01.05.2017.
 */
public class BookCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        BookServiceJPA bs = new BookServiceJPA();
        String toDo = request.getParameter("toDo");
        if(toDo.equals("addBook")){
            String title = request.getParameter("add-book-title");
            Book book = new Book();
            book.setTitle(title);
            bs.insertBook(book);
            ((List<Book>)request.getSession().getAttribute("books")).add(book);
            return ConstantsUtil.BOOKS_PAGE;
        }


        return null;
    }
}
