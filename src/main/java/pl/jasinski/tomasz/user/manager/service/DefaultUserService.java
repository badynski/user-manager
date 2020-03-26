package pl.jasinski.tomasz.user.manager.service;

import pl.jasinski.tomasz.user.manager.dao.UserDao;
import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;
import pl.jasinski.tomasz.user.manager.gui.model.UserModel;
import pl.jasinski.tomasz.user.manager.service.mapper.UserMapper;

import java.util.logging.Logger;

public class DefaultUserService implements UserService {
    private static final Logger LOGGER = Logger.getLogger(DefaultUserService.class.getName());
    private UserDao userDao;


//    public UserService(){
//        this.userDao =  new UserDao();
//    }


    public DefaultUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserModel create(UserModel userModel) {
        LOGGER.info("Making some stuff with the User: " + userModel);
        UserMapper userMapper = new UserMapper();
        UserEntity userEntity = userMapper.toEntity(userModel);
        UserEntity createdUserEntity = userDao.create(userEntity);
        return userMapper.fromEntity(createdUserEntity);

    }

    @Override
    public UserModel read(Long id) {
        UserEntity userEntity = userDao.read(id);
        UserMapper userMapper = new UserMapper();
        return userMapper.fromEntity(userEntity);
    }
}
