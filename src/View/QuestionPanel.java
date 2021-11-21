package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;

/**
 * TODO!!!
 */
public class QuestionPanel extends JPanel {

    GameplayController myC;

    /**
     * Public constructor for QuestionPanel.
     */
    public QuestionPanel() {
        this.setLayout(null);
        setSize(450, 100);
        setLocation(660, 370);
        setBackground(Color.white);
        myC = GameplayController.getUniqueInstance();
        this.add(myC.getMyEnterButton());
        this.add(myC.getMyOptionButton1());
        this.add(myC.getMyOptionButton2());
        this.add(myC.getMyOptionButton3());
        this.add(myC.getMyOptionButton4());

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
}
