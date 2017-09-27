package com.proj.jpaservice;

import com.proj.entity.jpa.Loan;
import com.proj.jpa.LoanJPA;

import java.util.List;


public class LoanServiceJPA {

    LoanJPA ljpa = new LoanJPA();

    public List<Loan> selectLoans(){
        return ljpa.selectLoans();
    }

    public void deleteLoan(int id){
        ljpa.deleteLoan(id);
    }

}
