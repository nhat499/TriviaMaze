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

public class GameplayController implements Serializable {


    // TODO!!! Javadocs
    private final Maze myMaze;
    private final Player myPlayer;
    private Door myFocusDoor;
    private DisplayFrame myDisplayFrame;

    /**
     * TODO!!!
     */
    public GameplayController() {
        myMaze = new Maze(5, 5);
        myPlayer = new Player(1, 1, myMaze);
        myDisplayFrame = new DisplayFrame(myMaze, myPlayer);
        setupButtonStyles();
        setupButtonActions();
    }

    /**
     * TODO!!!
     */
    private void setupButtonActions() {

        myDisplayFrame.getMyMovementPanel().getMyMoveWestButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyWestDoor().getMyLockedStatus()) {
                    myPlayer.moveWest();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                    myDisplayFrame.getMyMazePanel().updateMaze(myMaze, myPlayer);
                    myDisplayFrame.getMyImagePanel().updateMyImage(myMaze.getRoom(myPlayer.getMyX(),
                            myPlayer.getMyY()).getMyWestDoor().getMyFilePath());
                }
            }
        });

        myDisplayFrame.getMyMovementPanel().getMyMoveNorthButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyNorthDoor().getMyLockedStatus()) {
                    myPlayer.moveNorth();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                    myDisplayFrame.getMyMazePanel().updateMaze(myMaze, myPlayer);
                    myDisplayFrame.getMyImagePanel().updateMyImage(myMaze.getRoom(myPlayer.getMyX(),
                            myPlayer.getMyY()).getMyNorthDoor().getMyFilePath());
                }
            }
        });

        myDisplayFrame.getMyMovementPanel().getMyMoveEastButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyEastDoor().getMyLockedStatus()) {
                    myPlayer.moveEast();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                    myDisplayFrame.getMyMazePanel().updateMaze(myMaze, myPlayer);
                    myDisplayFrame.getMyImagePanel().updateMyImage(myMaze.getRoom(myPlayer.getMyX(),
                            myPlayer.getMyY()).getMyEastDoor().getMyFilePath());
                }
            }
        });

        myDisplayFrame.getMyMovementPanel().getMyMoveSouthButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                if (!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMySouthDoor().getMyLockedStatus()) {
                    myPlayer.moveSouth();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                    myDisplayFrame.getMyMazePanel().updateMaze(myMaze, myPlayer);
                    myDisplayFrame.getMyImagePanel().updateMyImage(myMaze.getRoom(myPlayer.getMyX(),
                            myPlayer.getMyY()).getMySouthDoor().getMyFilePath());
                }
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyEnterButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

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
     * TODO!!!
     */
    private void setupButtonStyles() {
        myDisplayFrame.getMyMovementPanel().getMyMoveWestButton().setBackground(Color.black);
        myDisplayFrame.getMyMovementPanel().getMyMoveWestButton().setForeground(Color.white);
        myDisplayFrame.getMyMovementPanel().getMyMoveWestButton().setBounds(10, 63, 110, 45);
        myDisplayFrame.getMyMovementPanel().getMyMoveWestButton().setEnabled(true);

        myDisplayFrame.getMyMovementPanel().getMyMoveNorthButton().setBackground(Color.black);
        myDisplayFrame.getMyMovementPanel().getMyMoveNorthButton().setForeground(Color.white);
        myDisplayFrame.getMyMovementPanel().getMyMoveNorthButton().setBounds(70, 13, 110, 45);
        myDisplayFrame.getMyMovementPanel().getMyMoveNorthButton().setEnabled(true);

        myDisplayFrame.getMyMovementPanel().getMyMoveEastButton().setBackground(Color.black);
        myDisplayFrame.getMyMovementPanel().getMyMoveEastButton().setForeground(Color.white);
        myDisplayFrame.getMyMovementPanel().getMyMoveEastButton().setBounds(130, 63, 110, 45);
        myDisplayFrame.getMyMovementPanel().getMyMoveEastButton().setEnabled(true);

        myDisplayFrame.getMyMovementPanel().getMyMoveSouthButton().setBackground(Color.black);
        myDisplayFrame.getMyMovementPanel().getMyMoveSouthButton().setForeground(Color.white);
        myDisplayFrame.getMyMovementPanel().getMyMoveSouthButton().setBounds(70, 113, 110, 45);
        myDisplayFrame.getMyMovementPanel().getMyMoveSouthButton().setEnabled(true);

        myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setBackground(Color.black);
        myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setForeground(Color.white);
        myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setBounds(360, 11, 80, 80);
        myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setEnabled(true);

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setBackground(Color.white);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setForeground(Color.black);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setBounds(20, 10, 130, 45);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setEnabled(true);

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setBackground(Color.white);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setForeground(Color.black);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setBounds(20, 48, 130, 45);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setEnabled(true);

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setBackground(Color.white);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setForeground(Color.black);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setBounds(185, 10, 130, 45);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setEnabled(true);

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setBackground(Color.white);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setForeground(Color.black);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setBounds(185, 48, 130, 45);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setEnabled(true);

        myDisplayFrame.getMyOptionsPanel().getMyResetButton().setBackground(Color.black);
        myDisplayFrame.getMyOptionsPanel().getMyResetButton().setForeground(Color.white);
        myDisplayFrame.getMyOptionsPanel().getMyResetButton().setBounds(29, 13, 130, 45);
        myDisplayFrame.getMyOptionsPanel().getMyResetButton().setEnabled(true);

        myDisplayFrame.getMyOptionsPanel().getMyLoadButton().setBackground(Color.black);
        myDisplayFrame.getMyOptionsPanel().getMyLoadButton().setForeground(Color.white);
        myDisplayFrame.getMyOptionsPanel().getMyLoadButton().setBounds(29, 63, 130, 45);
        myDisplayFrame.getMyOptionsPanel().getMyLoadButton().setEnabled(true);

        myDisplayFrame.getMyOptionsPanel().getMyHelpButton().setBackground(Color.black);
        myDisplayFrame.getMyOptionsPanel().getMyHelpButton().setForeground(Color.white);
        myDisplayFrame.getMyOptionsPanel().getMyHelpButton().setBounds(29, 113, 130, 45);
        myDisplayFrame.getMyOptionsPanel().getMyHelpButton().setEnabled(true);
    }

    // main method for testing
    public static void main(String[] args) {
        GameplayController g = new GameplayController();
    }

}