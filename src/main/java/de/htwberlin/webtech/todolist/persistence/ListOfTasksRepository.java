package de.htwberlin.webtech.todolist.persistence;

import de.htwberlin.webtech.todolist.model.ListOfTasks;
import org.springframework.data.repository.CrudRepository;

public interface ListOfTasksRepository extends CrudRepository<ListOfTasks, Long> {
}
