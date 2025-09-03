package main.java.izayoi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import main.java.izayoi.file.FileManager;
import main.java.izayoi.logger.CliLogger;
import main.java.izayoi.logger.VoidLogger;

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
        InputManager im = new InputManager(tm, new VoidLogger());

        try {
            im.readLines(fm.readFile());
        } catch (FileNotFoundException e) {
            System.out.println("Could not read save file.");
            System.out.println(e.getMessage());
        }
        im.setLogger(new CliLogger());
        im.hello();
        while (im.nextLine()) {
            try {
                fm.writeToFile(tm.commandify());
            } catch (IOException e) {
                System.out.println("Could not save file.");
                System.out.println(e.getMessage());
            }
        }
        try {
            fm.writeToFile(tm.commandify());
            System.out.println("File successfully saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        im.goodbye();
    }

}
