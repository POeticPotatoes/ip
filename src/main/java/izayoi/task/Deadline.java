package izayoi.task;

import izayoi.InputManager;
import izayoi.IzayoiException;

/**
 * Represents a Task with a deadline
 */
public class Deadline extends Task {
	private final String deadline;
	
	/**
	 * Initializes a new uncompleted Deadline task
	 * 
	 * @param input the InputManager reading the task description
	 * @throws IzayoiException if the input is invalid 
	 */
	public Deadline(InputManager input) throws IzayoiException {
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
