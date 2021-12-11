package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * OptionsPanel class. Houses JButton used to reset the game, load a saved game, or get help.
 * @author Dylan
 * @version 11/28/2021
 */
public class OptionsPanel extends JPanel implements Serializable {

    /**
     * JButton used to reset the game.
     */
    private final JButton myResetButton;

    /**
     * JButton used to produce a helpful pop-up.
     */
    private final JButton myHelpButton;

    /**
     * JButton used to load a saved game.
     */
    private final JButton myLoadButton;


    /**
     * Public constructor for OptionsPanel.
     */
    public OptionsPanel() {
        this.setLayout(null);
        setSize(190, 170);
        setLocation(920, 480);
        setBackground(Color.white);
        myResetButton = new JButton("Save");
        myHelpButton = new JButton("Help");
        myLoadButton = new JButton("Load");
        setupButtons();
        this.add(myResetButton);
        this.add(myHelpButton);
        this.add(myLoadButton);

    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g = (Graphics2D) theGraphics;
        final Rectangle border  = new Rectangle(2, 3, 185, 165);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        g.draw(border);
    }

    /**
     * Dictates the location (x, y coordinates), size, and appearances of the
     * JButton associated with this class.
     */
    private void setupButtons() {
        final int xCoordinate = 29;
        final int buttonWidth = 130;
        final int buttonHeight = 45;

        myResetButton.setBackground(Color.black);
        myResetButton.setForeground(Color.white);
        myResetButton.setBounds(xCoordinate, 13, buttonWidth, buttonHeight);
        myResetButton.setEnabled(true);

        myLoadButton.setBackground(Color.black);
        myLoadButton.setForeground(Color.white);
        myLoadButton.setBounds(xCoordinate, 63, buttonWidth, buttonHeight);
        myLoadButton.setEnabled(true);

        myHelpButton.setBackground(Color.black);
        myHelpButton.setForeground(Color.white);
        myHelpButton.setBounds(xCoordinate, 113, buttonWidth, buttonHeight);
        myHelpButton.setEnabled(true);
    }

    /**
     * Get myLoadButton.
     * @return JButton
     */
    public JButton getMyLoadButton() {
        return myLoadButton;
    }

    /**
     * Get myHelpButton.
     * @return JButton
     */
    public JButton getMyHelpButton() { return myHelpButton; }

    /**
     * Get myResetButton.
     * @return JButton
     */
    public JButton getMySaveButton() {
        return myResetButton;
    }
}
