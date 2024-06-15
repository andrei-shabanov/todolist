package de.htwberlin.webtech.todolist.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nickname;
    private String password;

    public AppUser(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
