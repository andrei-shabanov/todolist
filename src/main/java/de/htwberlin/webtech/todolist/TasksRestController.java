package de.htwberlin.webtech.todolist;

import api.Aufgabe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TasksRestController {

    private List<Aufgabe> aufgaben;

    public TasksRestController() {
        aufgaben = new ArrayList<>();
        aufgaben.add(new Aufgabe(1, "abwaschen", "10.02.2024", false));
        aufgaben.add(new Aufgabe(2, "Wäsche", "02.02.2024", false));
    }

    @GetMapping(path = "/api/v1/")
    public ResponseEntity<List<Aufgabe>> fetchAufgabe() {
        return ResponseEntity.ok(aufgaben);
    }
}

