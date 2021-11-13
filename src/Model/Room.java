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
    public Room(Door theNorthDoor, Door theEastDoor, Door theSouthDoor, Door theWestDoor) {
        myNorthDoor = theNorthDoor;
        myEastDoor = theEastDoor;
        mySouthDoor = theSouthDoor;
        myWestDoor = theWestDoor;
    };

    /**
     * setter for the exit room
     * @param theExit if the room is an exit or not
     */
    public void setExit(boolean theExit) {
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
     * set the east door
     * @param theEastDoor the door to be the east door
     */
    public void setMyEastDoor(Door theEastDoor) {
        myEastDoor = theEastDoor;
    }
    /**
     * set the north door
     * @param theNorthDoor the door to be the north door
     */
    public void setMyNorthDoor(Door theNorthDoor) {
        myNorthDoor = theNorthDoor;
    }
    /**
     * set the south door
     * @param theSouthDoor the door to be the south door
     */
    public void setMySouthDoor(Door theSouthDoor) {
        mySouthDoor = theSouthDoor;
    }
    /**
     * set the west door
     * @param theWestDoor the door to be the west door
     */
    public void setMyWestDoor(Door theWestDoor) {
        myWestDoor = theWestDoor;
    }
}
