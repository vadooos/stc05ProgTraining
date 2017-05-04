package main.java.controllers;

import main.java.model.Course;
import main.java.model.User;
import main.java.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
@SessionAttributes("userLogin")
public class CourseListController {

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView courses(@ModelAttribute("userLogin") String userLogin/*@ModelAttribute String userLogin*/ /*Model model*/) throws ServletException, IOException {
        List<Course> courses = courseService.listCourses();
        courses.add(new Course(90, "test"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courses");

        modelAndView.getModelMap().addAttribute("coursesList", courses);
        modelAndView.getModelMap().addAttribute("coursesList2", userLogin);

        return modelAndView;
    }
}
