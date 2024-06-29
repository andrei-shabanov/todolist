package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@WebMvcTest(TaskController.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService service;

    @BeforeEach
    void setUpMockRepository() {
        Task wb1 = new Task("WebTech 1", "", LocalDate.of(2024, 4, 21), 1);
        when(service.getTask(1L)).thenReturn(wb1);
    }
}