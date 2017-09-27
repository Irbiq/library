package com.proj.jpa;

import com.proj.entity.Book;
import com.proj.exception.DbException;
import com.proj.util.JPAUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("Duplicates")
@Repository
public class BookJPA {

    public Book insertBook(Book book) throws DbException {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
        return book;
    }

    public void deleteBook(int id) throws DbException {
        Session session = JPAUtil.getSession();
        EntityTransaction transaction = session.getTransaction();
        transaction.begin();
        session.delete(session.find(Book.class, id));
        session.flush();
        transaction.commit();

    }

    public Book findBookById(int id) throws DbException {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Book b = em.find(Book.class, id);
        transaction.commit();
        return b;
    }

    public void updateBook(Book book) throws DbException {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(book);
        transaction.commit();
    }

    public List<Book> selectBooks() throws DbException {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Book.selectAll");
        List<Book> books = query.getResultList();
        return books;
    }
}
