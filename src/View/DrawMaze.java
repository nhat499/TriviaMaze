package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DrawMaze extends JPanel {
    /** The width of the panel. */
    private static final int WIDTH = 800;

    /** The height of the panel. */
    private static final int HEIGHT = 800;

    /** The stroke width in pixels. */
    private static final int STROKE_WIDTH = 10;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 156;

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

        final Line2D verticleline = new Line2D.Double(262, 500, 262, 200);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(verticleline);

        final Line2D verticleline2 = new Line2D.Double(325, 500, 325, 200);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(verticleline2);

        final Line2D verticleline3 = new Line2D.Double(390, 500, 390, 200);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(verticleline3);

        final Line2D verticleline4 = new Line2D.Double(450, 500, 450, 200);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(verticleline4);

        final Line2D horizontalline = new Line2D.Double(200, 260, 510, 260);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(horizontalline);

        final Line2D horizontalline2 = new Line2D.Double(200, 320, 510, 320);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(horizontalline2);

        final Line2D horizontalline3 = new Line2D.Double(200, 380, 510, 380);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(horizontalline3);

        final Line2D horizontalline4 = new Line2D.Double(200, 440, 510, 440);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH/5));
        g2d.draw(horizontalline4);

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
