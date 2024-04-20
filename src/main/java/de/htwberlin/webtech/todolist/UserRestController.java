package de.htwberlin.webtech.todolist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UserRestController {

    @GetMapping(path = "/task")
    public ResponseEntity<Task> getTask() {
        final Task task = new Task("WebTech Deadline 1",
                "Idea of an app, group, repository, Spring App",
                LocalDate.of(2024, 4, 21));
        return ResponseEntity.ok(task);
    }
}
