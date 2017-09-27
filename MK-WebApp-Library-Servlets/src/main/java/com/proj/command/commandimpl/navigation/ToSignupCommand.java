package com.proj.command.commandimpl.navigation;

import com.proj.command.Command;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 01.05.2017.
 */
public class ToSignupCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {

        return ConstantsUtil.SIGNUP_PAGE;
    }
}
