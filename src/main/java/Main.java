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
        /*CourseService courseService = new CourseServiseImpl();
        List list = courseService.listCourses();
        for (Object course:
             list) {
            System.out.println(course);
        }
*/
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "pass";

        String md5Hex = DigestUtils
                .md5Hex(password).toUpperCase();
        System.out.println(hash);
        System.out.println(md5Hex);

    }
}
