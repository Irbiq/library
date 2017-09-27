package com.proj.dao;

import com.proj.entity.jdbc.User;

import java.util.Collection;


public interface UserDAO {

    boolean loginUser(String name, String password);
    int insertUser(User user);
    boolean deleteUser(int id);
    User findUser(int id);
    boolean updateUser(User user);
    Collection<User> selectUsers();
}
