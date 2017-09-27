package com.proj.command.commandimpl;

import com.proj.command.Command;
import com.proj.jpaservice.LoanServiceJPA;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

public class LoansCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {

        LoanServiceJPA ls = new LoanServiceJPA();

        request.getSession().setAttribute("loans",ls.selectLoans());

        ls.selectLoans().forEach(System.out::println);

        return ConstantsUtil.LOANS_PAGE;
    }
}
