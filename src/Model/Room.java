package Model;

/**
 * @author Nhat
 * @version 1.0
 * This class creates the room objects and each room
 * hold 4 doors. The Room also will specify if it is an exit room
 */
public class Room {
    private Door myNorthDoor;
    private Door mySouthDoor;
    private Door myWestDoor;
    private Door myEastDoor;
    private boolean myExit;

    // constructor of the room class
    public Room(final Door theNorthDoor, final Door theEastDoor,
                final Door theSouthDoor, final Door theWestDoor) {
        myNorthDoor = theNorthDoor;
        myEastDoor = theEastDoor;
        mySouthDoor = theSouthDoor;
        myWestDoor = theWestDoor;
    };

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
}
