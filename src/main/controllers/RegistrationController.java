package main.controllers;

import main.java.model.Role;
import main.java.model.User;
import main.java.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userLogin")
public class RegistrationController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public ModelAndView showRegistration(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView registration(@RequestParam(value = "user_login", required = true) String login,
                                     @RequestParam(value = "user_password", required = true) String password,
                                     @RequestParam(value = "user_firstname", required = true) String firstName,
                                     @RequestParam(value = "user_lastname", required = true) String lastName){
        ModelAndView mav = new ModelAndView();
        String md5Password = DigestUtils.md5Hex(password).toUpperCase();
        User user = new User(new Role(1), login, md5Password, firstName, lastName);
        userService.addUser(user);

        logger.debug("user: " + login + " logged" );
        mav.addObject("userLogin", login);
        mav.setViewName("redirect:courses");

        return mav;
    }
}
