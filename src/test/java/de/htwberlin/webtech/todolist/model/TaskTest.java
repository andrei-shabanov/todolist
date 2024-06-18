package de.htwberlin.webtech.todolist.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskTest {

    @Test
    @DisplayName("TaskTest: tests toString()")
    void testToStringMethod() {
        final String title = "Andrei";
        final String details = "andrei";
        final LocalDate dealine = LocalDate.of(2018, 1, 1);

        final Task task = new Task(title, details, dealine);
        task.setId(42);

        final String expected = "Andrei";
        final String actual = task.toString();
        assertEquals(expected, actual);
    }
}
