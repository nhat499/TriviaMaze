package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Andrew & Dylan
 * @version 2.0
 * This class creates the door objects and has boolean values
 * for whether the door is closed or open.
 */
public class Door {

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
     * The file path to the Pokemon image associated with the question
     * of this door.
     */
    private final String myImgFilePath;

    /**
     * Parameterized Constructor that lets us create the door objects.
     */
    public Door(final String theCorrectAnswer, final String theWrongAnswer1,
                final String theWrongAnswer2, final String theWrongAnswer3,
                final String theImgFilePath) {
        myLockedStatus = false;
        myOpenStatus = false;
        myCorrectAnswer = theCorrectAnswer;
        myAnswers.add(theCorrectAnswer);
        myAnswers.add(theWrongAnswer1);
        myAnswers.add(theWrongAnswer2);
        myAnswers.add(theWrongAnswer3);
        myImgFilePath = theImgFilePath;
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
        } else {
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
}
