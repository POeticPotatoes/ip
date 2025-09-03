package main.java.izayoi;

import java.util.Scanner;

import main.java.izayoi.file.FileManager;
import main.java.izayoi.logger.CliLogger;

/**
 * Main class for handling user input and output
 * @author POeticPotatoes
 */
public class Izayoi {
    public static final Scanner SCANNER = new Scanner(System.in);
    /**
    * Main class for the program
    * @param args command line arguments provided to the program
    */
    public static void main(String[] args) {
        FileManager fm = new FileManager(FileManager.SAVE_FILE);
        TaskManager tm = new TaskManager();
        InputManager im = new InputManager(tm, new CliLogger());

        im.hello();
        while (im.nextLine()) {}
        im.goodbye();
    }

}
