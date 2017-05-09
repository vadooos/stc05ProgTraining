package main.controllers.servlets;

import main.java.model.Course;
import main.java.services.CourseService;
import main.java.services.CourseServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseListServlet extends HttpServlet {
    @Autowired
    private CourseService courseService = new CourseServiseImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("userLogin");
        req.setAttribute("yourLogin", "Ваш логин: " + login);
        List<Course> courses = courseService.listCourses();
        courses.add(new Course(90, "test"));
        req.setAttribute("coursesList", courses);
        req.getRequestDispatcher("/courses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/login").forward(req, resp);
        req.getSession().setAttribute("userLogin", null);
    }
}
