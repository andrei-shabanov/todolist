package de.htwberlin.webtech.todolist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class Task {

    private String title;
    private String details;
    private LocalDate dealline;
}
