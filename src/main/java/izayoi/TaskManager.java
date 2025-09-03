package main.java.izayoi;

import java.util.ArrayList;
import java.util.List;

import main.java.izayoi.task.Task;

/**
 * Manages tasks for the program
 * @author POeticPotatoes
 */
public class TaskManager implements Commandifiable {
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Adds a task to the list of tasks
     * @param task the task to be added
     */
    public String addTask(Task task) {
        this.tasks.add(task);
        return String.format("Ok, I've added the task:\n%s\nYou'll have %s tasks now.",
                    task, tasks.size());
    }

    /**
     * Marks a task as done
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

    /**
     * Deletes a task from the manager
     * @param index the index of the task to be deleted
     * @return a status message for the deletion operation
     */
    public String deleteTask(int index) {
        if (index < 1 || index > this.tasks.size()) {
            return "How could you be asking me to delete something that doesn't exist??";
        }
        Task t = tasks.get(index - 1);
        tasks.remove(index - 1);
        return "Understood. The following task has been eliminated:\n" + t;
    }

    @Override
    public List<String> commandify() {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= tasks.size(); i++) {
            Task t = tasks.get(i - 1);
            result.addAll(t.commandify());
            if (t.isCompleted()) {
                result.add("mark " + i);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Here you go, your list of tasks:\n";
        for (int i = 1; i <= tasks.size(); i++) {
            result += i + ". " + tasks.get(i - 1);
            if (i < tasks.size()) {
                result += "\n";
            }
        }
        return result;
    }
}
