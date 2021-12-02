package View;

import Controller.GameplayController;
import Model.Maze;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * MazePanel class. Produces a visualization of the maze and the player while they traverse it.
 * @author Dylan
 * @version 12/2/2021
 */
public class MazePanel extends JPanel {

    /**
     * The height & width of the panel in pixels.
     * */
    private static final int MAZE_SIZE = 640;

    /**
     * Distance that the painting on the panel is inset from the border in pixels.
     */
    private static final int PANEL_INSET = 10;

    /**
     * Reference to the main Maze instance.
     */
    private Maze myMaze;

    /**
     * Reference to the main Player instance.
     */
    private Player myPlayer;

    /**
     * Public constructor for MazePanel.
     */
    public MazePanel(final Maze theMaze, final Player thePlayer) {
        super();
        myMaze = theMaze;
        myPlayer = thePlayer;
        this.setSize(MAZE_SIZE, MAZE_SIZE);
        this.setLocation(PANEL_INSET, PANEL_INSET);
        setBackground(Color.white);
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        final int borderInset = 2;
        final int borderSize = 635;
        final int borderStrokeWidth = 5;
        final int wallStrokeWidth = 3;
        final int doorStrokeWidth = 10;
        final int spaceBetweenHorDoors = 128;
        final int spaceBetweenVerDoors = 127;
        final int upperDoorBound = 30;
        final int lowerDoorBound = 100;
        final int playerPieceSize = 50;
        final int playerBaseLocation = 40;
        Line2D horizontalWall;
        Line2D verticalWall;
        Line2D horizontalDoor;
        Line2D verticalDoor;

        final Rectangle border = new Rectangle(borderInset, borderInset, borderSize, borderSize);
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(borderStrokeWidth));
        g2d.draw(border);

        g2d.setStroke(new BasicStroke(wallStrokeWidth));
        for (int i = 1; i <= 5; i++) {
            horizontalWall = new Line2D.Double(spaceBetweenHorDoors * i, 4,
                    spaceBetweenHorDoors * i, borderSize);
            g2d.draw(horizontalWall);
            verticalWall = new Line2D.Double(borderInset, spaceBetweenHorDoors * i,
                    borderSize, spaceBetweenHorDoors * i);
            g2d.draw(verticalWall);
        }

        g2d.setStroke(new BasicStroke(doorStrokeWidth));
        for (int i = 1; i < myMaze.getMyWidth() - 2; i++) {
            for (int j = 1; j < myMaze.getMyWidth() - 1; j++) {
                verticalDoor = new Line2D.Double(spaceBetweenVerDoors * i + i,
                        upperDoorBound + (spaceBetweenHorDoors * (j - 1)), spaceBetweenVerDoors * i + i,
                        lowerDoorBound + (spaceBetweenHorDoors * (j - 1)));
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
                horizontalDoor = new Line2D.Double(upperDoorBound + (spaceBetweenHorDoors * (j - 1)),
                        spaceBetweenHorDoors * i, lowerDoorBound + (spaceBetweenHorDoors * (j - 1)), spaceBetweenHorDoors * i);
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

        g2d.setColor(Color.MAGENTA);
        g2d.drawOval(playerBaseLocation + ((myPlayer.getMyX() - 1) * spaceBetweenHorDoors) , playerBaseLocation + ((myPlayer.getMyY() - 1) * spaceBetweenVerDoors),
                playerPieceSize, playerPieceSize);
    }
}
