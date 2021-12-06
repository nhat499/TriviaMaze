package Test;

import Model.Door;
import Model.Room;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit test class for Room class.
 * @author Dylan
 * @version 12/5/2021
 */
public class RoomTest {
    Room myRoom;


    @BeforeEach
    void setup() {
        myRoom = new Room();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ConstructorTest() {
        assertNotNull(myRoom, "myRoom is Null1");
    }

    @Test
    void EastDoorSetGetTest() {
        Door d = new Door();
        myRoom.setMyEastDoor(d);
        assertEquals(d, myRoom.getMyEastDoor());
    }

    @Test
    void NorthDoorSetGetTest() {
        Door d = new Door();
        myRoom.setMyNorthDoor(d);
        assertEquals(d, myRoom.getMyNorthDoor());
    }

    @Test
    void WestDoorSetGetTest() {
        Door d = new Door();
        myRoom.setMyWestDoor(d);
        assertEquals(d, myRoom.getMyWestDoor());
    }

    @Test
    void SouthDoorSetGetTest() {
        Door d = new Door();
        myRoom.setMySouthDoor(d);
        assertEquals(d, myRoom.getMySouthDoor());
    }
}
