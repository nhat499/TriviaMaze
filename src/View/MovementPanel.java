package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;

/**
 * TODO!!!
 */
public class MovementPanel extends JPanel {

    GameplayController myC;

    /**
     * Public constructor for MovementPanel.
     */
    public MovementPanel() {
        myC = GameplayController.getUniqueInstance();
        this.setLayout(null);
        setSize(250, 170);
        setLocation(660, 480);
        setBackground(Color.white);
        this.add(myC.getMyMoveWestButton());
        this.add(myC.getMyMoveNorthButton());
        this.add(myC.getMyMoveEastButton());
        this.add(myC.getMyMoveSouthButton());


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
}
