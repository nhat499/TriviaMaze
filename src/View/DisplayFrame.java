package View;

import Model.Maze;
import Model.Player;

import javax.swing.*;
import java.awt.*;

/**
 * TODO!!!
 */
public class DisplayFrame extends JFrame {

    /**
     * Width for this JFrame.
     */
    private final int myWidth = 1135;

    /**
     * Height for this JFrame.
     */
    private final int myHeight = 698;

    // TODO!!! Javadocs
    private final MazePanel myMazePanel;
    private final ImagePanel myImagePanel;
    private final QuestionPanel myQuestionPanel;
    private final MovementPanel myMovementPanel;
    private final OptionsPanel myOptionsPanel;

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
     * TODO!!!
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
     * TODO!!!
     */
    private void initPanels() {
        this.add(myMazePanel);
        this.add(myImagePanel);
        this.add(myQuestionPanel);
        this.add(myMovementPanel);
        this.add(myOptionsPanel);
    }

    public OptionsPanel getMyOptionsPanel() {
        return myOptionsPanel;
    }

    public MovementPanel getMyMovementPanel() {
        return myMovementPanel;
    }

    public QuestionPanel getMyQuestionPanel() {
        return myQuestionPanel;
    }

    public ImagePanel getMyImagePanel() {
        return myImagePanel;
    }

    public MazePanel getMyMazePanel() {
        return myMazePanel;
    }
}
