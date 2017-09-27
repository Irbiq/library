package com.proj.command.commandimpl.navigation;

import com.proj.command.Command;
import com.proj.util.ConstantsUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 02.05.2017.
 */
public class ToAddLoanCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return ConstantsUtil.TO_ADD_LOAN;
    }
}
