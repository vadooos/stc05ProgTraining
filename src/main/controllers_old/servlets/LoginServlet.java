package main.controllers_old.servlets;

import main.java.services.UserService;
import main.java.services.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class LoginServlet extends HttpServlet {


    private UserService userService = new UserServiceImpl();
    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.
                processInjectionBasedOnServletContext(this,
                        config.getServletContext());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);

        if (req.getParameter("logout")!=null){
            req.getSession().setAttribute("userLogin", null);
            //req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String md5Password = DigestUtils.md5Hex(password).toUpperCase();

        try {
            if (userService.auth(login, md5Password) != null){
                req.getSession().setAttribute("userLogin", login);
                logger.debug("user: " + login + " logged" );
                resp.sendRedirect(req.getContextPath() + "/courses");
            } else {
                req.setAttribute("servletMsg", "Неудача");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
