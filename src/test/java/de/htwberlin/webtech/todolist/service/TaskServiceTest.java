package de.htwberlin.webtech.todolist.service;

import de.htwberlin.webtech.todolist.model.ListOfTasks;
import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.persistence.TaskRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
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
        wb1.setId(1L);
        Task wb2 = new Task("WebTech 2", "", LocalDate.of(2024, 5, 12), 1);
        wb2.setId(2L);
        Task wb3 = new Task("WebTech 3", "", LocalDate.of(2024, 5, 26), 1);
        wb3.setId(3L);
        Task wb4 = new Task("WebTech 4", "", LocalDate.of(2024, 6, 16), 1);
        wb4.setId(4L);
        Task wbPras = new Task("WebTech Projekt", "", LocalDate.of(2024, 7, 1), 1);
        wbPras.setId(5L);
        Task control1 = new Task("Controlling Test 1", "", LocalDate.of(2024, 5, 28), 2);
        control1.setId(6L);
        Task control2 = new Task("Controlling Test 2", "", LocalDate.of(2024, 6, 21), 2);
        control2.setId(7L);

        doReturn(List.of(wb1, wb2, wb3, wb4, wbPras, control1, control2)).when(repository).findAll();
    }

    @Test
    @DisplayName("TaskService: the entities are correctly saved in the Database")
    void testDatabasePersistence() {
        List<Task> result = StreamSupport.stream(service.getTasks().spliterator(), false).toList();
        assertEquals(result.getFirst().getTitle(), "WebTech 1");
    }

    @Test
    @DisplayName("TaskService: entities in Lists are assigned correctly")
    void testTasksFromList() {
        List<Task> result = StreamSupport.stream(service.getTasksFromList(2).spliterator(), false).toList();
        assertEquals(result.size(), 2);
    }

    // to implement: filter by completed / uncompleted
}
