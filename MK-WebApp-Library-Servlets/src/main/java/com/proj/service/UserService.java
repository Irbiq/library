package com.proj.service;

import com.proj.dao.UserDAO;
import com.proj.dao.daoimpl.UserMySQLDAO;
import com.proj.entity.jdbc.User;

import java.util.Collection;


public class UserService {

    UserDAO ud = new UserMySQLDAO();

    public boolean loginUser(String name, String password){

        return ud.loginUser(name, password);
    }

    public int insertUser(User pUser) {
        return 0;
    }

    public boolean deleteUser(int id) {
        return false;
    }

    public User findUser(int id) {
        return null;
    }

    public boolean updateUser(User user) {
        return false;
    }

    public Collection<User> selectUsers() {
        return null;
    }


}
