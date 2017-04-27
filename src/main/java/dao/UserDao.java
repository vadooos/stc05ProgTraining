package main.java.dao;

import main.java.model.*;
/**
 * Created by vadim on 24.04.2017.
 */
public interface UserDao extends Dao<Integer, User>{
    User findUserByLoginAndPassword(String login, String password);
}
