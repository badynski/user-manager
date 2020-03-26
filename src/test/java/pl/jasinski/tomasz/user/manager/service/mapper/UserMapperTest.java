package pl.jasinski.tomasz.user.manager.service.mapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;
import pl.jasinski.tomasz.user.manager.gui.model.UserModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {

    private static final String USER_NAME_TOM1 = "TOM1";
    public static final String USER_LOGIN_TOM1 = "TOM";
    public static final long USER_ID = 1L;
    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        userMapper = new UserMapper();
    }
    @AfterEach
    public void tearDown(){
        userMapper = null;
    }

    @Test
    void givenUserMapper_whenToEntity_thenModelAndEntityEquals() {
// given
//        UserMapper userMapper = new UserMapper();
        UserModel userModel = new UserModel(USER_NAME_TOM1, USER_LOGIN_TOM1);
        userModel.setId(USER_ID);
// when
        UserEntity userEntity = userMapper.toEntity(userModel);

// then
        assertEquals(USER_NAME_TOM1, userEntity.getName(), "Names are not equals.");
        assertEquals(USER_LOGIN_TOM1, userEntity.getLogin(), "Logins are not equals.");
        assertEquals(USER_ID, userEntity.getId(), "IDs are not equals.");

    }

    @Test
    void fromEntity() {
//        given
//        UserMapper userMapper = new UserMapper();
        UserEntity userEntity = new UserEntity(USER_NAME_TOM1, USER_LOGIN_TOM1);
        userEntity.setId(USER_ID);

//        when
        UserModel userModel = userMapper.fromEntity(userEntity);
//          then
        assertEquals(USER_NAME_TOM1, userModel.getName(), "Names are not equals.");
        assertEquals(USER_LOGIN_TOM1, userModel.getLogin(), "Logins are not equals.");
        assertEquals(USER_ID, userModel.getId(), "IDs are not equals.");

    }
}

//TODO zrobić tet jednostkowy do serwisu. uwaga na wstrzykiwanie zależności - parametry konstruktora.