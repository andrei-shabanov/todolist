package de.htwberlin.webtech.todolist;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class Task {

    private String title;
    private String details;
    private LocalDate deadline;
    private boolean completed = false;

    public Task(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
        this.completed = false;
    }
}
