package izayoi;

import java.util.Scanner;

import izayoi.task.Task;

/**
 * Main class for handling user input and output
 * 
 * @author POeticPotatoes
 */
public class Izayoi {
	public static final Scanner scanner = new Scanner(System.in);
	
	/**
	 * Main class for the program
	 * 
	 * @param args command line arguments provided to the program
	 */
    public static void main(String[] args) {
    	TaskManager manager = new TaskManager();
    	logLine();
    	logString(" Hello! I'm Sakuya Izayoi\n What can I do for you?");

    	InputManager input = new InputManager(getInput());

    	while (!input.getCommandType().equals(CommandType.EXIT)) {
    		switch(input.getCommandType()) {
    		case MARK:
    			logString(manager.markTask(input.getIndex()));
    			break;
    		case UNMARK:
    			logString(manager.unmarkTask(input.getIndex()));
    			break;
    		case LIST:
    			logString(manager.toString());
    			break;
    		case TODO, EVENT, DEADLINE:
    			try {
    				logString(manager.addTask(Task.createTask(input)));
    			} catch (IzayoiException e) {
    				logString(e.getMessage() + "\nYour insolence has been noted.");
    			}
    			break;
    		default:
    			logString("I don't understand that command. Have you forgotten how to speak english?");
    		}
    		input = new InputManager(getInput());
    	}
    	logString(" Hmph. About time you stopped talking... Do come again.");
    }
    
    /**
     * Gets user input
     * 
     * @returns The user's input
     */
    private static String getInput() {
    	String s = scanner.nextLine();
    	logLine();
    	return s;
    }

    /**
     * Logs a string to the output
     */
    private static void logString(String s) {
		System.out.println(s);
		logLine();
    }

    /**
     * Logs a line break to the output
     */
    private static void logLine() {
		System.out.println("____________________________________________________________");
    }
}
