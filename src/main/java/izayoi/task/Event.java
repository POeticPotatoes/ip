package main.java.izayoi.task;

import java.util.List;

import main.java.izayoi.InputReader;
import main.java.izayoi.IzayoiException;

/**
 * Represents a task with a start and end time
 */
public class Event extends Task {
    private final String start;
    private final String end;

    /**
     * Initializes a new uncompleted Event task
     * @param input the InputManager reading the task description
     * @throws IzayoiException if the input is invalid
     */
    public Event(InputReader input) throws IzayoiException {
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

    @Override
    public List<String> commandify() {
        return List.of(String.format("event %s /from %s /to %s", getMessage(), start, end));
    }
}
