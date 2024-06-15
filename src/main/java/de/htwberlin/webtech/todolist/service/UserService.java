package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.AppUser;
import de.htwberlin.webtech.todolist.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public AppUser saveUser(AppUser appUser) {
        return userRepository.save(appUser);
    }

    public AppUser getUser(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Iterable<AppUser> getUsers() {
        return userRepository.findAll();
    }
}
