package com.proj.command.commandimpl.navigation;

import com.proj.command.Command;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

public class ToLoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return ConstantsUtil.LOGIN_PAGE;
    }
}
