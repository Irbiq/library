package com.proj.service;

import com.proj.dao.LoanDAO;
import com.proj.dao.daoimpl.LoanMySQLDAO;
import com.proj.entity.jdbc.Loan;

import java.util.Collection;

public class LoanService  {

    LoanDAO ldb = new LoanMySQLDAO();

    public int insertLoan(Loan loan) {
        return 0;
    }

    public boolean deleteLoan(int id) {
        return false;
    }

    public Loan findLoan(int id) {
        return null;
    }

    public boolean updateLoan(String id) {
        return false;
    }

    public Collection<Loan> selectLoans() {
        return ldb.selectLoans();
    }
}
