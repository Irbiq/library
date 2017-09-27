package com.proj.controller;

import com.proj.entity.Loan;
import com.proj.entity.User;
import com.proj.exception.DbException;
import com.proj.jpaservice.LoanService;
import com.proj.jpaservice.UserService;
import com.proj.util.Attributes;
import com.proj.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;


@Controller
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private LoanService loanService;

    @RequestMapping(value = {"/users"})
    String getUsers(Model modelMap, HttpServletRequest request) {

        List<User> users = Collections.emptyList();
        try {
            users = userService.selectUsers();
        } catch (DbException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute(Attributes.USERS, users);

        return Pages.USERS_PAGE;
    }

    @RequestMapping(value = {"/users/delete"})
    String deleteUser(@RequestParam("user-delete-id") int id, Model modelMap, HttpServletRequest request) {

        List<User> users = Collections.emptyList();
        try {
            loanService.deleteByUser(id);
            userService.deleteUser(id);
            users = userService.selectUsers();
        } catch (DbException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute(Attributes.USERS, users);

        return Pages.USERS_PAGE;
    }

    @RequestMapping(value = {"/users/update"}, method = RequestMethod.POST)
    String updateUser(@RequestParam("user-update-id") int id, @RequestParam("user-new-name") String name, Model modelMap, HttpServletRequest request) {

        List<User> users = Collections.emptyList();
        try {
            User user = userService.findById(id);

            user.setName(name);
            userService.updateUser(user);

            users = userService.selectUsers();
        } catch (DbException e) {
            e.printStackTrace();
        }

        modelMap.addAttribute(Attributes.USERS, users);
        return Pages.USERS_PAGE;
    }

    @RequestMapping(value = {"/users/update"}, method = RequestMethod.GET)
    String showUpdateUser(Model modelMap) {

        List<User> users = Collections.EMPTY_LIST;
        try {
            users = userService.selectUsers();
        } catch (DbException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute(Attributes.USERS, users);
        return Pages.UPDATE_USER;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    String login(@RequestParam("user-name") String name, @RequestParam("user-password") String password,
                 HttpServletRequest request, ExtendedModelMap modelMap) {

        try {
            User user = userService.findByNameAndPassword(name, password);
            if (user != null) {
                request.getSession().setAttribute(Attributes.USER, user);
                List<Loan> loans = loanService.selectLoans();
                modelMap.addAttribute(Attributes.LOANS, loans);
                /*request.getSession().setAttribute(Attributes.LOANS, loanService.selectLoans());*/
                loans.forEach(System.out::println);
                return Pages.LOANS_PAGE;
            } else {
                return Pages.LOGIN_PAGE;
            }
        } catch (DbException ex) {
            return Pages.ERROR;
        }
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET})
    String showSignup() {
        return Pages.SIGNUP_PAGE;
    }


    @RequestMapping(value = "/signup", method = {RequestMethod.POST})
    String signup(@RequestParam("user-name") String name, @RequestParam("user-password") String password,
                  @RequestParam("user-role") String role) {
        try {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setRole(role);
            userService.insertUser(user);
            return Pages.LOGIN_PAGE;
        } catch (DbException e) {
            e.printStackTrace();
        }
        return Pages.SIGNUP_PAGE;
    }

    @RequestMapping(value = "/logout")
    public String logoutUser(HttpSession session) {

        session.setAttribute("user", null);
        session.invalidate();
        return Pages.LOGIN_PAGE;
    }
}
