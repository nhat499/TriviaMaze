package Main;

import Controller.GameplayController;
import Controller.SaveUserData;
import Model.Player;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author Andrew
 * @version 2.0
 * This is the main class that starts the whole Pokemon Trivia Maze project.
 */
public class PokemonTriviaMazeMain implements Serializable {

    /**
     * The main GameplayController.
     */
    private GameplayController myController;

    /**
     * Constructor that instantiates a new GameplayController.
     */
    private PokemonTriviaMazeMain() {
        myController = new GameplayController(this);
    }

    /**
     * Setter for the GameplayController (for loading data).
     * @param theController
     */
    public void setMyController(final GameplayController theController) {
        myController = theController;
        myController.getMyDisplayFrame().repaint();
        myController.getMyDisplayFrame().revalidate();
    }

    /**
     * Getter for the GameplayController.
     * @return
     */
    public GameplayController getController () {
        return myController;
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
