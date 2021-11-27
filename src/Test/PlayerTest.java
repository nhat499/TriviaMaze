package Test;

import Model.Maze;
import Model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;
    Player centerPlayer;
    Maze maze;

    @BeforeEach
    void setUp() {
        maze = new Maze();
        player = new Player(1,1, maze);
        centerPlayer = new Player(3,3, maze);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void moveNorth() {
        assertEquals(centerPlayer.getMyX(),3);
        assertEquals(centerPlayer.getMyY(),3);
        centerPlayer.moveNorth();
        assertEquals(centerPlayer.getMyX(),3);
        assertEquals(centerPlayer.getMyY(),2);
    }

    @Test
    void moveSouth() {
        assertEquals(centerPlayer.getMyX(),3);
        assertEquals(centerPlayer.getMyY(),3);
        centerPlayer.moveSouth();
        assertEquals(centerPlayer.getMyX(),3);
        assertEquals(centerPlayer.getMyY(),4);
    }

    @Test
    void moveWest() {
        assertEquals(centerPlayer.getMyX(),3);
        assertEquals(centerPlayer.getMyY(),3);
        centerPlayer.moveWest();
        assertEquals(centerPlayer.getMyX(),2);
        assertEquals(centerPlayer.getMyY(),3);
    }

    @Test
    void moveEast() {
        assertEquals(centerPlayer.getMyX(),3);
        assertEquals(centerPlayer.getMyY(),3);
        centerPlayer.moveEast();
        assertEquals(centerPlayer.getMyX(),4);
        assertEquals(centerPlayer.getMyY(),3);
    }
}