package Controller;

import Model.Maze;
import Model.Player;
import View.PokemonGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {

    private JButton myHelp;
    private JButton myUp;
    private JButton myDown;
    private JButton myLeft;
    private JButton myRight;
    private Maze myMaze;
    private Player myPlayer;

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
