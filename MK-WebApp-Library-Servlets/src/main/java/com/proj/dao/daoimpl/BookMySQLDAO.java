package com.proj.dao.daoimpl;

import com.proj.dao.BookDAO;
import com.proj.dbmanager.DBManager;
import com.proj.entity.jdbc.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


@SuppressWarnings("Duplicates")

public class BookMySQLDAO implements BookDAO {


    private final static Logger logger = LogManager.getLogger(BookMySQLDAO.class); ///////!!!!!!!!//////////

    private static String insertBookQuery = "INSERT INTO  `books` (id,title) VALUES (?,?)";
    private static String deleteBookQuery = "DELETE FROM  `books` WHERE id = ?";
    private static String selectBooksQuery = "SELECT * FROM  `books`";
    private static String findBookQuery = "SELECT * FROM `books` WHERE id = ?";

    @Override
    public int insertBook(Book book) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(insertBookQuery);
            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.executeUpdate();
            return book.getId();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean deleteBook(int id) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(deleteBookQuery);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public Book findBook(int id) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(findBookQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Book book = null;
            while (rs.next()) {
                book = new Book(rs.getInt(1),
                        rs.getString(2));
            }
            return book;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean updateBook(int id) {
        return false;
    }

    @Override
    public Collection<Book> selectBooks() {
        List<Book> books;
        try (Connection connection = DBManager.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectBooksQuery);
            books = new ArrayList<>();
            int id;
            String title;
            while (rs.next()) {
                id = rs.getInt(1);
                title = rs.getString(2);
                books.add(new Book(id, title));
            }
            return books;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return Collections.emptyList();
    }

}
