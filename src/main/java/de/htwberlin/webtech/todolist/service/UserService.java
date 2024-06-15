package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.Task;
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

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
