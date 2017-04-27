package main.java;

import main.java.model.Course;
import main.java.model.User;
import main.java.services.CourseService;
import main.java.services.CourseServiseImpl;
import main.java.services.UserService;
import main.java.services.UserServiceImpl;

import java.util.List;

/**
 * Created by vadim on 24.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseServiseImpl();
        List list = courseService.listCourses();
        for (Object course:
             list) {
            System.out.println(course);
        }

    }
}
