package com.proj.command.commandimpl;

import com.proj.command.Command;
import com.proj.entity.jpa.Book;
import com.proj.jpaservice.LoanServiceJPA;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 01.05.2017.
 */
public class LoanCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {


        System.out.println("in loan controller");

        System.out.println(" info :  "+request.getParameter("command")+" "+ request.getParameter("id")+" "
                                +request.getParameter("delete") );

        LoanServiceJPA ls = new LoanServiceJPA();
        if(request.getParameter("delete").equals("true")){
            ls.deleteLoan(Integer.valueOf(request.getParameter("id")));

        }
        if(request.getParameter("toDo").equals("addLoan")){
            String title = request.getParameter("loan-book");

            Book book = new Book();
            book.setTitle(title);
            //bs.insertBook(book);
            //((List<Book>)request.getSession().getAttribute("books")).add(book);
            return ConstantsUtil.BOOKS_PAGE;
        }


        return ConstantsUtil.LOANS_PAGE;
    }
}
