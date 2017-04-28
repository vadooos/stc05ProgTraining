package main.java.controllers;

import main.java.model.Course;
import main.java.services.CourseService;
import main.java.services.CourseServiseImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vadim on 25.04.2017.
 */
public class CourseListServlet extends HttpServlet {
    private CourseService courseService = new CourseServiseImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String) req.getSession().getAttribute("userLogin");
        req.setAttribute("studentHello", "Ваш логин: " + login);
        List<Course> courses = courseService.listCourses();
//        courses = new ArrayList<>();
        courses.add(new Course(90, "test"));
       //List<String> courses = new ArrayList<>();
       //courses.add("kjdslkjdklsa");
       //courses.add("jfdkljfksd");
        req.setAttribute("coursesList", courses);
        req.getRequestDispatcher("/courses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
