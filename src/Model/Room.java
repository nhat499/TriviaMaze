package Model;

import java.io.Serializable;

/**
 * @author Nhat & Dylan
 * @version 2.0 - 11/19/2021
 * This class creates the room objects and each room
 * hold 4 doors. The Room also will specify if it is an exit room
 */
public class Room implements Serializable {

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