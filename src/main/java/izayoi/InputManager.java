package izayoi;

import java.util.List;

/**
 * Handles the string input of a user and extracts suitable arguments
 */
public class InputManager {
	private final String raw;
	private final String[] input;
	
	/**
	 * Initalises a new input manager for the provided String
	 * 
	 * @param input the string to be parsed
	 */
	public InputManager(String input) {
		this.raw = input;
		this.input = input.split("[ ]+");
	}
	
	public String getRaw() {
		return this.raw;
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
		default:
			return CommandType.UNKNOWN;
		}
	}
}
