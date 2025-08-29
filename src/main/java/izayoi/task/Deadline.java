package izayoi.task;

import izayoi.InputManager;

/**
 * Represents a Task with a deadline
 */
public class Deadline extends Task {
	private final String deadline;
	
	/**
	 * Initializes a new uncompleted Deadline task
	 * 
	 * @param input the InputManager reading the task description
	 */
	public Deadline(InputManager input) {
		super(input);
		this.deadline = super.getArgument("by");
	}
	
	@Override
	public String getType() {
		return "D";
	}
	
	@Override
	public String toString() {
		return String.format("%s (by: %s)", super.toString(), deadline);
	}
}
