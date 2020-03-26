package pl.jasinski.tomasz.user.manager.gui.controller;

import pl.jasinski.tomasz.user.manager.gui.model.UserModel;
import pl.jasinski.tomasz.user.manager.service.UserService;

import java.util.logging.Logger;

public class UserController {
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    private UserService userService;

//    public UserController(){
//        this.userService = new UserService();
//    }


    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void list() {
    }

    public void create(UserModel userModel) {
        LOGGER.info ("Delegating saving User in Data Base: " + userModel);
        userService.create(userModel);
    }


    public void read(Long id) {
        LOGGER.info ("Reading stuff form Data Base: " + id);
        userService.read(id);
    }

    public void update() {
    }

    public void delete() {
    }

}
