package View;

import Controller.GameplayController;
import Controller.SaveUserData;
import Model.Mazes.MazeFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * DifficultyFrame class which produces a small JFrame when the game is started, allowing the user
 * to choose the difficulty of the maze they will traverse.
 * @author Dylan and Andrew
 * @version 12/11/2021
 */
public class DifficultyFrame extends JFrame {

    /**
     * The size of the JFrame in pixels.
     */
    private final static int SIZE = 250;

    /**
     * Reference to myEasyButton.
     */
    private final JButton myEasyButton;

    /**
     * Reference to myMediumButton.
     */
    private final JButton myMediumButton;

    /**
     * Reference to myHardButton.
     */
    private final JButton myHardButton;

    /**
     * Reference to myLoadButton.
     */
    private final JButton myLoadButton;

    /**
     * Reference to myJPanel.
     */
    private final JPanel myPanel;

    /**
     * Reference to myLabel.
     */
    private final JLabel myLabel;

    /**
     * Reference to myController.
     */
    private GameplayController myController;

    /**
     * Public parameterized constructor for DifficultyFrame class.
     */
    public DifficultyFrame(final GameplayController theController) {
        myController = theController;
        myEasyButton = new JButton("Easy");
        myMediumButton = new JButton("Medium");
        myHardButton = new JButton("Hard");
        myLoadButton = new JButton("Load");
        myLabel = new JLabel("Choose Your Difficulty");
        myPanel = new JPanel();
        setupButtons();
        setupLabel();
        setupPanel();
        setupFrame();
    }

    /**
     * Set size and layout for myJPanel, add JButtons and JLabels to it.
     */
    private void setupPanel() {
        myPanel.setLayout(null);
        myPanel.setSize(SIZE, 300);
        myPanel.add(myEasyButton);
        myPanel.add(myMediumButton);
        myPanel.add(myHardButton);
        myPanel.add(myLoadButton);
        myPanel.add(myLabel);
        myPanel.setBackground(Color.white);
    }

    /**
     * Set size, color, exit behavior, and general settings for this JFrame.
     */
    private void setupFrame() {
        setSize(SIZE, 300);
        setBackground(Color.black);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        add(myPanel);
        setVisible(true);
    }

    /**
     * Set style and add action listeners to JButtons.
     */
    private void setupButtons() {
        final int xCoord = 53;
        final int buttonWidth = 130;
        final int buttonHeight = 40;

        myEasyButton.setBackground(Color.black);
        myEasyButton.setForeground(Color.white);
        myEasyButton.setBounds(xCoord, 65, buttonWidth, buttonHeight);
        myEasyButton.setEnabled(true);
        myEasyButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myController.enableGame(MazeFactory.CreateMaze("easy"));
                DifficultyFrame.super.dispose();
            }
        });


        myMediumButton.setBackground(Color.black);
        myMediumButton.setForeground(Color.white);
        myMediumButton.setBounds(xCoord, 110, buttonWidth, buttonHeight);
        myMediumButton.setEnabled(true);
        myMediumButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myController.enableGame(MazeFactory.CreateMaze("medium"));
                DifficultyFrame.super.dispose();
            }
        });

        myHardButton.setBackground(Color.black);
        myHardButton.setForeground(Color.white);
        myHardButton.setBounds(xCoord, 155, buttonWidth, buttonHeight);
        myHardButton.setEnabled(true);
        myHardButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myController.enableGame(MazeFactory.CreateMaze("hard"));
                DifficultyFrame.this.dispose();
            }
        });

        myLoadButton.setBackground(Color.black);
        myLoadButton.setForeground(Color.white);
        myLoadButton.setBounds(xCoord, 200, buttonWidth, buttonHeight);
        myLoadButton.setEnabled(true);
        myLoadButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myController = SaveUserData.retrieve();
                myController.getMyDisplayFrame().repaint();
                myController.getMyDisplayFrame().revalidate();
                DifficultyFrame.this.dispose();
            }
        });
    }



    private void setupLabel() {
        myLabel.setSize(250, 30);
        myLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
        myLabel.setLayout(null);
        myLabel.setLocation(20, 20);
    }
}
