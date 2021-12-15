package Controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Andrew
 * @version 2.0
 * This class is supposed to save the data of the user so that
 * they may come back to it at a later time.
 */
public class SaveUserData {

    /**
     * UID for serialization.
     */
    private static final long serialversionUID = 5L;

    /**
     * File name that data is saved to.
     */
    private static String filename = "SaveData.txt";

    /**
     * Saves the current GameplayController.
     * @param theObject
     */
    public static void save(final GameplayController theObject){

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(theObject);
            out.close();
            file.close();
            System.out.println("Controller has been saved.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the saved GameplayController.
     * @return GameplayController
     */
    public static GameplayController retrieve() {
     GameplayController loadedGame = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            loadedGame = (GameplayController) in.readObject();

            in.close();
            file.close();
            System.out.println("Controller has been read in.");
        } catch (IOException e){
            System.out.println("IOException was caught!");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException was Caught!");
        }
        return loadedGame;
    }
}

