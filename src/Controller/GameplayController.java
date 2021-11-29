package Controller;

import Model.Door;
import Model.Maze;
import Model.Player;
import View.DisplayFrame;
import View.HelpFrame;
import View.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * GameplayController class. Dictates communication between Model and View packages.
 * @Authors - Nhat, Andrew, Dylan
 * @Version - 11/28/2021
 */
public class GameplayController implements Serializable {


    /**
     * Reference to Maze class, used for updating the state in the Model package.
     */
    private final Maze myMaze;

    /**
     * Reference to Player class, used for keeping track of the user while they traverse the Maze.
     */
    private final Player myPlayer;

    /**
     * Reference to door class, reference is updated to different doors while the user traverses the Maze.
     */
    private Door myFocusDoor;

    /**
     * Reference to DisplayFrame class, used to update state in the View package.
     */
    private DisplayFrame myDisplayFrame;

    /**
     * Parameterless constructor for GameplayController.
     */
    public GameplayController() {
        myMaze = new Maze(5, 5);
        myPlayer = new Player(1, 1, myMaze);
        myDisplayFrame = new DisplayFrame(myMaze, myPlayer);
        setupMovementActions();
        setupQuestionActions();
        setupOptionsActions();
    }

    /**
     * Adds action listeners to JButtons from MovementPanel, and dictates data manipulation
     * that occurs when said buttons are utilized.
     */
    private void setupMovementActions() {
        myDisplayFrame.getMyMovementPanel().getMyMoveWestButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myFocusDoor = myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyWestDoor();
                if (!myFocusDoor.getMyLockedStatus() && !myFocusDoor.getMyOpenStatus()) {
                    deployQuestion();
                } else if (myFocusDoor.getMyOpenStatus()){
                    myPlayer.moveWest();
                    myDisplayFrame.getMyMazePanel().repaint();
                }
            }
        });

        myDisplayFrame.getMyMovementPanel().getMyMoveNorthButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myFocusDoor = myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyNorthDoor();
                if (!myFocusDoor.getMyLockedStatus() && !myFocusDoor.getMyOpenStatus()) {
                    deployQuestion();
                } else if (myFocusDoor.getMyOpenStatus()){
                    myPlayer.moveNorth();
                    myDisplayFrame.getMyMazePanel().repaint();
                }
            }
        });

        myDisplayFrame.getMyMovementPanel().getMyMoveEastButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myFocusDoor = myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyEastDoor();
                if (!myFocusDoor.getMyLockedStatus() && !myFocusDoor.getMyOpenStatus()) {
                    deployQuestion();
                } else if (myFocusDoor.getMyOpenStatus()){
                    myPlayer.moveEast();
                    myDisplayFrame.getMyMazePanel().repaint();
                }
            }
        });

        myDisplayFrame.getMyMovementPanel().getMyMoveSouthButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myFocusDoor = myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMySouthDoor();
                if (!myFocusDoor.getMyLockedStatus() && !myFocusDoor.getMyOpenStatus()) {
                    deployQuestion();
                } else if (myFocusDoor.getMyOpenStatus()){
                    myPlayer.moveSouth();
                    myDisplayFrame.getMyMazePanel().repaint();
                }
            }
        });
    }

    /**
     * Adds action listeners to JButtons from QuestionPanel, and dictates data manipulation
     * that occurs when said buttons are utilized.
     */
    private void setupQuestionActions() {
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setSelected(false);
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setSelected(false);
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setSelected(false);
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setSelected(false);
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyEnterButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                String answerInput = null;
                if (myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().isSelected()) {
                    answerInput = myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().getText();
                } else if (myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().isSelected()) {
                    answerInput = myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().getText();
                } else if (myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().isSelected()) {
                    answerInput = myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().getText();
                } else if (myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().isSelected()){
                    answerInput = myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().getText();
                }
                myFocusDoor.attemptToOpen(answerInput);
                myDisplayFrame.getMyMazePanel().repaint();
                dismissQuestion();
            }
        });
    }

    /**
     * Adds action listeners to JButtons from OptionsPanel, and dictates data manipulation
     * that occurs when said buttons are utilized.
     */
    private void setupOptionsActions() {
        myDisplayFrame.getMyOptionsPanel().getMyHelpButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                HelpFrame frame = new HelpFrame();
                frame.start();
            }
        });

        myDisplayFrame.getMyOptionsPanel().getMyResetButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

        myDisplayFrame.getMyOptionsPanel().getMyLoadButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });
    }

    /**
     * Collect question information from myFocusDoor and display the possible answers
     * via myOptionButtons on the questionPanel associated with myDisplayFrame.
     */
    private void deployQuestion() {
        ArrayList<String> answers = myFocusDoor.getMyAnswers();
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setEnabled(true);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setEnabled(true);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setEnabled(true);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setEnabled(true);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setText(answers.get(0));
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setText(answers.get(1));
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setText(answers.get(2));
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setText(answers.get(3));

        myDisplayFrame.getMyImagePanel().updateMyImage(myFocusDoor.getMyFilePath());
    }

    /**
     * Called after the user answers a question. Clears the question information
     * from myOptionButtons.
     */
    private void dismissQuestion() {
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setText("");
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setText("");
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setText("");
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setText("");
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setSelected(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setSelected(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setSelected(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setSelected(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setEnabled(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setEnabled(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setEnabled(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setEnabled(false);
    }

    // main method for testing
    public static void main(String[] args) {
        GameplayController g = new GameplayController();
    }

}