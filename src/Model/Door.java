package Model;

/**
 * @author Andrew
 * @version 1.0
 * This class creates the door objects and has boolean values for whether the
 * door is closed or open.
 */
public class Door {

    /**
     * Boolean that opens the doors.
     */
    public boolean myOpenStatus = true;

    /**
     * Boolean that closes the doors
     */
     public boolean myLockedStatus = false;

    /**
     * Constructor that lets us create the door objects.
     */
    public Door() {

    }

    /**
     * Parameterized Constructor that lets us create the door objects.
     */
    public Door(final boolean theOpenStatus, final boolean theLockedStatus) {
        myLockedStatus = theLockedStatus;
        myOpenStatus = theOpenStatus;
    }

    /**
     * Getter for myOpenStatus.
     * @return myOpenStatus
     */
    public boolean isMyOpenStatus() {
        return myOpenStatus;
    }

    /**
     * Setter for myOpenStatus.
     * @param theOpenStatus
     */
    public void setMyOpenStatus(boolean theOpenStatus) {
        this.myOpenStatus = theOpenStatus;
    }

    /**
     * Getter for myLockedStatus.
     * @return myLockedStatus
     */
    public boolean isMyLockedStatus() {
        return myLockedStatus;
    }

    /**
     * Setter for myLockedStatus
     * @param theLockedStatus
     */
    public void setMyLockedStatus(boolean theLockedStatus) {
        this.myLockedStatus = theLockedStatus;
    }

}
