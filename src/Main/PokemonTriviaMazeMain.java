package Main;

import Controller.Control;
import Controller.GameplayController;
import Controller.SaveUserData;
import Model.Maze;
import Model.Player;
import View.PokemonGUI;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Andrew
 * @version 1.0
 * This is the main class that starts the whole Pokemon Trivia Maze project.
 */
public class PokemonTriviaMazeMain {

    /**
     * private constructor for the main class.
     * Throws and IllegalStateException if attempted to
     * construct elsewhere.
     */
    private PokemonTriviaMazeMain() {
        throw new IllegalStateException();
    }

    /**
     * Main method to start the GUI.
     * @param theArgs
     */
    public static void main(String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameplayController startGame = new GameplayController();

            }
        });
    }
}
