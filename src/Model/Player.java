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
    private int myX;

    /**
     * The Y-coordinate of the player.
     */
    private int myY;

    /**
     * The position of the player.
     */
//    private Room myPosition = myMaze.getRoom(myX, myY);

    /**
     * Parameterless constructor.
     */
    public Player () {

    }

    /**
     * Parameterized constructor that sets the players position.
     * @param theX, theY
     */
    public Player(final int theX, final int theY, final Maze theMaze) {
        myX = theX;
        myY = theY;
        myMaze = theMaze;
    }

    /**
     * Method that moves the player north.
     */
    public void moveNorth() {
        if (myY - 1 > 0) {
            myY = myY - 1;
        }

    }

    public int getMyX() {
        return myX;
    }

    public int getMyY() {
        return myY;
    }


    /**
     * Method that moves the player south.
     */
    public void moveSouth() {
        if(myY + 1 < myMaze.getMyWidth()) {
            myY = myY + 1;
        }

    }

    /**
     * Method that moves the player west.
     */
    public void moveWest() {
        if (myX - 1 > 0) {
            myX = myX - 1;
        }
      ;
    }

    /**
     * Method that moves the player east.
     */
    public void moveEast() {
        if (myX + 1 < myMaze.getMyHeight()) {
            myX = myX + 1;
        }

    }

    /**
     * A method that updates the room once the position is changed.
     */
//    private void updateRoom() {
//        myPosition = myMaze.getRoom(myX, myY);
//    }
}