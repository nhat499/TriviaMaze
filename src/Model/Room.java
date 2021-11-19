package Model;

/**
 * @author Nhat & Dylan
 * @version 2.0 - 11/19/2021
 * This class creates the room objects and each room
 * hold 4 doors. The Room also will specify if it is an exit room
 */
public class Room {

    /**
     * Reference to Room's northern door.
     */
    private Door myNorthDoor;

    /**
     * Reference to Room's southern door.
     */
    private Door mySouthDoor;

    /**
     * Reference to Room's western door.
     */
    private Door myWestDoor;

    /**
     * Reference to Room's eastern door.
     */
    private Door myEastDoor;

    /**
     * Used for determining if an exit route from the maze exists.
     */
    private boolean myVisitedStatus;

    /**
     * Dictates whether this room is the exit from the maze or not.
     */
    private boolean myExitStatus;

    /**
     * Getter for myVisitedStatus.
     * @return - boolean true if the room has been visited by the
     * escapable method, used to determine if an exit path exists.
     */
    public boolean getVisitedStatus() {
        return myVisitedStatus;
    }

    /**
     * Setter for myVisitedStatus. Used by the escapable method to mark this
     * room as visited.
     */
    public void setVisited(boolean theVisited) {
        myVisitedStatus = theVisited;
    }

    /**
     * Setter for myExitStatus.
     * @param theExit if the room is an exit or not.
     */
    public void setExit(final boolean theExit) {
        myExitStatus = theExit;
    }

    /**
     * Getter for myExitStatus.
     * @return if the room is an exit from the maze or not.
     */
    public boolean isExit() {
        return myExitStatus;
    }

    /**
     * Getter for myEastDoor.
     * @return East Door
     */
    public Door getMyEastDoor() {
        return myEastDoor;
    }

    /**
     * Getter for myNorthDoor.
     * @return North Door
     */
    public Door getMyNorthDoor() {
        return myNorthDoor;
    }

    /**
     * Getter for mySouthDoor.
     * @return South Door
     */
    public Door getMySouthDoor() {
        return mySouthDoor;
    }

    /**
     * Getter for myWestDoor.
     * @return West Door
     */
    public Door getMyWestDoor() {
        return myWestDoor;
    }

    /**
     * Setter for myEastDoor.
     * @param theDoor the door to be assigned to myEastDoor.
     */
    public void setMyEastDoor(final Door theDoor) {
        myEastDoor = theDoor;
    }

    /**
     * Setter for myNorthDoor.
     * @param theDoor the door to be assigned to myNorthDoor.
     */
    public void setMyNorthDoor(final Door theDoor) {
        myNorthDoor = theDoor;
    }

    /**
     * Setter for myWestDoor.
     * @param theDoor the door to be assigned to myWestDoor.
     */
    public void setMyWestDoor(final Door theDoor) {
        myWestDoor = theDoor;
    }

    /**
     * Setter for mySouthDoor.
     * @param theDoor the door to be assigned to mySouthDoor.
     */
    public void setMySouthDoor(final Door theDoor) {
        mySouthDoor = theDoor;
    }
}