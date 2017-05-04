package main.java.dao;

import main.java.model.Course;
import main.java.services.ConnectionPool;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {
    private static final Logger logger = Logger.getLogger(CourseDaoImpl.class);

    @Override
    public Collection<Course> getAll() {
        List<Course> list = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from course");
            while (resultSet.next()){
                list.add(new Course(
                        resultSet.getInt("course_id"),
                        resultSet.getString("course_name")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Course getById(Integer id) {
        throw new NotImplementedException();
    }

    @Override
    public Integer insert(Course entity) {
        throw new NotImplementedException();
    }

    @Override
    public void update(Course entity) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Course entity) {
        throw new NotImplementedException();
    }
}
