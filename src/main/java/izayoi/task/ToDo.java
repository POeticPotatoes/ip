package izayoi.task;

import izayoi.InputManager;
import izayoi.IzayoiException;

/**
 * Represents a Task with no deadline or duration
 */
public class ToDo extends Task {
	
	/**
	 * Initializes a new uncompleted ToDo task
	 * 
	 * @param input the InputManager reading the task description
	 * @throws IzayoiException if the input is invalid
	 */
	public ToDo (InputManager input) throws IzayoiException{
		super(input);
	}

	@Override
	public String getType() {
		return "T";
	}
}
