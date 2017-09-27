package com.proj.jpaservice;

import com.proj.entity.jpa.User;
import com.proj.jpa.UserJPA;

import java.util.List;

/**
 * Created by ASUS on 01.05.2017.
 */
public class UserServiceJPA  {

    UserJPA userJPA = new UserJPA();

    public User insertUser(User user){
        return userJPA.insertUser(user);
    }

    public void updateUser(User user){
        userJPA.updateUser(user);
    }

    public User findById(int id){
        return userJPA.findById(id);
    }

    public User findByNameAndPassword(String name , String password){
        return userJPA.findByNameAndPassword(name, password);
    }


    public List<User> selectUsers() {

       return userJPA.selectUsers();
    }






}
