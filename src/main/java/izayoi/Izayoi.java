package izayoi;

import java.util.Scanner;

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
	 * @param command line arguments provided to the program
	 */
    public static void main(String[] args) {
    	TaskManager manager = new TaskManager();
    	logLine();
    	logString(" Hello! I'm Sakuya Izayoi\n What can I do for you?");
    	String command = getInput();

    	while (!command.equals("bye")) {
    		switch(command) {
    		case "list":
    			logString(manager.toString());
    			break;
    		default:
    			logString(manager.addTask(command));
    		}
    		command = getInput();
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
