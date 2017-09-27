package com.proj.command.commandimpl;

import com.proj.command.Command;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        /*--stub--*/
        request.getSession().setAttribute("isLogged",false);

        request.getSession().setAttribute("user",null);
        /*--------*/
       // request.getSession().invalidate();
        return ConstantsUtil.INDEX_PAGE;
    }
}
