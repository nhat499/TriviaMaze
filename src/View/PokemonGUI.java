package View;

import Model.Maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    public void start() throws IOException {

        myFrame.setTitle("Pokemon Trivia Maze");
        myFrame.setLayout(new BorderLayout());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Image icon = Toolkit.getDefaultToolkit().getImage("src\\Model\\PokeImages\\pikachu.jpg");
        myFrame.setIconImage(icon);



        mazePanel();

        buttonsPanel();
        questionAndAns();
        directionsPanel();

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
        DrawMaze maze = new DrawMaze();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(maze);
        myFrame.add(panel, BorderLayout.WEST);
    }

    /**
     * JPanel for the help buttons.
     */
    private void buttonsPanel() {
        final JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        panel.add(HELP_BUTTON);

        HELP_BUTTON.setEnabled(true);
        myFrame.add(panel, BorderLayout.NORTH);
    }

    /**
     * create directional button and put it on a
     * panel.
     */
    private JPanel directionsPanelHelper() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton leftBtn = new JButton("move left");
        leftBtn.setEnabled(true);
        JButton rightBtn = new JButton("move right");
        rightBtn.setEnabled(true);
        JButton upBtn = new JButton("move up");
        upBtn.setEnabled(true);
        JButton downBtn = new JButton("move down");
        upBtn.setEnabled(true);
        JButton test = new JButton("test");
        panel.add(upBtn, BorderLayout.NORTH);
        panel.add(downBtn, BorderLayout.SOUTH);
        panel.add(leftBtn, BorderLayout.WEST);
        panel.add(rightBtn, BorderLayout.EAST);
        return panel;
    }

    /**
     * create a panel to hold the directional keys,
     * it is put on the "east" side of the frame
     */
    private void directionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel direction = directionsPanelHelper();
        panel.add(direction,BorderLayout.SOUTH);
        myFrame.add(panel, BorderLayout.EAST);
    }

    /**
     * create the question and answer panels and put in
     * on the frame at "center"
     * @throws IOException for reading a jpg file
     */
    private void questionAndAns() throws IOException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel question = new JLabel("whos that pokemon?");
        JLabel img = getPicture();
        JLabel answer = new JLabel("the answer ...");
        panel.add(question, BorderLayout.NORTH);
        panel.add(img, BorderLayout.CENTER);
        panel.add(answer, BorderLayout.SOUTH);
        myFrame.add(panel, BorderLayout.CENTER);
    }

    /**
     * gets a picture of a pokemon.
     */
    private JLabel getPicture() throws IOException {
        BufferedImage myPicture = ImageIO.read(new File(
                ".\\TriviaMaze\\src\\Model\\PokeImages\\zubat.jpg"));
        JLabel img = new JLabel(new ImageIcon(myPicture));
        return img;
    }
}
