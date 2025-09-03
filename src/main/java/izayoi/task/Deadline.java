package main.java.izayoi.task;

import java.util.List;

import main.java.izayoi.InputReader;
import main.java.izayoi.IzayoiException;

/**
 * Represents a Task with a deadline
 */
public class Deadline extends Task {
    private final String deadline;

    /**
     * Initializes a new uncompleted Deadline task
     * @param input the InputManager reading the task description
     * @throws IzayoiException if the input is invalid
     */
    public Deadline(InputReader input) throws IzayoiException {
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

    @Override
    public List<String> commandify() {
        return List.of(String.format("deadline %s /by %s", getMessage(), deadline));
    }
}
