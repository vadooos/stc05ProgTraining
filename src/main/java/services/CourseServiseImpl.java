package main.java.services;

import main.java.dao.CourseDao;
import main.java.dao.CourseDaoImpl;
import main.java.model.Course;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class CourseServiseImpl implements CourseService {
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
}
