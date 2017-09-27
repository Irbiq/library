package com.proj.jpaservice;

import com.proj.entity.User;
import com.proj.exception.DbException;
import com.proj.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {

    @Autowired
    UserJPA userJPA ;

    public void insertUser(User user) throws DbException {

        userJPA.insertUser(user);
    }

    public void updateUser(User user) throws DbException {

        userJPA.updateUser(user);
    }

    public void deleteUser(int id) throws DbException {

        userJPA.deleteUser(id);
    }

    public User findById(int id) throws DbException {

        return userJPA.findById(id);
    }

    public User findByNameAndPassword(String name, String password) throws DbException {

        return userJPA.findByNameAndPassword(name, password);
    }

    public User findByName(String name ) throws DbException {

        return userJPA.findByName(name);
    }

    public List<User> selectUsers() throws DbException {

        return userJPA.selectUsers();
    }
}
