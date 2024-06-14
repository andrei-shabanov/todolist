package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.User;
import de.htwberlin.webtech.todolist.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
