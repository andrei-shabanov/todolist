package de.htwberlin.webtech.todolist.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;

// complete equivalent to the frontend class
@Getter
@Setter
public class Task {

    private String title;
    private String details;
    private LocalDate deadline;
    private boolean completed = false;

    public Task (String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

    public boolean getCompleted() {
        return this.completed;
    }
}