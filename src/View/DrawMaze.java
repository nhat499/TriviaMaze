package View;

import javax.swing.*;
import java.awt.*;

public class DrawMaze extends JPanel {
    /** The width of the panel. */
    private static final int WIDTH = 800;

    /** The height of the panel. */
    private static final int HEIGHT = 800;

    /** The stroke width in pixels. */
    private static final int STROKE_WIDTH = 10;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 150;

    /** The height for the rectangle. */
    private static final int RECTANGLE_HEIGHT = 150;

    public DrawMaze() {
        super();
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        final Rectangle mazeBorder = new Rectangle((getWidth() / 4), (getHeight()/4),
                RECTANGLE_WIDTH * 2, RECTANGLE_HEIGHT * 2);
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH));
        g2d.draw(mazeBorder);

    }
    public static void main(final String... theArgs) {
        final DrawMaze panel = new DrawMaze();
        final JFrame frame = new JFrame("DrawMaze Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
}
