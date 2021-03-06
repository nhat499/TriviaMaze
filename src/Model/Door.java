package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Andrew & Dylan & Nhat
 * @version 2.0 - 11/19/2021
 * Door class used as pathways between Room objects. Each Door object
 * contains unique question information. Doors can be either open,
 * closed, or locked.
 */
public class Door implements Serializable {

    /**
     * Indicates whether this door is open or closed.
     */
    private boolean myOpenStatus;

    /**
     * Indicates whether this door is locked or unlocked.
     */
    private boolean myLockedStatus;

    /**
     * Correct answer for the question associated with this door.
     */
    private final String myCorrectAnswer;

    /**
     * Collection of correct and incorrect answers for the question
     * associated with this door.
     */
    private ArrayList<String> myAnswers;

    /**
     * Parameterless constructor, creates locked door.
     */
    public Door() {
        myOpenStatus = false;
        myLockedStatus = true;
        myCorrectAnswer = null;
    }

    /**
     * Parameterized Constructor for Door.
     */
    public Door(final String theCorrectAnswer, final String theWrongAnswer1,
                final String theWrongAnswer2, final String theWrongAnswer3) {
        myLockedStatus = false;
        myOpenStatus = false;
        myCorrectAnswer = theCorrectAnswer;
        myAnswers = new ArrayList<>();
        myAnswers.add(theCorrectAnswer);
        myAnswers.add(theWrongAnswer1);
        myAnswers.add(theWrongAnswer2);
        myAnswers.add(theWrongAnswer3);
    }

    /**
     * To be called when the player attempts to pass through a closed doorway. If the player
     * provides the correct answer to the question, the door is opened and remains
     * unlocked. If the player answers the question incorrectly, the door remains closed
     * and becomes locked and unpassable for the remainder of the game.
     * @param thePlayersAnswer
     */
    public void attemptToOpen(final String thePlayersAnswer) {
        if (thePlayersAnswer.equals(myCorrectAnswer)) {
            myOpenStatus = true;
        } else if (!thePlayersAnswer.equals(myCorrectAnswer) && !myOpenStatus){
            myLockedStatus = true;
        }
    }

    /**
     * Produces an ArrayList of the possible answers to the question associated
     * with this door. The ArrayList is shuffled, meaning that while it includes
     * the correct answer and all the possible wrong answers, they will appear
     * in random order.
     * @return ArrayList of all answers to the question associated with this door.
     */
    public ArrayList<String> getMyAnswers() {
        Collections.shuffle(myAnswers);
        return myAnswers;
    }

    /**
     * Getter for myOpenStatus.
     * @return myOpenStatus
     */
    public boolean getMyOpenStatus() {
        return myOpenStatus;
    }

    /**
     * Getter for myLockedStatus.
     * @return myLockedStatus
     */
    public boolean getMyLockedStatus() {
        return myLockedStatus;
    }

    /**
     * Getter for myCorrectAnswer.
     * @return String
     */
    public String getMyCorrectAnswer() { return myCorrectAnswer; }

    /**
     * Setter for lockStatus.
     */
    public void setMyLockedStatus(boolean theLockStatus) {
        myLockedStatus = theLockStatus;
    }
}