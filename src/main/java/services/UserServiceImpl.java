package main.java.services;

import main.java.dao.CourseDaoImpl;
import main.java.dao.UserDao;
import main.java.dao.UserDaoImpl;
import main.java.model.Course;
import main.java.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao = new UserDaoImpl();


    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void updateUser(User user) {
        throw new NotImplementedException();
    }

    @Override
    public void removeUser(int id) {
        throw new NotImplementedException();
    }

    @Override
    public Course getUserById(int id) {
        throw new NotImplementedException();
    }

    @Override
    public List<User> listUsers() {
        throw new NotImplementedException();
    }

    @Override
    public User auth(String login, String md5Password) {
        User user = userDao.findUserByLoginAndPassword(login, md5Password);

        return user;
    }

}
