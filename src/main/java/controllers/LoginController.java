package main.java.controllers;

import main.java.model.User;
import main.java.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;


@Controller
@SessionAttributes("userLogin")
public class LoginController {
    @Autowired
    private UserService userService;


    private static final Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView login(@ModelAttribute String userLogin){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute(userLogin);
        if (userLogin != null && userLogin.length() != 0)
            modelAndView.setViewName("redirect:courses");
        else
            modelAndView.setViewName("login");

        return modelAndView;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "login", required = true) String login,
                              @RequestParam(value = "password", required = true) String password){
        ModelAndView mav = new ModelAndView();

        User user = null;
        String md5Password = DigestUtils.md5Hex(password).toUpperCase();
        try {
            user = userService.auth(login, md5Password);


        } catch (SQLException e) {
                logger.error("SQLException in LoginController.registration()");

                    /*error.setMsg("Oh sorry! Registration error, try again later");
                    mav.addObject("error", error);
                    mav.setViewName("error");*/
                    return mav;

            }

        if (user != null) {

            mav.addObject("userLogin", login);
            //mav.addObject(userLogin.toString());
            mav.setViewName("redirect:courses");
        } else {
            //error.setMsg("Failed login");
            //mav.addObject("error", error);
            //mav.setViewName("login");
        }

        return mav;
    }

}
