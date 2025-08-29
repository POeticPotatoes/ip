package izayoi;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles the string input of a user and extracts suitable arguments
 */
public class InputManager {
	private final String[] input;
	
	/**
	 * Initalises a new input manager for the provided String
	 * 
	 * @param input the string to be parsed
	 */
	public InputManager(String input) {
		this.input = input.split("[ ]+");
	}
	
	/**
	 * Attempts to read the input as a task description, returning any arguments
	 * 
	 * @return a map of argument names and their values. The task description is mapped to "message"
	 */
	public Map<String, String> getTask() {
		HashMap<String, String> result = new HashMap<>();
		String context = "message";
		String arguments = "";

		for (int i = 1; i < input.length; i++) {
			if (input[i].charAt(0) == '/') {
				result.put(context, arguments.trim());
				context = input[i].substring(1);
				arguments = "";
				continue;
			}
			arguments+= input[i] + " ";
		}
		result.put(context, arguments);

		return result;
	}
	
	/**
	 * Attempts to read the second provided argument as an integer
	 * 
	 * @return the integer obtained, or -1 if the integer is invalid
	 */
	public int getIndex() {
		try {
			return Integer.parseInt(input[1]);
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * Attempts to recognise the type of input of the provided String
	 * 
	 * @return the type of command issued in the String
	 */
	public CommandType getCommandType() {
		switch(input[0]) { 
		case "list":
			return CommandType.LIST;
		case "bye":
			return CommandType.EXIT;
		case "mark":
			return CommandType.MARK;
		case "unmark":
			return CommandType.UNMARK;
		case "todo":
			return CommandType.TODO;
		case "deadline":
			return CommandType.DEADLINE;
		case "event":
			return CommandType.EVENT;
		default:
			return CommandType.UNKNOWN;
		}
	}
}
