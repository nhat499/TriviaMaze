package Model;

import java.io.Serializable;

/**
 * @author Andrew and Dylan
 * @version 1.0 - 11/19/2021
 * The main function of the player class is keep tracker of the user's location
 * and movement throughout their traversal of the TriviaMaze.
 */
public class Player implements Serializable {

    /**
     * The position the player is at according to the doors.
     */
    private final Maze myMaze;

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
        if(myY + 1 < myMaze.getMyWidth() - 1) {
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
        if (myX + 1 < myMaze.getMyHeight() - 1) {
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