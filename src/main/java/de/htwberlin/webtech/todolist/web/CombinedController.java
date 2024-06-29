package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.service.ListOfTasksService;
import de.htwberlin.webtech.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/lists")
public class CombinedController {

    private final ListOfTasksService listOfTasksService;
    private final TaskService taskService;

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteList(@PathVariable("id") final long id) {
        if (id == 1) {
            return ResponseEntity.notFound().build();
        } else {
            List<Task> tasks = StreamSupport.stream(taskService.getTasksFromList(id).spliterator(), false).toList();
            for (Task task : tasks) {
                task.setListOfTasksId(1L);
                taskService.editTask(task);
            }
            listOfTasksService.removeList(id);
            return ResponseEntity.noContent().build();
        }
    }
}
