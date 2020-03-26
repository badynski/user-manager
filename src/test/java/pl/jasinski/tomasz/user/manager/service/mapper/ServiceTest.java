package pl.jasinski.tomasz.user.manager.service.mapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jasinski.tomasz.user.manager.dao.UserDao;
import pl.jasinski.tomasz.user.manager.gui.model.UserModel;
import pl.jasinski.tomasz.user.manager.service.DefaultUserService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServiceTest {

    private static final String USER_NAME_TOM1 = "TOM1";
    public static final String USER_LOGIN_TOM1 = "TOM";
    private DefaultUserService defaultUserService;

    @BeforeEach
    public void create() {
        defaultUserService = new DefaultUserService(new UserDao());
    }
    @AfterEach
    public void tearDown(){
        defaultUserService = null;
    }

    @Test
    void givenServiceMapper_whenToEntity_thenModelAndEntityEquals() {
// given
//        UserMapper userMapper = new UserMapper();
        UserModel userModel = new UserModel(USER_NAME_TOM1, USER_LOGIN_TOM1);

// when
       UserModel createdUserModel = defaultUserService.create(userModel);

// then
       assertNotNull(createdUserModel.getId(), "Id is null");

//        assertEquals(USER_NAME_TOM1, userEntity.getName(), "Names are not equal.");
//        assertEquals(USER_LOGIN_TOM1, userEntity.getLogin(), "Logins are not equal.");

    }


}

//TODO zrobić tet jednostkowy do serwisu. uwaga na wstrzykiwanie zależności - parametry konstruktora.