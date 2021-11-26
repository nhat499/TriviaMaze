package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * TODO!!!
 */
public class MovementPanel extends JPanel {


    private final JButton myMoveWestButton;
    private final JButton myMoveNorthButton;
    private final JButton myMoveEastButton;
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

//        final Shape circle = new Ellipse2D.Double(3.0, 5.1, 3.0, 5.1);
//        g.setPaint(Color.blue);
//        g.setStroke(new BasicStroke(2));
//        g.draw(circle);
//        g.fill(circle);

    }

    public JButton getMyMoveSouthButton() {
        return myMoveSouthButton;
    }

    public JButton getMyMoveEastButton() {
        return myMoveEastButton;
    }

    public JButton getMyMoveNorthButton() {
        return myMoveNorthButton;
    }

    public JButton getMyMoveWestButton() {
        return myMoveWestButton;
    }
}
