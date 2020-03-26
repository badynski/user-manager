package pl.jasinski.tomasz.user.manager.gui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private Long id;
    private String name;
    private String login;
    private char[] password;
    private String email;
    private LocalDateTime expires;
    private boolean active;

    public UserModel(String name, String login) {
        this.name = name;
        this.login = login;
    }
}
