package pl.jasinski.tomasz.user.manager.service.mapper;

import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;

public class CsvMapper {

    public static final String COLUMN_SEPARATOR = ",";

    public String csvFromEntity(UserEntity userEntity){

        String stringBuilder = userEntity.getId() + COLUMN_SEPARATOR +
                userEntity.getName() + COLUMN_SEPARATOR +
                userEntity.getLogin() + COLUMN_SEPARATOR +
                userEntity.getPassword() + COLUMN_SEPARATOR +
                userEntity.getEmail();
        return stringBuilder;
    }

}
