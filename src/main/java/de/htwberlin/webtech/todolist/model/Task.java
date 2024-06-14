package de.htwberlin.webtech.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// ein Controller per Entitaet
@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String details;
    private LocalDate deadline;
    private boolean completed = false;
    // private boolean marked = false;
    // private long UserId;

    public Task(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

    /*
    public Task(String title, String details, LocalDate deadline, long userId) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
        this.userId = userId;
    }
     */
    public Task() { }
}
