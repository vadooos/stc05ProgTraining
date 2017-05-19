package main.java.controllers;

import main.controllers_old.LoginController;
import main.java.model.Course;
import main.java.services.CourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;


@Controller
public class CourseListController {

    private final CourseService courseService;
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    public CourseListController(CourseService courseService) {
        this.courseService = courseService;
    }



    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView courses(@ModelAttribute("userLogin") String userLogin) throws ServletException, IOException {
        List<Course> courses = courseService.listCourses();
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        boolean isAdmin = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));

        if(isAdmin)
            modelAndView.setViewName("editcourses");
        else
            modelAndView.setViewName("courses");

        modelAndView.getModelMap().addAttribute("coursesList", courses);
        modelAndView.getModelMap().addAttribute("coursesList2", userLogin);

        return modelAndView;
    }
}
//ControllerAdvice - сделать обработку исключений через этот класс