package de.htwberlin.webtech.todolist.persistence;

import de.htwberlin.webtech.todolist.model.ListOfTasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOfTasksRepository extends CrudRepository<ListOfTasks, Long> {
}
