package main.java.dao;

import main.java.model.User;
import main.java.services.ConnectionPool;
import org.apache.log4j.Logger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;


public class UserDaoImpl implements UserDao{
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    public Collection<User> getAll() {
        throw new NotImplementedException();
    }

    @Override
    public User getById(Integer id) {
        throw new NotImplementedException();
    }

    public Integer insert(User user) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement( "insert into user (role_id, user_login, user_password, user_first_name, user_last_name) values (?, ?, ?, ?, ?)")) {
            statement.setInt(1, user.getRole().getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.executeQuery();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public void update(User entity) {
        throw new NotImplementedException();
    }

    public void delete(User entity) {
        throw new NotImplementedException();
    }

    public User findUserByLoginAndPassword(String login, String md5Password) {
        User user = null;

        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement( "SELECT * FROM user WHERE user_login = ? AND user_password = ?")) {

            statement.setString(1, login);
            statement.setString(2, md5Password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User createEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getString("user_login"),
                resultSet.getString("user_password"),
                resultSet.getString("user_first_name"),
                resultSet.getString("user_last_name"));
    }
}
