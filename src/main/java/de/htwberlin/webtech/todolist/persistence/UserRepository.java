package de.htwberlin.webtech.todolist.persistence;

import de.htwberlin.webtech.todolist.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {

}
