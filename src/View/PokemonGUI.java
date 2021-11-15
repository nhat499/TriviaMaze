package View;

import Model.Maze;

import javax.swing.*;
import java.awt.*;

/**
 * @author Andrew
 * @version 1.0
 * This is the class that creates the GUI for our players
 * to view and interact with.
 */
public class PokemonGUI extends JFrame {

    /**
     * Button to access the help tab.
     */
    private static final JButton HELP_BUTTON = new JButton("Help");

    /**
     * JFrame used for the GUI.
     */
    private final JFrame myFrame;

    /**
     * Panel for the GUI.
     */
    private final JPanel myPanel;

    /**
     * JLabel for any images.
     */
    private final JLabel myLabel;

    /**
     * Size of JFrame.
     */
    private final Dimension mySize;

    /**
     * Maze Object for building the maze.
     */
    private final Maze myMaze;

    /**
     * Constructor for instantiating fields.
     */
    public PokemonGUI() {
        super();
        myPanel = new JPanel();
        myFrame = new JFrame();
        myLabel = new JLabel();
        mySize = new Dimension();
        myMaze = new Maze(5, 5);
    }

    public JButton getHelpButton() {
        return HELP_BUTTON;
    }
    /**
     * Start method used when compiling the GUI class.
     */
    public void start() {

        myFrame.setTitle("Pokemon Trivia Maze");
        myFrame.setLayout(new BorderLayout());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Image icon = Toolkit.getDefaultToolkit().getImage("src\\Model\\PokeImages\\pikachu.jpg");
        myFrame.setIconImage(icon);

        buttonsPanel();
        mazePanel();

        myFrame.pack();
        myFrame.setResizable(true);
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
    }

    /**
     * JPanel for the maze.
     */
    private void mazePanel() {
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

    }

    /**
     * JPanel for the buttons.
     */
    private void buttonsPanel() {
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(HELP_BUTTON, BorderLayout.NORTH);

        HELP_BUTTON.setEnabled(true);
        myFrame.add(panel);
    }

    /**
     * JPanel for the directions.
     */
    private void directionsPanel() {
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        myFrame.add(panel);
    }
}
