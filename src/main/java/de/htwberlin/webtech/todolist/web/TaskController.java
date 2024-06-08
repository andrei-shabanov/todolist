package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "https://todolistfrontend-qae0.onrender.com/")
@RequestMapping(path = "/tasks")
public class TaskController {

    // von repository aufrufen und edit methode aufrufen
    private final TaskService taskService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Task>> getTask() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") final Long id) {
        final Task found = taskService.getTask(id);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> addTask(@Valid @RequestBody Task body) {
        final Task createdTask = taskService.saveTask(body);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> updateTask(@PathVariable("id") final long id, @RequestBody Task body) {
        final Task updatedTask = taskService.editTask(body);
        if (updatedTask == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") final long id) {
        return taskService.removeTask(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<Void> markAsCompleted(@PathVariable Long id) {
        taskService.markAsCompleted(id);
        return ResponseEntity.ok().build();
    }
}
