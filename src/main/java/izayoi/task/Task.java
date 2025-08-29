package main.java.izayoi.task;

import java.util.Map;

import main.java.izayoi.InputManager;
import main.java.izayoi.IzayoiException;


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
     * @throws IzayoiException if the input is invalid
     */
    public Task(InputManager input) throws IzayoiException {
        this.arguments = input.getTask();
        this.message = arguments.get("message");
        if (this.message.trim().isBlank()) {
            throw new IzayoiException("Did you forget to tell me the task you wanted to do?");
        }
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
        return m == null ? "unspecified" : m;
    }

    /**
     * Factory method to create tasks based on specified type
     *
     * @param input the InputManager reading the task description
     * @return the created task
     * @throws IzayoiException if the task creation fails
     */
    public static Task createTask(InputManager input) throws IzayoiException {
        return switch (input.getCommandType()) {
        case TODO -> new ToDo(input);
        case DEADLINE -> new Deadline(input);
        case EVENT -> new Event(input);
        default -> throw new IzayoiException("Completely incoherent task description.");
        };
    }

    /**
     * Returns the type of this task as a String
     * @return a single letter representing the type of task
     */
    public abstract String getType();

    @Override
    public String toString() {
        return String.format("[%s][%s] %s", getType(), isCompleted ? "X" : " ", message);
    }
}
