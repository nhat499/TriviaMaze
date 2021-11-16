package Main;

import View.PokemonGUI;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

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
                new PokemonGUI().start();
            }

        });
    }
}