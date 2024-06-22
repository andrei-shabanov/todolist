package de.htwberlin.webtech.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// ein Controller per Entitaet
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String details;
    private LocalDate deadline;
    private boolean completed = false;
    private boolean marked = false;
    // private long listOfTasksId;

    public Task(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }

    /*
    public Task(String title, String details, LocalDate deadline, long listOfTasksId) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
        this.listOfTasksId = listOfTasksId;
    }
     */

    public String toString() {
        return this.title;
    }
}
