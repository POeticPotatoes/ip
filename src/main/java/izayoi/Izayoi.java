package izayoi;

public class Izayoi {
	
    public static void main(String[] args) {
    	logLine();
    	logString(" Hello! I'm Sakuya Izayoi\n What can I do for you?");
    	logString(" Bye. Hope to see you again soon!");
    }
    
    private static void logString(String s) {
		System.out.println(s);
		logLine();
    }
    
    private static void logLine() {
		System.out.println("____________________________________________________________");
    }
}
