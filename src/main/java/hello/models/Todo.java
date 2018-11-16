package main.java.hello.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String label;

	private boolean isDone;

	public Todo() {
	}

	public Todo(String label) {
		this.label = label;
	}

	public Todo(String label, boolean isDone) {
		this.label = label;
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return String.format("[#%d] '%s'", id, label);
	}

	// ======== - GETTERS & SETTERS - ======== //
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean getIsDone() { return this.isDone; }

	public void setIsDone(boolean isDone) { this.isDone = isDone; }

}