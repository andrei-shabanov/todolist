package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.model.Task;
import de.htwberlin.webtech.todolist.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

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

    @Test
    @DisplayName("TaskController: the entities are correctly sent via the Controller")
    void testGetTests() throws Exception {
        final String expectation = "{\"id\":0," +
                "\"title\":\"WebTech 1\"," +
                "\"details\":\"\"," +
                "\"deadline\":[2024,4,21]," +
                "\"completed\":false," +
                "\"marked\":false," +
                "\"listOfTasksId\":1}";
        this.mockMvc.perform(get("/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }

    @Test
    @DisplayName("TaskController: the entities are deleted via the Controller")
    void testDeleteTask() throws Exception {
        long taskIdToDelete = 1L;

        when(service.removeTask(taskIdToDelete)).thenReturn(true);

        this.mockMvc.perform(delete("/tasks/{id}", taskIdToDelete))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("TaskController: the entities are added via the Controller")
    void testAddTask() throws Exception {
        Task newTask = new Task("New Task", "Details", LocalDate.of(2024, 4, 22), 2);
        newTask.setId(2L);

        when(service.saveTask(any(Task.class))).thenReturn(newTask);

        final String newTaskJson = "{\"title\":\"WebTech 2\"," +
                "\"details\":\"\"," +
                "\"deadline\":\"2024-05-12\"," +
                "\"completed\":false," +
                "\"marked\":false," +
                "\"listOfTasksId\":2}";

        final String expectedResponseJson = "{\"id\":2," +
                "\"title\":\"WebTech 2\"," +
                "\"details\":\"\"," +
                "\"deadline\":[2024,5,12]," +
                "\"completed\":false," +
                "\"marked\":false," +
                "\"listOfTasksId\":2}";

        this.mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTaskJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectedResponseJson)));
    }

    @Test
    void testUpdateTask() throws Exception {
        long taskIdToUpdate = 1L;
        Task updatedTask = new Task("WebTech 3", "", LocalDate.of(2024, 5, 28), 3);
        updatedTask.setId(taskIdToUpdate);
        updatedTask.setCompleted(true);

        when(service.editTask(any(Task.class))).thenReturn(updatedTask);

        final String updateTaskJson = "{\"title\":\"WebTech 3\"," +
                "\"details\":\"\"," +
                "\"deadline\":\"2024-05-28\"," +
                "\"completed\":true," +
                "\"marked\":false," +
                "\"listOfTasksId\":3}";

        final String expectedResponseJson = "{\"id\":1," +
                "\"title\":\"WebTech 3\"," +
                "\"details\":\"\"," +
                "\"deadline\":[2024,5,28]," +
                "\"completed\":true," +
                "\"marked\":false," +
                "\"listOfTasksId\":3}";

        this.mockMvc.perform(put("/tasks/{id}", taskIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateTaskJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectedResponseJson)));

        when(service.editTask(any(Task.class))).thenReturn(null);

        this.mockMvc.perform(put("/tasks/{id}", taskIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateTaskJson))
                .andExpect(status().isNotFound());
    }
}