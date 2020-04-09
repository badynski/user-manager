package pl.jasinski.tomasz.user.manager.dao;

import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabaseDao {

    public static final String URL = "jdbc:h2:~/test;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE;FILE_LOCK=SOCKET;";

    public List<UserEntity> list() throws SQLException {
//
//        driver manager
//        get connection
//        prepared statement
//        result set
//        close resources
        List<UserEntity> users = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                UserEntity userEntity = new UserEntity();

                long id = resultSet.getLong("ID");
                userEntity.setId(id);

                userEntity.setName(resultSet.getString("NAME"));
                userEntity.setLogin(resultSet.getString("LOGIN"));
                userEntity.setPassword(resultSet.getString("PASSWORD").toCharArray());
                userEntity.setEmail(resultSet.getString("EMAIL"));

                users.add(userEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public UserEntity create(UserEntity userEntity) {
        try (Connection connection = DriverManager.getConnection(URL, "sa", "sa");
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER VALUES(?, ?, ?, ?, ?)")) {
            preparedStatement.setLong(1, userEntity.getId());
            preparedStatement.setString(2, userEntity.getName());
            preparedStatement.setString(3, userEntity.getLogin());
            preparedStatement.setString(4, String.valueOf(userEntity.getPassword()));
            preparedStatement.setString(5, userEntity.getEmail());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userEntity;
    }

    public UserEntity read (long id){
        return null;
//        TODO uzupełnić metodę.
    }
    public UserEntity update (long id, UserEntity userEntity){
        return null;
//        TODO uzupelnic
    }
    public void delete (long id){
//        TODO uzupelnic
    }
}
