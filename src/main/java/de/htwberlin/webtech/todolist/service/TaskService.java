package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.persistence.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

// quasi TaskRepo implementiert
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task editTask(Task task) {
        return taskRepository.existsById(task.getId()) ? taskRepository.save(task) : null;
    }

    public boolean removeTask(Long id) {
        final boolean exists = taskRepository.existsById(id);
        if (exists) taskRepository.deleteById(id);
        return exists;
    }

    public void markAsCompleted(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        task.setCompleted(true);
        taskRepository.save(task);
    }

    public void markAsUncompleted(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void markTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        task.setMarked(true);
        taskRepository.save(task);
    }

    public void unmarkTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(RuntimeException::new);
        task.setMarked(false);
        taskRepository.save(task);
    }

    public Iterable<Task> getTasksFromList(long id) {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false)
                .filter(task -> task.getListOfTasksId() == id)
                .toList();
    }
}
