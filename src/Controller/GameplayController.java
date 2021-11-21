package Controller;

import Model.Door;
import Model.Maze;
import Model.Player;
import View.ImagePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameplayController {

    /**
     * TODO!!! Javadoc
     */
    private static GameplayController uniqueInstance;

    // TODO!!! Javadocs
    private final Maze myMaze;
    private final Player myPlayer;
    private JButton myMoveWestButton;
    private JButton myMoveNorthButton;
    private JButton myMoveEastButton;
    private JButton myMoveSouthButton;
    private JButton myHelpButton;
    private JButton myResetButton;
    private JButton myLoadButton;
    private JButton myEnterButton;
    private JRadioButton myOptionButton1;
    private JRadioButton myOptionButton2;
    private JRadioButton myOptionButton3;
    private JRadioButton myOptionButton4;
    private Door myFocusDoor;

    /**
     * TODO!!!
     */
    private GameplayController() {
        myMaze = new Maze(5,5);
        myPlayer = new Player(1,1, myMaze);
        setupButtonActions();
        setupButtonStyles();
    }

    /**
     * TODO!!!
     */
    private void setupButtonActions() {
        myMoveWestButton = new JButton("West");
        myMoveNorthButton = new JButton("North");
        myMoveEastButton = new JButton("East");
        myMoveSouthButton = new JButton("South");

        myEnterButton = new JButton("Enter");
        myOptionButton1 = new JRadioButton("Place holder");
        myOptionButton2 = new JRadioButton("Place holder");
        myOptionButton3 = new JRadioButton("Place holder");
        myOptionButton4 = new JRadioButton("Place holder");

        myHelpButton = new JButton("Help");
        myResetButton = new JButton("Reset");
        myLoadButton = new JButton("Load Game");

        myMoveWestButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

        myMoveNorthButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

        myMoveEastButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {

            }
        });

        myMoveSouthButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

        myEnterButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

        myOptionButton1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myOptionButton2.setSelected(false);
                myOptionButton3.setSelected(false);
                myOptionButton4.setSelected(false);
            }
        });

        myOptionButton2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myOptionButton1.setSelected(false);
                myOptionButton3.setSelected(false);
                myOptionButton4.setSelected(false);
            }
        });

        myOptionButton3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myOptionButton1.setSelected(false);
                myOptionButton2.setSelected(false);
                myOptionButton4.setSelected(false);
            }
        });

        myOptionButton4.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myOptionButton1.setSelected(false);
                myOptionButton2.setSelected(false);
                myOptionButton3.setSelected(false);
            }
        });

        myHelpButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

        myResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });

        myLoadButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                // action
            }
        });
    }

    /**
     * TODO!!!
     */
    private void setupButtonStyles() {
        myMoveWestButton.setBackground(Color.black);
        myMoveWestButton.setForeground(Color.white);
        myMoveWestButton.setBounds(10, 63, 110, 45);
        myMoveWestButton.setEnabled(true);

        myMoveNorthButton.setBackground(Color.black);
        myMoveNorthButton.setForeground(Color.white);
        myMoveNorthButton.setBounds(70, 13, 110, 45);
        myMoveNorthButton.setEnabled(true);

        myMoveEastButton.setBackground(Color.black);
        myMoveEastButton.setForeground(Color.white);
        myMoveEastButton.setBounds(130, 63, 110, 45);
        myMoveEastButton.setEnabled(true);

        myMoveSouthButton.setBackground(Color.black);
        myMoveSouthButton.setForeground(Color.white);
        myMoveSouthButton.setBounds(70, 113, 110, 45);
        myMoveSouthButton.setEnabled(true);

        myEnterButton.setBackground(Color.black);
        myEnterButton.setForeground(Color.white);
        myEnterButton.setBounds(360, 11, 80, 80);
        myEnterButton.setEnabled(true);

        myOptionButton1.setBackground(Color.white);
        myOptionButton1.setForeground(Color.black);
        myOptionButton1.setBounds(20, 10, 130, 45);
        myOptionButton1.setEnabled(true);

        myOptionButton2.setBackground(Color.white);
        myOptionButton2.setForeground(Color.black);
        myOptionButton2.setBounds(20, 48, 130, 45);
        myOptionButton2.setEnabled(true);

        myOptionButton3.setBackground(Color.white);
        myOptionButton3.setForeground(Color.black);
        myOptionButton3.setBounds(185, 10, 130, 45);
        myOptionButton3.setEnabled(true);

        myOptionButton4.setBackground(Color.white);
        myOptionButton4.setForeground(Color.black);
        myOptionButton4.setBounds(185, 48, 130, 45);
        myOptionButton4.setEnabled(true);

        myResetButton.setBackground(Color.black);
        myResetButton.setForeground(Color.white);
        myResetButton.setBounds(29, 13, 130, 45);
        myResetButton.setEnabled(true);

        myLoadButton.setBackground(Color.black);
        myLoadButton.setForeground(Color.white);
        myLoadButton.setBounds(29, 63, 130, 45);
        myLoadButton.setEnabled(true);

        myHelpButton.setBackground(Color.black);
        myHelpButton.setForeground(Color.white);
        myHelpButton.setBounds(29, 113, 130, 45);
        myHelpButton.setEnabled(true);

    }

    /**
     * TODO!!!
     */
    public static GameplayController getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new GameplayController();
        }
        return uniqueInstance;
    }

    /**
     * TODO!!!
     * @return
     */
    public Maze getMyMaze() {
        return myMaze;
    }

    /**
     * TODO!!!
     * @return
     */
    public Door getMyFocusDoor() {
        return myFocusDoor;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getMyMoveWestButton() {
        return myMoveWestButton;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getMyMoveNorthButton() {
        return myMoveNorthButton;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getMyMoveEastButton() {
        return myMoveEastButton;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getMyMoveSouthButton() {
        return myMoveSouthButton;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getMyEnterButton() {
        return myEnterButton;
    }

    /**
     * TODO!!!
     * @return
     */
    public JRadioButton getMyOptionButton1() {return myOptionButton1; }

    /**
     * TODO!!!
     * @return
     */
    public JRadioButton getMyOptionButton2() {
        return myOptionButton2;
    }

    /**
     * TODO!!!
     * @return
     */
    public JRadioButton getMyOptionButton3() {
        return myOptionButton3;
    }

    /**
     * TODO!!!
     * @return
     */
    public JRadioButton getMyOptionButton4() {
        return myOptionButton4;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getMyHelpButton() {
        return myHelpButton;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getResetButton() {
        return myResetButton;
    }

    /**
     * TODO!!!
     * @return
     */
    public JButton getLoadButton() {
        return myLoadButton;
    }
}
