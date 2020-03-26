package pl.jasinski.tomasz.user.manager.service;

import pl.jasinski.tomasz.user.manager.dao.UserDao;
import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;
import pl.jasinski.tomasz.user.manager.gui.model.UserModel;
import pl.jasinski.tomasz.user.manager.service.mapper.UserMapper;

import java.util.logging.Logger;

public class VipUserService implements UserService {
    private static final Logger LOGGER = Logger.getLogger(VipUserService.class.getName());

    private UserDao userDao;
    private UserMapper userMapper;

    public VipUserService(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public UserModel create(UserModel userModel) {
        LOGGER.info("VIP users will not be in public file.");
        UserEntity userEntity = userMapper.toEntity(userModel);
        UserEntity createdUserEntity = userDao.create(userEntity);
        return userMapper.fromEntity(createdUserEntity);
    }

    @Override
    public UserModel read(Long id) {
        return null;
    }
}
