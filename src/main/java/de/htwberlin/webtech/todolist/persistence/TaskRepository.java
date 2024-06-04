package de.htwberlin.webtech.todolist.persistence;

import de.htwberlin.webtech.todolist.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
