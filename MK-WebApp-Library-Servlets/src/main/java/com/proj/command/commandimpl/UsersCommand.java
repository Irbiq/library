package com.proj.command.commandimpl;

import com.proj.command.Command;
import com.proj.jpaservice.UserServiceJPA;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 02.05.2017.
 */
public class UsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        UserServiceJPA us = new UserServiceJPA();

        request.getSession().setAttribute("users",us.selectUsers());

        us.selectUsers().forEach(System.out::println);

        return ConstantsUtil.USERS_PAGE;
    }
}
