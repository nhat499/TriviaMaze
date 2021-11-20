package Controller;

import Model.Maze;
import Model.Player;
import View.PokemonGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Andrew and Nhat
 * @version 1.0
 * This class allows the player to move throughout the maze utilizing
 * the up, down, left, and right buttons provided in the GUI.
 */
public class Control {

    /**
     * Help button
     */
    private JButton myHelp;

    /**
     * Up button
     */
    private JButton myUp;

    /**
     * Down button
     */
    private JButton myDown;

    /**
     * Left Button
     */
    private JButton myLeft;

    /**
     * Right Button
     */
    private JButton myRight;

    /**
     * Maze used for the game
     */
    private Maze myMaze;

    /**
     * Player used for the game
     */
    private Player myPlayer;

    /**
     * Constructor that initializes fields.
     */
    public Control() {
        PokemonGUI pokemonGUI = new PokemonGUI();
        myHelp = pokemonGUI.getHelpButton();
        myUp = pokemonGUI.getUpBtn();
        myDown = pokemonGUI.getDownBtn();
        myRight = pokemonGUI.getRightBtn();
        myLeft = pokemonGUI.getLeftBtn();
        myMaze = new Maze(5, 5);
        myPlayer = new Player(1, 1, myMaze);

    }

    /**
     * Class that houses action listeners and their anonymous inner classes.
     */
    public void setupButtons() {
        myHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Help button pressed");
            }
        });
        myUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyNorthDoor().getMyLockedStatus()) {
                    myPlayer.moveNorth();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                }

            }
        });
        myDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                myMaze.printTest();
                if(!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMySouthDoor().getMyLockedStatus()) {
                    myPlayer.moveSouth();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                }
            }
        });
        myRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyEastDoor().getMyLockedStatus()) {
                    myPlayer.moveEast();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                }
            }
        });
        myLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!myMaze.getRoom(myPlayer.getMyX(), myPlayer.getMyY()).getMyWestDoor().getMyLockedStatus()) {
                    myPlayer.moveWest();
                    System.out.println(myPlayer.getMyX() + ", " + myPlayer.getMyY());
                }
            }
        });
    }
}
