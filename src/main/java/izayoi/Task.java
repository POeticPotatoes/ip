package izayoi;

/**
 * Represents a task to be completed by the user
 */
public class Task {
	private boolean isCompleted = false;
	private final String name;
	
	/**
	 * Initializes a new uncompleted task
	 * 
	 * @param name the name of the task
	 */
	public Task(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		return "[" + (isCompleted ? "X" : " ") + "] " + name;
	}
}
