package main.java.hello.models;

import org.springframework.data.repository.CrudRepository;
import javax.transaction.*;
import java.util.List;

@Transactional
public interface TodoDao extends CrudRepository<Todo, Long> {

	/**
	 * This method will find a Todo instance in the database by its email. Note that
	 * this method is not implemented and its working code will be automagically
	 * generated from its signature by Spring Data JPA.
	 */
	public Todo findByLabel(String label);

	public List<Todo> findAll();

}