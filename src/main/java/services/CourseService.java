package main.java.services;

import main.java.model.Course;

import java.util.List;

/**
 * Created by vadim on 27.04.2017.
 */
public interface CourseService {
    public void addCource(Course course);
    public  void updateCourse(Course course);
    public void removeCourse(int id);
    public Course getCourseById(int id);
    public List<Course> listCourses();
}
