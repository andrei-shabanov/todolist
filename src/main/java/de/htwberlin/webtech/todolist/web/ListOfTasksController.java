package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.model.ListOfTasks;
import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.service.ListOfTasksService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/lists")
public class ListOfTasksController {

    private final ListOfTasksService listOfTasksService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<ListOfTasks>> getTasks() {
        return ResponseEntity.ok(listOfTasksService.getLists());
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<ListOfTasks> getTask(@PathVariable("id") final Long id) {
        final ListOfTasks found = listOfTasksService.getList(id);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListOfTasks> addTask(@Valid @RequestBody ListOfTasks body) {
        final ListOfTasks createdTask = listOfTasksService.saveList(body);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ListOfTasks> updateTask(@PathVariable("id") final long id, @RequestBody ListOfTasks body) {
        final ListOfTasks updatedTask = listOfTasksService.editList(body);
        if (updatedTask == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") final long id) {
        return listOfTasksService.removeList(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }


}
