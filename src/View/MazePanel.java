package View;

import Controller.GameplayController;
import Model.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * TODO!!!
 */
public class MazePanel extends JPanel {


    /** The width of the panel. */
    private static final int WIDTH = 300;

    /** The height of the panel. */
    private static final int HEIGHT = 300;

    /** The stroke width in pixels. */
    private static final int STROKE_WIDTH = 5;

    /** The width for the rectangle. */
    private static final int RECTANGLE_WIDTH = 640;

    /** The height for the rectangle. */
    private static final int RECTANGLE_HEIGHT = 640;

    /**
     * TODO!!!
     */
    private final Maze myMaze;

    /**
     * TODO!!!
     */
    private final GameplayController myController;

    /**
     * Public constructor for MazePanel.
     */
    public MazePanel() {
        super();
        this.setSize(640, 640);
        this.setLocation(10, 10);
        setBackground(Color.white);
        myController = GameplayController.getUniqueInstance();
        myMaze = myController.getMyMaze();
    }

    /**
     * TODO!!!
     * @param theGraphics
     */
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        final Rectangle border = new Rectangle(2, 3, 635, 635);
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH));
        g2d.draw(border);

        g2d.setStroke(new BasicStroke(3));
        Line2D horizontalWall;
        Line2D verticalWall;
        Line2D horizontalDoor;
        Line2D verticalDoor;

        myMaze.getRoom(1,1).getMyEastDoor().setMyOpenStatus(true);
        myMaze.getRoom(2,1).getMyEastDoor().setMyOpenStatus(true);
        myMaze.getRoom(2,2).getMyNorthDoor().setMyLockedStatus(true);
        myMaze.getRoom(3,1).getMySouthDoor().setMyOpenStatus(true);
        myMaze.getRoom(3,2).getMySouthDoor().setMyOpenStatus(true);
        myMaze.getRoom(3,3).getMyWestDoor().setMyLockedStatus(true);
        myMaze.getRoom(3,3).getMyEastDoor().setMyLockedStatus(true);





        for (int i = 1; i <= 5; i++) {
            horizontalWall = new Line2D.Double(128 * i, 4, 128 * i, 635);
            g2d.draw(horizontalWall);
            verticalWall = new Line2D.Double(2, 128 * i, 635, 128 * i);
            g2d.draw(verticalWall);
        }

        g2d.setStroke(new BasicStroke(10));
        for (int i = 1; i < myMaze.getMyWidth()-2; i++) {
            for (int j = 1; j < myMaze.getMyWidth()-1; j++) {
                verticalDoor = new Line2D.Double(127 * i + i, 30 + (128 * (j - 1)), 127 * i + i, 100 + (128 * (j - 1)));
                if (!myMaze.getRoom(i, j).getMyEastDoor().getMyOpenStatus()) {
                    g2d.setPaint(Color.black);
                } else if (myMaze.getRoom(i, j).getMyEastDoor().getMyOpenStatus()) {
                    g2d.setPaint(Color.white);
                }
                if(myMaze.getRoom(i, j).getMyEastDoor().getMyLockedStatus()) {
                    g2d.setPaint(Color.red);
                }
                g2d.draw(verticalDoor);
            }
        }
        for (int i = 1; i < myMaze.getMyWidth() - 2; i++) {
            for (int j = 1; j < myMaze.getMyWidth() - 1; j++) {
                horizontalDoor = new Line2D.Double(30 + (128 * (j - 1)), 128 * i, 100 + (128 * (j - 1)), 128 * i);
                if (!myMaze.getRoom(j, i).getMySouthDoor().getMyOpenStatus()) {
                    g2d.setPaint(Color.black);
                } else if (myMaze.getRoom(j, i).getMySouthDoor().getMyOpenStatus()) {
                    g2d.setPaint(Color.white);
                }
                if (myMaze.getRoom(j, i).getMySouthDoor().getMyLockedStatus()) {
                    g2d.setPaint(Color.red);
                }
                g2d.draw(horizontalDoor);
            }
        }
    }
}
