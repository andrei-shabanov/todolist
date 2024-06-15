package de.htwberlin.webtech.todolist.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskTest {

    @Disabled
    void testToStringMethod() {
        String title = "Andrei";
        String details = "andrei";
        LocalDate dealine = LocalDate.of(2018, 1, 1);

        Task task = new Task(title, details, dealine);
        task.setId(42);

        String expected = "Andrei";
        String actual = task.toString();
        assertEquals(expected, actual);
    }

}
