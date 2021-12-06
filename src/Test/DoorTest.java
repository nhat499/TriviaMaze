package Test;

import Model.Door;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for Door class.
 * @author Dylan
 * @version 12/5/2021
 */
public class DoorTest {

    Door myDoor;
    Door myDoor2;

    @BeforeEach
    void setup() {
        myDoor = new Door();
        myDoor2 = new Door("charizard", "blastoise",
                "meowth", "gengar");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ParameterlessConstructorTest(){
        assertNotNull(myDoor, "myDoor is Null!");
    }

    @Test
    void ParameterizedConstructorTest(){
        assertNotNull(myDoor, "myDoor2 is Null!");
    }

    @Test
    void ClosedDoorTest() {
        assertFalse(myDoor.getMyOpenStatus(), "Door - myOpenStatus is true!");
        assertFalse(myDoor2.getMyOpenStatus(), " Door2 - myOpenStatus is true!");
    }

    @Test
    void OpeningTheDoorTest() {
        myDoor2.attemptToOpen("charizard");
        assertTrue(myDoor2.getMyOpenStatus());
    }

    @Test
    void LockedDoorTest() {
        assertTrue(myDoor.getMyLockedStatus(), "Door - myLockedStatus is false!");
        assertFalse(myDoor2.getMyLockedStatus(), "Door2 - myLockedStatus is true!");
    }

    @Test
    void LockingTheDoorTest() {
        myDoor2.attemptToOpen("");
        assertTrue(myDoor2.getMyLockedStatus());
    }

    @Test
    void CorrectAnswerTest() {
        assertEquals(myDoor2.getMyCorrectAnswer(), "charizard", "Door2 - myCorrectAnswer is wrong!");
        assertNull(myDoor.getMyCorrectAnswer(), "Door - myCorrectAnswer is not null!");
    }

    @Test
    void AllAnswersTest() {
        ArrayList<String> s = myDoor2.getMyAnswers();
        assertTrue(s.contains("blastoise"));
        assertTrue(s.contains("meowth"));
        assertTrue(s.contains("gengar"));
        assertTrue(s.contains("charizard"));
    }
}
