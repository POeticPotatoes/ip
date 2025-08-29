package izayoi.task;

import izayoi.InputManager;

/**
 * Represents a Task with no deadline or duration
 */
public class ToDo extends Task {
	
	/**
	 * Initializes a new uncompleted ToDo task
	 * 
	 * @param input the InputManager reading the task description
	 */
	public ToDo (InputManager input){
		super(input);
	}

	@Override
	public String getType() {
		return "T";
	}
}
