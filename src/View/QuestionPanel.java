package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;

/**
 * QuestionPanel class. Displays question information, with each option associated with a
 * JRadioButton.
 * @author Dylan
 * @version 11/28/2021
 */
public class QuestionPanel extends JPanel {

    /**
     * Used to display and choose a question option.
     */
    private final JRadioButton myOptionButton1;

    /**
     * Used to display and choose a question option.
     */
    private final JRadioButton myOptionButton2;

    /**
     * Used to display and choose a question option.
     */
    private final JRadioButton myOptionButton3;

    /**
     * Used to display and choose a question option.
     */
    private final JRadioButton myOptionButton4;

    /**
     * Used to finalize a choice from the multiple choice question.
     */
    private final JButton myEnterButton;


    /**
     * Public constructor for QuestionPanel.
     */
    public QuestionPanel() {
        this.setLayout(null);
        setSize(450, 100);
        setLocation(660, 370);
        setBackground(Color.white);
        myOptionButton1 = new JRadioButton();
        myOptionButton2 = new JRadioButton();
        myOptionButton3 = new JRadioButton();
        myOptionButton4 = new JRadioButton();
        myEnterButton = new JButton("Enter!");
        setupButtons();
        this.add(myOptionButton1);
        this.add(myOptionButton2);
        this.add(myOptionButton3);
        this.add(myOptionButton4);
        this.add(myEnterButton);
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g = (Graphics2D) theGraphics;
        final Rectangle border  = new Rectangle(2, 3, 445, 95);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        g.draw(border);
    }

    /**
     * Dictates the location (x, y coordinates), size, and color of JButtons on this JPanel.
     */
    private void setupButtons() {
        final int enterButtonDimension = 80;
        final int buttonWidth = 130;
        final int buttonHeight = 45;
        final int xLeftButtons = 20;
        final int xRightButtons = 185;
        final int xEnterButton = 360;
        final int yTopButtons = 10;
        final int yButtonButtons = 48;

        myEnterButton.setBackground(Color.black);
        myEnterButton.setForeground(Color.white);
        myEnterButton.setBounds(xEnterButton, yTopButtons, enterButtonDimension, enterButtonDimension);
        myEnterButton.setEnabled(true);

        myOptionButton1.setBackground(Color.white);
        myOptionButton1.setForeground(Color.black);
        myOptionButton1.setBounds(xLeftButtons, yTopButtons, buttonWidth, buttonHeight);
        myOptionButton1.setEnabled(true);

        myOptionButton2.setBackground(Color.white);
        myOptionButton2.setForeground(Color.black);
        myOptionButton2.setBounds(xLeftButtons, yButtonButtons, buttonWidth, buttonHeight);
        myOptionButton2.setEnabled(true);

        myOptionButton3.setBackground(Color.white);
        myOptionButton3.setForeground(Color.black);
        myOptionButton3.setBounds(xRightButtons, yTopButtons, buttonWidth, buttonHeight);
        myOptionButton3.setEnabled(true);

        myOptionButton4.setBackground(Color.white);
        myOptionButton4.setForeground(Color.black);
        myOptionButton4.setBounds(xRightButtons, yButtonButtons, buttonWidth, buttonHeight);
        myOptionButton4.setEnabled(true);
    }

    /**
     * Get myOptionButton4.
     * @return JButton
     */
    public JRadioButton getMyOptionButton4() {
        return myOptionButton4;
    }

    /**
     * Get myOptionButton3.
     * @return JButton
     */
    public JRadioButton getMyOptionButton3() {
        return myOptionButton3;
    }

    /**
     * Get myOptionButton2.
     * @return JButton
     */
    public JRadioButton getMyOptionButton2() {
        return myOptionButton2;
    }

    /**
     * Get myOptionButton1.
     * @return JButton
     */
    public JRadioButton getMyOptionButton1() {
        return myOptionButton1;
    }

    /**
     * Get myEnterButton.
     * @return JButton
     */
    public JButton getMyEnterButton() {
        return myEnterButton;
    }
}
