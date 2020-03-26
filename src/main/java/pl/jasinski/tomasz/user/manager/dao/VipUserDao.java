package pl.jasinski.tomasz.user.manager.dao;

import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;

import java.util.logging.Logger;

public class VipUserDao extends UserDao{
    private static final Logger LOGGER = Logger.getLogger(VipUserDao.class.getName());
    @Override
    public UserEntity create(UserEntity userEntity) {
        LOGGER.info("Trying to safe VIP user to DB");
        return new UserEntity();
    }
}
