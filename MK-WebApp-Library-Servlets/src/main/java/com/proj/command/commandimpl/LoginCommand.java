package com.proj.command.commandimpl;

import com.proj.command.Command;
import com.proj.entity.jpa.User;
import com.proj.jpaservice.UserServiceJPA;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    UserServiceJPA userService = new UserServiceJPA();

    @Override
    public String execute(HttpServletRequest req) {

        String name = req.getParameter("user-name").trim();
        String password = req.getParameter("user-password").trim();

        User user = userService.findByNameAndPassword(name,password);

        if (user!=null){
            /*--stub--*/
            req.getSession().setAttribute("isLogged",true);
            /*--------*/
            req.getSession().setAttribute("user",user);
            return ConstantsUtil.INDEX_PAGE;
        }else {
            return ConstantsUtil.LOGIN_PAGE;
        }


    }
}
