package View;

import Controller.GameplayController;

import javax.swing.*;
import java.awt.*;

/**
 * TODO!!!
 */
public class ImagePanel extends JPanel {

    /**
     * TODO!!!
     */
    private static ImagePanel myUniqueInstance;

    /**
     * TODO!!!
     */
    private final GameplayController myController;

    private Image myImage;


    /**
     * Public constructor for ImagePanel.
     */
    public ImagePanel() {
        myController = GameplayController.getUniqueInstance();
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

//        if (myImage != null) {
//            g.drawImage(myImage, 0, 0, null);
//        }
    }

    /**
     * TODO!!!
     */
    public void setMyImage(final String theFilePath){
        myImage = new ImageIcon(theFilePath).getImage();
    }

}
