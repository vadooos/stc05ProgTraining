package main.java.dao;

import main.java.model.*;

import java.sql.SQLException;

/**
 * Created by vadim on 24.04.2017.
 */
public interface UserDao extends Dao<Integer, User>{
    User findUserByLoginAndPassword(String login, String md5Password) throws SQLException;
}
