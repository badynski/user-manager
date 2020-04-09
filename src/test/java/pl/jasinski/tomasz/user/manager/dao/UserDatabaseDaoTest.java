package pl.jasinski.tomasz.user.manager.dao;

import org.junit.jupiter.api.Test;
import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;

import java.sql.SQLException;
import java.util.List;

class UserDatabaseDaoTest {

    @Test
    void list() throws SQLException {
//        given
        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();
//        when
        List<UserEntity> users = userDatabaseDao.list();
//        then
        System.out.println(users);

    }

    @Test
    void create() throws SQLException{
        //given
        UserDatabaseDao userDatabaseDao = new UserDatabaseDao();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(4L);
        userEntity.setName("Test");
        userEntity.setLogin("TestLogin");
        userEntity.setPassword(new char[]{'T','P'});
        userEntity.setEmail("test@test.pl");


        //when
        userDatabaseDao.create(userEntity);
        //then

    }
}