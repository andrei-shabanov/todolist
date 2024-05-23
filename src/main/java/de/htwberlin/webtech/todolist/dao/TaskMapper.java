package de.htwberlin.webtech.todolist.dao;

import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.model.TaskWithId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

// artificial database
@Service
public class TaskMapper {

    private final HashMap<Long, TaskWithId> data = new HashMap<>() {{
        put(1L, new TaskWithId("WebTech 1", "smth", LocalDate.of(2024, 4, 28), 1L));
        put(2L, new TaskWithId("WebTech 2", "smth2", LocalDate.of(2024, 5, 12), 2L));
        put(3L, new TaskWithId("Controlling Test 1", "smth2", LocalDate.of(2024, 5, 26), 3L));
        put(4L, new TaskWithId("DB Homework 1", "smth2", LocalDate.of(2024, 5, 12), 4L));
    }};
    private long id = this.data.size();

    //
    public TaskWithId getTask(long id) {
        return data.get(id);
    }

    public List<TaskWithId> getTasks() {
        return data.values().stream().toList();
    }

    public TaskWithId addTask(Task task) {
        Long taskId = this.id++;
        TaskWithId newTask = new TaskWithId(task.getTitle(), task.getDetails(), task.getDeadline(), taskId);
        data.put(this.id, newTask);
        return newTask;
    }

    public TaskWithId editTask(Long id, Task task) {
        if (!data.containsKey(id)) return null;
        final TaskWithId taskEdit = data.get(id);
        taskEdit.setTitle(task.getTitle());
        taskEdit.setDeadline(task.getDeadline());
        taskEdit.setDetails(task.getDetails());
        taskEdit.setCompleted(task.getCompleted());
        return taskEdit;
    }

    public boolean removeHero(Long id) {
        return data.remove(id) != null;
    }

}
