package main.java.services;

import main.java.model.User;

/**
 * Created by vadim on 24.04.2017.
 */
public interface UserService {

    User auth(String login, String password);
}
