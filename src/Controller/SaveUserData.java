package Controller;

import java.io.*;

/**
 * @author Andrew
 * @version 1.0
 * This class is supposed to save the data of the user so that
 * they may come back to it at a later time.
 */
public class SaveUserData {

    private static final long serialversionUID = 5L;
    private static String filename = "SaveData.txt";


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

    public static GameplayController retrieve() throws IOException, ClassNotFoundException {
        GameplayController game = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            game = (GameplayController) in.readObject();

            in.close();
            file.close();
            System.out.println("Controller has been read in.");
        } catch (IOException e){
            System.out.println("IOException was caught!");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException was Caught!");
        }
        return game;
    }
}

