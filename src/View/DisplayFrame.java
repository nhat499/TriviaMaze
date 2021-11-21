package View;

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
    public DisplayFrame() {
        myMazePanel = new MazePanel();
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

    // main method for testing during development
    public static void main(String[] args) {
        DisplayFrame d = new DisplayFrame();
    }
}
