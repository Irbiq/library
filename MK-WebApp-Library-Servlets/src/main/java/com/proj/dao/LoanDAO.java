package com.proj.dao;

import com.proj.entity.jdbc.Loan;

import java.util.Collection;


public interface LoanDAO {
    int insertLoan(Loan loan);
    boolean deleteLoan(int id);
    Loan findLoan(int id);
    boolean updateLoan(String id);
    Collection<Loan> selectLoans();
}
