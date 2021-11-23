package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;

/**
 * TODO!!!
 */
public class QuestionPanel extends JPanel {

    //TODO!!! Javadocs
    private final JRadioButton myOptionButton1;
    private final JRadioButton myOptionButton2;
    private final JRadioButton myOptionButton3;
    private final JRadioButton myOptionButton4;
    private final JButton myEnterButton;


    /**
     * Public constructor for QuestionPanel.
     */
    public QuestionPanel() {
        this.setLayout(null);
        setSize(450, 100);
        setLocation(660, 370);
        setBackground(Color.white);
        myOptionButton1 = new JRadioButton("Place Holder");
        myOptionButton2 = new JRadioButton("Place Holder");
        myOptionButton3 = new JRadioButton("Place Holder");
        myOptionButton4 = new JRadioButton("Place Holder");
        myEnterButton = new JButton("Enter!");
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


    public JRadioButton getMyOptionButton4() {
        return myOptionButton4;
    }

    public JRadioButton getMyOptionButton3() {
        return myOptionButton3;
    }

    public JRadioButton getMyOptionButton2() {
        return myOptionButton2;
    }

    public JRadioButton getMyOptionButton1() {
        return myOptionButton1;
    }

    public JButton getMyEnterButton() {
        return myEnterButton;
    }
}
