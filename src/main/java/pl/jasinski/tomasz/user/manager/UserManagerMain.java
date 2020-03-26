package pl.jasinski.tomasz.user.manager;

import pl.jasinski.tomasz.user.manager.dao.UserDao;
import pl.jasinski.tomasz.user.manager.dao.VipUserDao;
import pl.jasinski.tomasz.user.manager.gui.controller.UserController;
import pl.jasinski.tomasz.user.manager.gui.model.UserModel;
import pl.jasinski.tomasz.user.manager.service.DefaultUserService;
import pl.jasinski.tomasz.user.manager.service.VipUserService;
import pl.jasinski.tomasz.user.manager.service.mapper.UserMapper;

import java.util.Scanner;
import java.util.logging.Logger;

public class UserManagerMain {
    private static final Logger LOGGER = Logger.getLogger(UserManagerMain.class.getName());

    public static void main(String[] args) {
//        UserModel userModel = new UserModel();
//        System.out.println(userModel);
        UserDao userDao = new UserDao();
        VipUserDao vipUserDao = new VipUserDao();
        UserMapper userMapper = new UserMapper();
        DefaultUserService defaultUserService = new DefaultUserService(userDao);
        VipUserService vipUserService = new VipUserService(vipUserDao, userMapper);
        UserController userController = new UserController(defaultUserService);
//        UserController userController = new UserController();
        LOGGER.info("Pass user name or 'q' to quit.");
        Scanner scanner = new Scanner(System.in);
        String nextLine;
        while (!(nextLine = scanner.nextLine()).equals("q")) {


            String userName = nextLine;
//            String userName = scanner.nextLine();
            LOGGER.info("Pass user login");
            String userLogin = scanner.nextLine();
            LOGGER.info("Name: " + userName + ", " + "Login: " + userLogin);


            UserModel userModel = new UserModel(userName, userLogin);

            userController.create(userModel);
            LOGGER.info("Pass user name or 'q' to quit.");
            userController.read(1L);


        }
    }
}
