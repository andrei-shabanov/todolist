package de.htwberlin.webtech.todolist;

import de.htwberlin.webtech.todolist.model.Task;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

@SpringBootTest
class TodolistApplicationTests {

	@Disabled
	void contextLoads() {

		Task task = new Task("WebTech M4", "smth", LocalDate.of(2024, 06, 16));
		Assert.isTrue(task.getTitle().equals("WebTech M4"), "this is correct title");
	}

}
