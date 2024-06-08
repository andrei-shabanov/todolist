package de.htwberlin.webtech.todolist.web;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ResponseEntity<Void> redirectToTasks(HttpServletResponse response) throws IOException {
        response.sendRedirect("/tasks");
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}
