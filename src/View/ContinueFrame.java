package View;

import javax.swing.*;

/**
 * JFrame class. Launched when the player cannot escape the maze.
 * Borrowed the layout of this class from HelpFrame that Andrew wrote.
 * @author Dylan & Andrew
 * @version 12/3/2021
 */
public class ContinueFrame extends JFrame {

    /**
     * Size of the JFrame.
     */
    private static final int SIZE = 400;

    /**
     * Initialize and launch the ContinueFrame.
     */
    public void start() {
        this.setSize(SIZE, SIZE);
        JOptionPane.showMessageDialog(null, "Good Try! Better luck next time!");
    }
}
