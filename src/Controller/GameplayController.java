package Controller;

import Main.PokemonTriviaMazeMain;
import Model.Door;
import Model.Maze;
import Model.Player;
import View.ContinueFrame;
import View.DisplayFrame;
import View.HelpFrame;
import View.WinningFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * GameplayController class. Dictates communication between Model and View packages.
 * @Authors - Nhat, Andrew, Dylan
 * @Version - 11/28/2021
 */
public class GameplayController implements Serializable {

    /**
     * Size of the Maze.
     */
    private static final int MAZE_SIZE = 5;

    /**
     * Reference to Maze class, used for updating the state in the Model package.
     */
    private Maze myMaze;

    /**
     * Reference to Player class, used for keeping track of the user while they traverse the Maze.
     */
    private Player myPlayer;

    /**
     * Reference to door class, reference is updated to different doors while the user traverses the Maze.
     */
    private Door myFocusDoor;

    /**
     * Reference to DisplayFrame class, used to update state in the View package.
     */
    private DisplayFrame myDisplayFrame;

    /**
     * Reference to PokemonTriviaMazeMain that houses this GameplayController.
     */
    private PokemonTriviaMazeMain myMain;


    /**
     * Parameterless constructor for GameplayController.
     */
    public GameplayController(final PokemonTriviaMazeMain theMain) {
        myMain = theMain;
        myMaze = new Maze(MAZE_SIZE, MAZE_SIZE);
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
                    checkPlayerLocation();
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
                    checkPlayerLocation();
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
                    checkPlayerLocation();
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
                    checkPlayerLocation();
                }
            }
        });
    }

    /**
     * Adds action listeners to JButtons from QuestionPanel, and dictates data manipulation
     * that occurs when said buttons are utilized.
     */
    private void setupQuestionActions() {
        myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setEnabled(false);
        myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setEnabled(true);
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setEnabled(true);
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setEnabled(true);
            }
        });

        myDisplayFrame.getMyQuestionPanel().getMyOptionButton4().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton1().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton2().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyOptionButton3().setSelected(false);
                myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setEnabled(true);

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
                if (!myMaze.escapeAble(myPlayer.getMyX(), myPlayer.getMyY())) {
                    ContinueFrame f = new ContinueFrame();
                    f.start();
                    myMain.setMyController(new GameplayController(myMain));
                    myDisplayFrame.setVisible(false);
                }
                dismissQuestion();
                myDisplayFrame.getMyQuestionPanel().getMyEnterButton().setEnabled(false);
            }
        });
    }

    /**
     * Adds action listeners to JButtons from OptionsPanel, and dictates data manipulation
     * that occurs when said buttons are utilized.
     */
    public void setupOptionsActions() {
        myDisplayFrame.getMyOptionsPanel().getMyHelpButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                HelpFrame frame = new HelpFrame();
                frame.start();
            }
        });

        myDisplayFrame.getMyOptionsPanel().getMySaveButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                SaveUserData.save(GameplayController.this);
            }
        });

        myDisplayFrame.getMyOptionsPanel().getMyLoadButton().addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                try {
                    SaveUserData.retrieve();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
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

        myDisplayFrame.getMyImagePanel().updateMyImage("TriviaMaze/src/View/DarkPokeImages/" +
                myFocusDoor.getMyCorrectAnswer() + ".png");
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

        myDisplayFrame.getMyImagePanel().updateMyImage("TriviaMaze/src/View/PokeImages/" +
                myFocusDoor.getMyCorrectAnswer() + ".jpg");
    }

    /**
     * Checks to see if the player has completed the maze.
     */
    private void checkPlayerLocation() {
        if (myPlayer.getMyX() == MAZE_SIZE && myPlayer.getMyY() == MAZE_SIZE) {
            WinningFrame f = new WinningFrame();
            f.start();
            myMain.setMyController(new GameplayController(myMain));
            myDisplayFrame.setVisible(false);
        }
    }

//    public void save(final GameplayController theObject){
//
//        try {
//            FileOutputStream file = new FileOutputStream(filename);
//            ObjectOutputStream out = new ObjectOutputStream(file);
//
//            out.writeObject(theObject);
//            out.close();
//            file.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}