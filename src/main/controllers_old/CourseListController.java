package main.controllers_old;

import main.java.model.Course;
import main.java.services.CourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;


@Controller
@SessionAttributes("userLogin")
public class CourseListController {

    private final CourseService courseService;
    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    public CourseListController(CourseService courseService) {
        this.courseService = courseService;
    }
    //ControllerAdvice - сделать обработку исключений через этот класс


    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView courses(@ModelAttribute("userLogin") String userLogin) throws ServletException, IOException {
        List<Course> courses = courseService.listCourses();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courses");

        modelAndView.getModelMap().addAttribute("coursesList", courses);
        modelAndView.getModelMap().addAttribute("coursesList2", userLogin);

        return modelAndView;
    }

    @RequestMapping(value = "/editcourses", method = RequestMethod.GET)
    public ModelAndView editCourses(@ModelAttribute("userLogin") String userLogin) throws ServletException, IOException {
        List<Course> courses = courseService.listCourses();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("editcourses");
        modelAndView.getModelMap().addAttribute("coursesList", courses);

        return modelAndView;
    }

    @RequestMapping(value = "/editcourses/add", method = RequestMethod.POST)
    public ModelAndView addCourse(/*@RequestParam(value = "course_id", required = true) int id,*/
                            @RequestParam(value = "course_name", required = true) String name){
        ModelAndView modelAndView = new ModelAndView();
        Course course = new Course(name);
        courseService.addCource(course);
        logger.info("Added course: " + name);
        List<Course> courses = courseService.listCourses();

        modelAndView.setViewName("editcourses");
        modelAndView.getModelMap().addAttribute("coursesList", courses);

        return modelAndView;
    }
}
