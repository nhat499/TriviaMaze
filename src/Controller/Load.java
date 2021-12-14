package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load {

    private static String filename = "SaveData.txt";

    public GameplayController retrieve() {
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
