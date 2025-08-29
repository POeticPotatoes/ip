package izayoi;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages tasks for the program
 * 
 * @author POeticPotatoes
 */
public class TaskManager {
	private final List<String> tasks = new ArrayList<>();
	
	/**
	 * Adds a task to the list of tasks
	 */
	public String addTask(String task) {
		this.tasks.add(task);
		return "added: " + task;
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
