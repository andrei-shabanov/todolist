package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.ListOfTasks;
import de.htwberlin.webtech.todolist.persistence.ListOfTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListOfTasksService {

    @Autowired
    ListOfTasksRepository listOfTasksRepository;

    public ListOfTasks saveTask(ListOfTasks listOfTasks) {
        return listOfTasksRepository.save(listOfTasks);
    }
}
