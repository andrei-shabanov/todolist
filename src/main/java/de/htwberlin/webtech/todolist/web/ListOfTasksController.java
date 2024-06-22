package de.htwberlin.webtech.todolist.web;

import de.htwberlin.webtech.todolist.service.ListOfTasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/lists")
public class ListOfTasksController {

    private final ListOfTasksService listOfTasksService;
}
