package pl.jasinski.tomasz.user.manager.service.mapper;

import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;
import pl.jasinski.tomasz.user.manager.gui.model.UserModel;

public class UserMapper {

    public UserEntity toEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userModel.getId());
        userEntity.setName(userModel.getName());
        userEntity.setLogin(userModel.getLogin());

        return userEntity;
    }

    public UserModel fromEntity(UserEntity userEntity) {
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setLogin(userEntity.getLogin());

        return userModel;
    }
}
