package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 * Houses the JButton for player movement/door selection.
 * @author Dylan
 * @version 11/28/2021
 */
public class MovementPanel extends JPanel implements Serializable {

    /**
     * JButton for moving the player west.
     */
    private final JButton myMoveWestButton;

    /**
     * JButton for moving the player north.
     */
    private final JButton myMoveNorthButton;

    /**
     * JButton for moving the player east.
     */
    private final JButton myMoveEastButton;

    /**
     * JButton for moving the player south.
     */
    private final JButton myMoveSouthButton;

    /**
     * Public constructor for MovementPanel.
     */
    public MovementPanel() {
        this.setLayout(null);
        setSize(250, 170);
        setLocation(660, 480);
        setBackground(Color.white);
        myMoveWestButton = new JButton("West");
        myMoveNorthButton = new JButton("North");
        myMoveEastButton = new JButton("East");
        myMoveSouthButton = new JButton("South");
        setupButtons();
        this.add(myMoveWestButton);
        this.add(myMoveNorthButton);
        this.add(myMoveEastButton);
        this.add(myMoveSouthButton);
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g = (Graphics2D) theGraphics;
        final Rectangle border  = new Rectangle(2, 3, 245, 165);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        g.draw(border);
    }

    /**
     * Dictates location (x, y coordinates), size, color, and text of JButtons.
     */
    private void setupButtons() {
        final int buttonWidth = 110;
        final int buttonHeight = 45;
        final int xVerButtons = 70;
        final int xWestButton = 10;
        final int xEastButton = 130;
        final int yHoriButtons = 63;
        final int yNorthButton = 13;
        final int ySouthButton = 113;

        myMoveWestButton.setBackground(Color.black);
        myMoveWestButton.setForeground(Color.white);
        myMoveWestButton.setBounds(xWestButton, yHoriButtons, buttonWidth, buttonHeight);
        myMoveWestButton.setEnabled(false);

        myMoveNorthButton.setBackground(Color.black);
        myMoveNorthButton.setForeground(Color.white);
        myMoveNorthButton.setBounds(xVerButtons, yNorthButton, buttonWidth, buttonHeight);
        myMoveNorthButton.setEnabled(false);

        myMoveEastButton.setBackground(Color.black);
        myMoveEastButton.setForeground(Color.white);
        myMoveEastButton.setBounds(xEastButton, yHoriButtons, buttonWidth, buttonHeight);
        myMoveEastButton.setEnabled(false);

        myMoveSouthButton.setBackground(Color.black);
        myMoveSouthButton.setForeground(Color.white);
        myMoveSouthButton.setBounds(xVerButtons, ySouthButton, buttonWidth, buttonHeight);
        myMoveSouthButton.setEnabled(false);
    }

    /**
     * Get myMoveSouthButton.
     * @return JButton
     */
    public JButton getMyMoveSouthButton() {
        return myMoveSouthButton;
    }

    /**
     * Get myMoveEastButton.
     * @return JButton
     */
    public JButton getMyMoveEastButton() {
        return myMoveEastButton;
    }

    /**
     * Get myMoveNorthButton.
     * @return JButton
     */
    public JButton getMyMoveNorthButton() {
        return myMoveNorthButton;
    }

    /**
     * Get myMoveWestButton.
     * @return JButton
     */
    public JButton getMyMoveWestButton() {
        return myMoveWestButton;
    }
}
