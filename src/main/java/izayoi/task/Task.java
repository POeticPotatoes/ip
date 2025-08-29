package izayoi.task;

import java.util.Map;

import izayoi.InputManager;

/**
 * Represents a task to be completed by the user
 */
public abstract class Task {
	private boolean isCompleted = false;
	private final Map<String, String> arguments;
	private final String message;
	
	/**
	 * Initializes a new uncompleted task
	 * 
	 * @param input the InputManager reading the task description
	 */
	public Task(InputManager input) {
		this.arguments = input.getTask();
		this.message = arguments.get("message");
	}
	
	/**
	 * Marks this task as done
	 */
	public void markAsDone() {
		this.isCompleted = true;
	}
	
	/**
	 * Marks this task as not done
	 */
	public void markAsNotDone() {
		this.isCompleted = false;
	}
	
	/**
	 * Reads an argument value
	 * 
	 * @param name the argument name
	 * @return the value of the argument
	 */
	protected String getArgument(String name) {
		String m = arguments.get(name);
		return m == null ? "unspecified": m;
	}
	
	/**
	 * Returns the type of this task as a String
	 * 
	 * @return a single letter representing the type of task
	 */
	public abstract String getType();
	
	@Override
	public String toString() {
		return String.format("[%s][%s] %s", getType(), isCompleted ? "X" : " ", message);
	}
}
