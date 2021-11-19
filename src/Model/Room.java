package Model;

/**
 * @author Nhat & Dylan
 * @version 2.0
 * This class creates the room objects and each room
 * hold 4 doors. The Room also will specify if it is an exit room
 */
public class Room {
    private Door myNorthDoor;
    private Door mySouthDoor;
    private Door myWestDoor;
    private Door myEastDoor;
    private boolean isVisited;
    private boolean myExit;

    public Room() {
    }

    /**
     * get checked to see if they room is
     * visited
     * @return boolean true if the room has been visited
     */
    public boolean getVisited() {
        return isVisited;
    }

    /**
     * setter for if the room is visited
     */
    public void setVisited(boolean theVisited) {
        isVisited = theVisited;
    }

    /**
     * setter for the exit room
     * @param theExit if the room is an exit or not
     */
    public void setExit(final boolean theExit) {
        myExit = theExit;
    }

    /**
     * getter for myExit
     * @return if the room is an exit room
     */
    public boolean isExit() {
        return myExit;
    }

    /**
     * get the east door
     * @return the east door
     */
    public Door getMyEastDoor() {
        return myEastDoor;
    }
    /**
     * get the north door
     * @return the north door
     */
    public Door getMyNorthDoor() {
        return myNorthDoor;
    }
    /**
     * get the south door
     * @return the south door
     */
    public Door getMySouthDoor() {
        return mySouthDoor;
    }
    /**
     * get the west door
     * @return the west door
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