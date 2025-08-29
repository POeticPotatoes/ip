package izayoi.task;

import izayoi.InputManager;

/**
 * Represents a task with a start and end time
 */
public class Event extends Task {
	private final String start, end;
	
	/**
	 * Initializes a new uncompleted Event task
	 * 
	 * @param input the InputManager reading the task description
	 */
	public Event(InputManager input) {
		super(input);
		this.start = super.getArgument("from");
		this.end = super.getArgument("to");
	}
	
	@Override
	public String getType() {
		return "E";
	}
	
	@Override
	public String toString() {
		return String.format("%s (from: %s to: %s)", super.toString(), start, end);
	}
}
