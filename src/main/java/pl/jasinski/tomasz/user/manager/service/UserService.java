package pl.jasinski.tomasz.user.manager.service;

import pl.jasinski.tomasz.user.manager.gui.model.UserModel;

public interface UserService {
    UserModel create(UserModel userModel);
    UserModel read(Long id);

}
