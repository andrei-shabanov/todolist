package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "https://todolistfrontend-qae0.onrender.com/")
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

}