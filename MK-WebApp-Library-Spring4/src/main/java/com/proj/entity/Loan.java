package com.proj.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "Loan.selectAll", query = "SELECT l FROM loans l "),
        @NamedQuery(name = "Loan.deleteByBook", query = "DELETE FROM loans l WHERE l.book.id=:b_id "),
        @NamedQuery(name = "Loan.deleteByUser", query = "DELETE FROM loans l WHERE l.user.id=:u_id "),
        @NamedQuery(name = "Loan.selectByUser", query = "SELECT l FROM loans l WHERE l.user.id=:u_id ")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "loans")
public class Loan {

    @Id
    @Column(name = "id" ,nullable = false, unique = true)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToOne
    @JoinColumn(name = "id_book")
    private Book book;

    @Column(name = "loan_type")
    private String loanType;


}
