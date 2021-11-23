package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;

/**
 * TODO!!!
 */
public class OptionsPanel extends JPanel {



    //TODO!!! Javadocs
    private final JButton myResetButton;
    private final JButton myHelpButton;
    private final JButton myLoadButton;


    /**
     * Public constructor for OptionsPanel.
     */
    public OptionsPanel() {
        this.setLayout(null);
        setSize(190, 170);
        setLocation(920, 480);
        setBackground(Color.white);
        myResetButton = new JButton("Reset");
        myHelpButton = new JButton("Help");
        myLoadButton = new JButton("Load");
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

    public JButton getMyLoadButton() {
        return myLoadButton;
    }

    public JButton getMyHelpButton() {
        return myHelpButton;
    }

    public JButton getMyResetButton() {
        return myResetButton;
    }
}
