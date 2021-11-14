package Model;

/**
 * @author Andrew and Dylan
 * @version 1.0
 * This is the player class which dictates the position of a player object
 * and gives the player the ability to move to different rooms based on their current position.
 */
public class Player {

    /**
     * The position the player is at according to the doors.
     */
    private Maze myMaze;

    /**
     * The X-coordinate of the player.
     */
    private int xCoord;

    /**
     * The Y-coordinate of the player.
     */
    private int yCoord;

    /**
     * The position of the player.
     */
    private Room myPosition = myMaze.getRoom(xCoord, yCoord);

    /**
     * Parameterless constructor.
     */
    public Player () {

    }

    /**
     * Parameterized constructor that sets the players position.
     * @param thePosition
     */
    public Player(final Room thePosition) {
        myPosition = thePosition;
    }

    /**
     * Method that moves the player north.
     * @param theMaze
     */
    private void moveNorth(Maze theMaze) {
        if (yCoord - 1 > 0) {
            yCoord = yCoord - 1;
        }
        updateRoom();
    }

    /**
     * Method that moves the player south.
     * @param theMaze
     */
    private void moveSouth(Maze theMaze) {
        if(yCoord + 1 < myMaze.getMyWidth()) {
            yCoord = yCoord + 1;
        }
        updateRoom();
    }

    /**
     * Method that moves the player west.
     * @param theMaze
     */
    private void moveWest(Maze theMaze) {
        if (xCoord - 1 > 0) {
            xCoord = xCoord - 1;
        }
        updateRoom();
    }

    /**
     * Method that moves the player east.
     * @param theMaze
     */
    private void moveEast(Maze theMaze) {
        if (xCoord + 1 < myMaze.getMyLength()) {
            xCoord = xCoord + 1;
        }
        updateRoom();
    }

    private void updateRoom() {
        myPosition = myMaze.getRoom(xCoord, yCoord);
    }
}
