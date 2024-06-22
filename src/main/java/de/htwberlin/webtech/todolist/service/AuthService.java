package de.htwberlin.webtech.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    /*
    public User authenticate(AuthRequest authRequest) {
        userService.getUsers();

        ArrayList<User> users = userService.getUsers();

        Optional<User> userOptional = users.stream()
                .filter(user -> user.getUsername().equals(authRequest.getUsername()))
                .findFirst();
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(authRequest.getPassword())) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }
     */
}
