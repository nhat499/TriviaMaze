package Model;

/**
 * @author Andrew and Dylan
<<<<<<< HEAD
 * @version 1.0
 * This is the player class which dictates the position of a player object
 * and gives the player the ability to move to different rooms based on their current position.
=======
 * @version 1.0 - 11/19/2021
 * The main function of the player class is keep tracker of the user's location
 * and movement throughout their traversal of the TriviaMaze.
>>>>>>> workshop
 */
public class Player {

    /**
     * The position the player is at according to the doors.
     */
    private Maze myMaze;

    /**
     * The X-coordinate of the player.
     */
    private int myX;

    /**
     * The Y-coordinate of the player.
     */
    private int myY;

    /**
     * The position of the player.
     */
<<<<<<< HEAD
    private Room myPosition = myMaze.getRoom(myX, myY);

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
     */
    private void moveNorth() {
        if (myY - 1 > 0) {
            myY = myY - 1;
        }
        updateRoom();
    }

    /**
     * Method that moves the player south.
     */
    private void moveSouth() {
        if(myY + 1 < myMaze.getMyWidth()) {
            myY = myY + 1;
        }
        updateRoom();
    }

    /**
     * Method that moves the player west.
     */
    private void moveWest() {
        if (myX - 1 > 0) {
            myX = myX - 1;
        }
        updateRoom();
    }

    /**
     * Method that moves the player east.
     */
    private void moveEast() {
        if (myX + 1 < myMaze.getMyHeight()) {
            myX = myX + 1;
        }
        updateRoom();
    }

    /**
     * A method that updates the room once the position is changed.
     */
    private void updateRoom() {
        myPosition = myMaze.getRoom(myX, myY);
    }
}
=======

    /**
     * Parameterized constructor for Player. Sets the players position
     * in the maze.
     * @param - theX, theY
     */
    public Player(final int theX, final int theY, final Maze theMaze) {
        myX = theX;
        myY = theY;
        myMaze = theMaze;
    }

    /**
     * Move the position of the player one index north, if possible.
     */
    public void moveNorth() {
        if (myY - 1 > 0) {
            myY = myY - 1;
        }
    }

    /**
     * Move the position of the player one index south, if possible.
     */
    public void moveSouth() {
        if(myY + 1 < myMaze.getMyWidth()) {
            myY = myY + 1;
        }
    }

    /**
     * Move the position of the player one index west, if possible.
     */
    public void moveWest() {
        if (myX - 1 > 0) {
            myX = myX - 1;
        }
    }

    /**
     * Move the position of the player one index east, if possible.
     */
    public void moveEast() {
        if (myX + 1 < myMaze.getMyHeight()) {
            myX = myX + 1;
        }
    }

    /**
     * Getter for myX.
     * @return
     */
    public int getMyX() {
        return myX;
    }

    /**
     * Getter for myY.
     * @return
     */
    public int getMyY() {
        return myY;
    }
}
>>>>>>> workshop
