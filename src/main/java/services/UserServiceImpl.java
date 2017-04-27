package main.java.services;

import main.java.dao.UserDao;
import main.java.dao.UserDaoImpl;
import main.java.model.User;

public class UserServiceImpl implements UserService {

    private static UserDao userDao = new UserDaoImpl();

    @Override
    public User auth(String login, String password) {
        User user = userDao.findUserByLoginAndPassword(login, password);

        return user;
    }
}
