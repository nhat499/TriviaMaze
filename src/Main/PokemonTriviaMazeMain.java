package Main;

import Controller.GameplayController;
import Controller.SaveUserData;
import Model.Maze;
import Model.Player;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Andrew
 * @version 1.0
 * This is the main class that starts the whole Pokemon Trivia Maze project.
 */
public class PokemonTriviaMazeMain {

    private GameplayController myController;

    private PokemonTriviaMazeMain() {
        myController = new GameplayController(this);
    }

    public void setMyController(final GameplayController theController) {
        myController = theController;
    }

    /**
     * Main method to start the GUI.
     *
     * @param theArgs
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PokemonTriviaMazeMain m = new PokemonTriviaMazeMain();
            }
        });
    }
}
