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
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping(name = "tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Task>> getTasks() {
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

    @PostMapping("/{id}/uncomplete")
    public ResponseEntity<Void> markAsUncompleted(@PathVariable Long id) {
        taskService.markAsUncompleted(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/mark")
    public ResponseEntity<Void> markTask(@PathVariable Long id) {
        taskService.markTask(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/unmark")
    public ResponseEntity<Void> unmarkTask(@PathVariable Long id) {
        taskService.unmarkTask(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(name = "/{id}/getListOfTasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Task>> getTasksFromList(@PathVariable("id") final long id) {
        return ResponseEntity.ok(taskService.getTasksFromList(id));
    }
}