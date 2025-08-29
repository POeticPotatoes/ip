package izayoi;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages tasks for the program
 * 
 * @author POeticPotatoes
 */
public class TaskManager {
	private final List<Task> tasks = new ArrayList<>();
	
	/**
	 * Adds a task to the list of tasks
	 * 
	 * @param task the task to be added
	 */
	public String addTask(Task task) {
		this.tasks.add(task);
		return "added: " + task;
	}
	
	/**
	 * Marks a task as done
	 * 
	 * @param index of the task to complete
	 * @return the result of marking the task
	 */
	public String markTask(int index) {
		if (index < 1 || index > this.tasks.size()) {
			return "Provided index was out of bounds. Is there something wrong with your head?";
		}
		Task t = tasks.get(index - 1);
		t.markAsDone();
		return "Understood, the following task was executed:\n" + t;
	}

	/**
	 * Marks a task as undone 
	 * 
	 * @param index of the task to uncomplete
	 * @return the result of marking the task
	 */
	public String unmarkTask(int index) {
		if (index < 1 || index > this.tasks.size()) {
			return "Provided index was out of bounds. Is there something wrong with your head?";
		}
		Task t = tasks.get(index - 1);
		t.markAsNotDone();
		return "Understood. I'll take note of your incompetence:\n" + t;
	}
	
	@Override
	public String toString() {
		String result = "";
		for (int i = 1; i <= tasks.size(); i++) {
			result += i + ". " + tasks.get(i-1);
			if (i < tasks.size()) {
				result += "\n";
			}
		}
		return result;
	}
}
