package de.htwberlin.webtech.todolist.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "id")
    private ListOfTasks listOfTasks;

    public Task(String title, String details, LocalDate deadline, ListOfTasks listOfTasks) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
        this.listOfTasks = listOfTasks;
    }

    public String toString() {
        return this.title;
    }
}
