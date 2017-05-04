package main.java.services;

import main.java.model.Course;
import main.java.model.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface UserService {

    public void addUser(User user);
    public  void updateUser(User user);
    public void removeUser(int id);
    public Course getUserById(int id);
    public List<User> listUsers();
    User auth(String login, String password) throws SQLException;
}
