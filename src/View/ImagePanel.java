package View;

import Controller.GameplayController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * TODO!!!
 */
public class ImagePanel extends JPanel {





    private ImageIcon myIcon;
    private Image myImage;


    /**
     * Public constructor for ImagePanel.
     */
    public ImagePanel() {
        this.setLayout(null);
        setSize(450, 350);
        setLocation(660, 10);
        setBackground(Color.white);

    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g = (Graphics2D) theGraphics;

        final Rectangle border  = new Rectangle(2, 3, 445, 343);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        g.draw(border);
        if (myIcon != null) {
            myIcon.paintIcon(this, g, 70, 20);
        }
    }

    /**
     * TODO!!!
     */
    public void updateMyImage(final String theFilePath){

        try {
            BufferedImage buff = ImageIO.read(new File(theFilePath));
            myImage = buff.getScaledInstance(300, 300, 0);
            myIcon = new ImageIcon(myImage);
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
