package Test;

import Model.Door;
import Model.Maze;
import Model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * JUnit test class for Player class.
 * @author Dylan
 * @version 12/5/2021
 */
public class PlayerTest {
    Player myPlayer;


    @BeforeEach
    void setup() {
        myPlayer = new Player(3, 4, new Maze(5, 5));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ConstructorTest() {
        assertNotNull(myPlayer, "myPlayer is Null!");
    }

    @Test
    void GetMyXTest() {
        assertEquals(myPlayer.getMyX(), 3, "X Coordinate stored incorrectly!");
    }

    @Test
    void GetMyYTest() {
        assertEquals(myPlayer.getMyY(), 4, "Y Coordinate stored incorrectly!");
    }

    @Test
    void MoveWestTest() {
        myPlayer.moveWest();
        assertEquals(myPlayer.getMyX(), 2, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 4, "Move west failed!");
        myPlayer.moveWest();
        myPlayer.moveWest();
        assertEquals(myPlayer.getMyX(), 1, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 4, "Move west failed!");
    }

    @Test
    void MoveNorthTest() {
        myPlayer.moveNorth();
        assertEquals(myPlayer.getMyX(), 3, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 3, "Move west failed!");
        myPlayer.moveNorth();
        myPlayer.moveNorth();
        myPlayer.moveNorth();
        assertEquals(myPlayer.getMyX(), 3, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 1, "Move west failed!");
    }

    @Test
    void MoveEastTest() {
        myPlayer.moveEast();
        assertEquals(myPlayer.getMyX(), 4, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 4, "Move west failed!");
        myPlayer.moveEast();
        myPlayer.moveEast();
        assertEquals(myPlayer.getMyX(), 5, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 4, "Move west failed!");
    }

    @Test
    void MoveSouthTest() {
        myPlayer.moveSouth();
        assertEquals(myPlayer.getMyX(), 3, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 5, "Move west failed!");
        myPlayer.moveSouth();
        assertEquals(myPlayer.getMyX(), 3, "Move west failed!");
        assertEquals(myPlayer.getMyY(), 5, "Move west failed!");
    }
}
