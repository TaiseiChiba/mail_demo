package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.BussinessException;
import common.SystemException;
import entity.UserAccount;
import logic.LoginLogic;

public class LoginAction implements ActionIF {

    @Override
    public String execute(HttpServletRequest request) throws SystemException {

        String page = "top.jsp";

        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        try {
            final LoginLogic loginLogic = new LoginLogic();
            final UserAccount user = loginLogic.login(email, password);
            final HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
        } catch (final BussinessException e) {
            request.setAttribute("errorMessage", e.getMessage());
            page = "loginForm.jsp";
        }

        return page;
    }

}
