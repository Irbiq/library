package com.proj.controller;

import com.proj.entity.Book;
import com.proj.entity.Loan;
import com.proj.entity.User;
import com.proj.exception.DbException;
import com.proj.jpaservice.BookService;
import com.proj.jpaservice.LoanService;
import com.proj.util.Attributes;
import com.proj.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping(value = "/loans")
public class LoanController {

    @Autowired
    LoanService loanService;
    @Autowired
    BookService bookService;

    @RequestMapping(value = {"","/all"},method = RequestMethod.GET)
    String getLoans(HttpServletRequest request, ModelMap model){
        try {
            //request.getSession().setAttribute(Attributes.LOANS,loanService.selectLoans());
            List<Loan> loans = loanService.selectLoans();
            model.addAttribute(Attributes.LOANS,loans);
            loans.forEach(System.out::println);
            return Pages.LOANS_PAGE;
        } catch (DbException e) {
            e.printStackTrace();
        }
        return Pages.LOANS_PAGE;
    }

    @RequestMapping(value ="/add", method = RequestMethod.GET)
    String showAddLoan(Model model){

        List<Book> books = Collections.emptyList();
        try {
            books = bookService.selectBooks();
        } catch (DbException e) {
            e.printStackTrace();
        }
        model.addAttribute("books",books);
        return "addloan";
    }

    @RequestMapping(value ="/add", method = RequestMethod.POST)
    String addLoan(@RequestParam("loan-book-id") int id, @RequestParam("loan-type") String type,
                   HttpServletRequest request, ExtendedModelMap modelMap){
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        Book book = null;
        try {
            book = bookService.findBookById(id);
        } catch (DbException e) {
            e.printStackTrace();
        }
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanType(type);
        List<Loan> loans = Collections.EMPTY_LIST;
        try {
            loanService.insertLoan(loan);
            loans = loanService.selectLoans();
        } catch (DbException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute(Attributes.LOANS,loans);
        return Pages.LOANS_PAGE ;

    }

    @RequestMapping(value = "/delete")
    String deleteLoan(@RequestParam("loan-id") int id, Model model){

        List<Loan> loans = Collections.emptyList();
        try {
            loanService.deleteLoan(id);
            loans = loanService.selectLoans();
        } catch (DbException e) {
            e.printStackTrace();
        }
        model.addAttribute(Attributes.LOANS,loans);
        return Pages.LOANS_PAGE;
    }


}



