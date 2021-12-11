package View;

import Model.Mazes.Maze;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * DisplayFrame class. Acts at the main JFrame on which all the JPanels reside.
 * @author Dylan & Andrew
 * @version 12/2/2021
 */
public class DisplayFrame extends JFrame implements Serializable {

    /**
     * Width for this JFrame.
     */
    private final int myWidth = 1135;

    /**
     * Height for this JFrame.
     */
    private final int myHeight = 698;

    /**
     * Reference to the main Maze instance for the program.
     */
    private MazePanel myMazePanel;

    /**
     * Reference to ImagePanel used for displaying Pokemon images.
     */
    private ImagePanel myImagePanel;

    /**
     * Reference to QuestionPanel used for displaying question information.
     */
    private QuestionPanel myQuestionPanel;

    /**
     * Reference to MovementPanel used for housing movement JButtons.
     */
    private MovementPanel myMovementPanel;

    /**
     * Reference to OptionsPanel used to house options JButtons.
     */
    private OptionsPanel myOptionsPanel;

    /**
     * Public constructor for DisplayFrame. Sets the size, default close operation,
     * resizable status, layout, and visibility of this JFrame.
     */
    public DisplayFrame(final Maze theMaze, final Player thePlayer) {
        myMazePanel = new MazePanel(theMaze, thePlayer);
        myImagePanel = new ImagePanel();
        myQuestionPanel = new QuestionPanel();
        myMovementPanel = new MovementPanel();
        myOptionsPanel = new OptionsPanel();
        initPanels();
        initSettings();
    }

    /**
     * Dictates general settings for this JFrame, such as size, title, color, and closing operation.
     */
    private void initSettings() {
        this.setTitle("Trivia Maze");
        final Image icon = Toolkit.getDefaultToolkit().getImage("src\\Model\\PokeImages\\pikachu.jpg");
        this.setIconImage(icon);
        this.setBackground(Color.darkGray);
        this.setSize(myWidth, myHeight);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Adds all JPanels to this JFrame.
     */
    private void initPanels() {
        this.add(myMazePanel);
        this.add(myImagePanel);
        this.add(myQuestionPanel);
        this.add(myMovementPanel);
        this.add(myOptionsPanel);
    }

    /**
     * Getter for myOptionPanel.
     * @return OptionPanel
     */
    public OptionsPanel getMyOptionsPanel() {
        return myOptionsPanel;
    }

    /**
     * Getter for myMovementPanel.
     * @return MovementPanel
     */
    public MovementPanel getMyMovementPanel() {
        return myMovementPanel;
    }

    /**
     * Getting for myQuestionPanel.
     * @return QuestionPanel
     */
    public QuestionPanel getMyQuestionPanel() {
        return myQuestionPanel;
    }

    /**
     * Getting for myImagePanel.
     * @return ImagePanel
     */
    public ImagePanel getMyImagePanel() {
        return myImagePanel;
    }

    /**
     * Getter for myMazePanel.
     * @return MazePanel
     */
    public MazePanel getMyMazePanel() {
        return myMazePanel;
    }
}
