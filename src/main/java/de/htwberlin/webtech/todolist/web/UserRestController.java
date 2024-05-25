package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.dao.TaskMapper;
import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.model.TaskWithId;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/")
public class UserRestController {

    private final TaskMapper taskMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaskWithId>> getTask() {
        return ResponseEntity.ok(taskMapper.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskWithId> getTask(@PathVariable("id") final Long id) {
        final TaskWithId found = taskMapper.getTask(id);
        return found != null ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> addTask(@Valid @RequestBody Task body) {
        final TaskWithId createdTask = taskMapper.addTask(body);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskWithId> updateTask(@PathVariable("id") final Long id, @RequestBody Task body) {
        final TaskWithId updatedTask = taskMapper.updateTask(id, body);
        if (updatedTask == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") final Long id) {
        return taskMapper.removeTask(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
