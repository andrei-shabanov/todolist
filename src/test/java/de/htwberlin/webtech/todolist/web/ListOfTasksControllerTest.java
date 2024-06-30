package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.model.ListOfTasks;
import de.htwberlin.webtech.todolist.service.ListOfTasksService;
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

@WebMvcTest(ListOfTasksController.class)
public class ListOfTasksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListOfTasksService service;

    @BeforeEach
    void setUpMockRepository() {
        ListOfTasks webTech = new ListOfTasks("WebTech");
        webTech.setId(1L);
        when(service.getList(1L)).thenReturn(webTech);
    }

    @Test
    @DisplayName("ListOfTasksController: the entities are correctly sent via the Controller")
    void testGetListOfTasks() throws Exception {
        final String expectation = "{\"id\":1," +
                "\"title\":\"WebTech\"}";

        this.mockMvc.perform(get("/lists/1/get"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }

    @Test
    @DisplayName("ListOfTasksController: the entities are added via the Controller")
    void testAddListOfTasks() throws Exception {
        ListOfTasks controlling = new ListOfTasks("Controlling");
        controlling.setId(2L);

        when(service.saveList(any(ListOfTasks.class))).thenReturn(controlling);

        final String newListJson = "{\"title\":\"Controlling\"}";

        final String expectedResponseJson = "{\"id\":2," +
                "\"title\":\"Controlling\"}";

        this.mockMvc.perform(post("/lists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newListJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectedResponseJson)));
    }

    @Test
    void testUpdateListOfTasks() throws Exception {
        long listIdToUpdate = 1L;
        ListOfTasks updatedList = new ListOfTasks("Controlling");
        updatedList.setId(listIdToUpdate);

        when(service.editList(any(ListOfTasks.class))).thenReturn(updatedList);

        final String updateListJson = "{\"title\":\"Controlling\"}";

        final String expectedResponseJson = "{\"id\":1," +
                "\"title\":\"Controlling\"}";

        this.mockMvc.perform(put("/lists/{id}", listIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateListJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectedResponseJson)));

        when(service.editList(any(ListOfTasks.class))).thenReturn(null);

        this.mockMvc.perform(put("/lists/{id}", listIdToUpdate)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateListJson))
                .andExpect(status().isNotFound());
    }
}
