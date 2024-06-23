package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.ListOfTasks;
import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.persistence.ListOfTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListOfTasksService {

    @Autowired
    ListOfTasksRepository listOfTasksRepository;

    public ListOfTasks saveList(ListOfTasks listOfTasks) {
        return listOfTasksRepository.save(listOfTasks);
    }

    public ListOfTasks getList(Long id) {
        return listOfTasksRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Iterable<ListOfTasks> getLists() {
        return listOfTasksRepository.findAll();
    }

    public ListOfTasks editList(ListOfTasks listOfTasks) {
        return listOfTasksRepository.existsById(listOfTasks.getId()) ? listOfTasksRepository.save(listOfTasks) : null;
    }

    public boolean removeList(Long id) {
        final boolean exists = listOfTasksRepository.existsById(id);
        if (exists) listOfTasksRepository.deleteById(id);
        return exists;
    }
}
