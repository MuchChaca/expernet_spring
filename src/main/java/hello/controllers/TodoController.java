package main.java.hello.controllers;

import main.java.hello.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.lang.Exception;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoDao todoDao;

	/**
	 * GET /create --> Create a new task todo and save it in the database.
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	@ResponseBody
	public String create(@RequestParam(value = "label") String label) {
		String todoId = "";
		Todo todo;

		try {
			todo = new Todo(label);
			todoDao.save(todo);
			todoId = String.valueOf(todo.getId());
		} catch (Exception ex) {
			return "Error creating the todo task: ";
			// + ex.toString();
		}
		return todo;
	}

}