package de.htwberlin.webtech.todolist.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskTest {

    @Disabled
    @DisplayName("TaskTest: tests toString()")
    void testToStringMethod() {
        final String title = "WebTech 1";
        final String details = "Thema überlegt, Paar gefunden, Repo erstellt, Entity Klassen überlegt, Spring App mit REST";
        final LocalDate deadline = LocalDate.of(2024, 4, 21);

        final Task task = new Task(title, details, deadline, 1);
        task.setId(1L);

        final String expected = "WebTech 1";
        final String actual = task.toString();
        assertEquals(expected, actual);
    }
}
