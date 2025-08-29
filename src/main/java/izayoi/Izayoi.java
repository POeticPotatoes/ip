package izayoi;

import java.util.Scanner;

public class Izayoi {
	public static final Scanner scanner = new Scanner(System.in);
	
    public static void main(String[] args) {
    	logLine();
    	logString(" Hello! I'm Sakuya Izayoi\n What can I do for you?");
    	String command = getInput();
    	while (!command.equals("bye")) {
    		logString(command);
    		command = getInput();
    	}
    	logString(" Hmph. About time you stopped talking... Do come again.");
    }
    
    private static String getInput() {
    	String s = scanner.nextLine();
    	logLine();
    	return s;
    }

    private static void logString(String s) {
		System.out.println(s);
		logLine();
    }
    
    private static void logLine() {
		System.out.println("____________________________________________________________");
    }
}
