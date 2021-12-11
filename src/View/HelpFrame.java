package View;

import javax.swing.*;
import java.io.Serializable;

/**
 * HelpFrame class. Used to generate tips for playing the game.
 * @author Andrew
 * @version 1.0
 */
public class HelpFrame extends JFrame implements Serializable {

    /**
     * Size of the help frame.
     */
    private static final int SIZE = 400;

    /**
     * Initialize and launch the help frames.
     */
    public void start() {
        this.setSize(SIZE, SIZE);
        JOptionPane.showMessageDialog(null, "The goal of this game is to move through " +
                "the maze and answer which pokemon you encounter");
        JOptionPane.showMessageDialog(null, "Use the directions to decide where you want to move " +
                "within the maze");
        JOptionPane.showMessageDialog(null, "Once you successfully answer a question, new doors will " +
                "become available in the new room ");
        JOptionPane.showMessageDialog(null, "Be warned though, missing a question will result in " +
                "that door being permanently locked. If all doors in your path are permanently locked, you lose!");
    }
}
