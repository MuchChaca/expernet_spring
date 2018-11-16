package main.java.hello.controllers;

import main.java.hello.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.lang.Exception;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:8080")
public class TodoController {

	@Autowired
	private TodoDao todoDao;

	/**
	 * POST /new --> Create a new task todo and save it in the database.
	 */
	@RequestMapping(value = "/new", method = RequestMethod.POST, consumes = { "application/json" })
	public Object create(@RequestBody Todo todo) {
		String todoId = "";

		try {
			todoDao.save(todo);
			todoId = String.valueOf(todo.getId());
		} catch (Exception ex) {
			return "Error creating the todo task: " + ex.toString();
		}
		return todo;
	}

	/**
	 * DELETE /delete --> Delete a task
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Object delete(@RequestParam(value = "id") Long id) {

		try {
			// Object todo = todoDao.findById(id);
			todoDao.deleteById(id);
		} catch (Exception ex) {
			return "Error deleting the todo task: " + ex.toString();
		}

		return "Deleted " + id;
	}

	/**
	 * GET /all --> Get all tasks
	 * 
	 * @return List<Todo>
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Object all() {
		List<Todo> todos;

		try {
			todos = todoDao.findAll();
		} catch (Exception ex) {
			return "Error getching todo tasks: " + ex.toString();
		}

		return todos;
	}

}