package main.controllers.servlets;

import main.java.model.Role;
import main.java.model.User;
import main.java.services.UserService;
import main.java.services.UserServiceImpl;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vadim on 24.04.2017.
 */
public class RegistrationServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    @Autowired
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("user_login");
        String password = req.getParameter("user_password");
        String md5Password = DigestUtils.md5Hex(password).toUpperCase();
        String firstName = req.getParameter("user_firstname");
        String lastName = req.getParameter("user_lastname");
        User user = new User(new Role(1), login, md5Password, firstName, lastName);
        userService.addUser(user);

        req.getSession().setAttribute("userLogin", login);
        logger.debug("user: " + login + " logged" );
        resp.sendRedirect(req.getContextPath() + "/courses");
    }


}
