package main.java.services;

import main.java.dao.CourseDao;
import main.java.dao.CourseDaoImpl;
import main.java.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.ws.ServiceMode;
import java.util.List;
@Service
public class CourseServiseImpl implements CourseService {

    @Autowired
    private CourseDao courseDao = new CourseDaoImpl();



    @Override
    public void addCource(Course course) {
        courseDao.insert(course);
    }

    @Override
    public void updateCourse(Course course) {
        throw new NotImplementedException();
    }

    @Override
    public void removeCourse(int id) {
        throw new NotImplementedException();
    }

    @Override
    public Course getCourseById(int id) {
        throw new NotImplementedException();
    }

    @Override
    public List<Course> listCourses() {
        return (List<Course>) courseDao.getAll();
    }


    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }
}
