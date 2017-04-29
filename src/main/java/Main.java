package main.java;

import com.google.common.hash.HashCode;
import main.java.model.Course;
import main.java.model.User;
import main.java.services.CourseService;
import main.java.services.CourseServiseImpl;
import main.java.services.UserService;
import main.java.services.UserServiceImpl;
import com.google.common.io.Files;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by vadim on 24.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.addUser(new User("Vadimka", "1111", "qwer", "qwer"));

    }
}
