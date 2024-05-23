package de.htwberlin.webtech.todolist.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// internal backend class
@Getter
@Setter
public class TaskWithId extends Task {

    private long id;

    public TaskWithId(String title, String details, LocalDate deadline, long id) {
        super(title, details, deadline);
        this.id = id;
    }
}
