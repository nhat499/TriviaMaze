package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;

/**
 * TODO!!!
 */
public class OptionsPanel extends JPanel {

    GameplayController myC;

    /**
     * Public constructor for OptionsPanel.
     */
    public OptionsPanel() {
        this.setLayout(null);
        setSize(190, 170);
        setLocation(920, 480);
        setBackground(Color.white);
        myC = GameplayController.getUniqueInstance();
        this.add(myC.getResetButton());
        this.add(myC.getLoadButton());
        this.add(myC.getMyHelpButton());

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
}
