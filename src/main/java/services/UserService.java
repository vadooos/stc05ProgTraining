package main.java.services;

import main.java.model.Course;
import main.java.model.User;

import java.util.List;

/**
 * Created by vadim on 24.04.2017.
 */
public interface UserService {

    public void addUser(User user);
    public  void updateUser(User user);
    public void removeUser(int id);
    public Course getUserById(int id);
    public List<User> listUsers();
    User auth(String login, String password);
}
