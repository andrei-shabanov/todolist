package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.persistence.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService service;

    @MockBean
    private TaskRepository repository;

    @BeforeEach
    void setUpMockRepository() {
        Task wb1 = new Task("WebTech 1", "", LocalDate.of(2024, 4, 21), 1);
        Task wb2 = new Task("WebTech 2", "", LocalDate.of(2024, 5, 12), 1);
        Task wb3 = new Task("WebTech 3", "", LocalDate.of(2024, 5, 26), 1);
        Task wb4 = new Task("WebTech 4", "", LocalDate.of(2024, 6, 16), 1);
        Task wbPras = new Task("WebTech Projekt", "", LocalDate.of(2024, 7, 1), 1);


        doReturn(List.of(wb1, wb2, wb3, wb4, wbPras)).when(repository).findAll();
    }

    @Test
    @DisplayName("TaskService: the entities are correctly saved in the Database")
    void testDatabasePersistence() {
        List<Task> result = StreamSupport.stream(service.getTasks().spliterator(), false).toList();
        assertEquals(result.getFirst().getTitle(), "WebTech 1");
    }

    // to implement: filter by completed / uncompleted
}
