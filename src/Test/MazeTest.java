package Test;

import Model.Maze;
import Model.Player;

import static org.junit.jupiter.api.Assertions.*;

class MazeTest {
    Maze maze;
    Player player;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        maze = new Maze();
        player = new Player(1,1, maze);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void escapeAbleDoorLockAroundPlayer() {
        maze.getRoom(1,1).getMySouthDoor().setMyLockedStatus(true);
        maze.getRoom(1,1).getMyEastDoor().setMyLockedStatus(true);
        assertFalse(maze.escapeAble(player.getMyX(),player.getMyY()));
    }

    @org.junit.jupiter.api.Test
    void escapeAbleDoorLockAroundExit() {
        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
                getMyWestDoor().setMyLockedStatus(true);
        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
                getMyNorthDoor().setMyLockedStatus(true);
        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
                getMyEastDoor().setMyLockedStatus(true);
        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
                getMySouthDoor().setMyLockedStatus(true);
        assertFalse(maze.escapeAble(player.getMyX(),player.getMyY()));
    }

    @org.junit.jupiter.api.Test
    void escapeAbleSomeLockDoor() {
        maze.getRoom(1,1).getMySouthDoor().setMyLockedStatus(true);
        maze.getRoom(3,2).getMyEastDoor().setMyLockedStatus(true);
        maze.getRoom(4,5).getMyNorthDoor().setMyLockedStatus(true);
        assertTrue(maze.escapeAble(player.getMyX(),player.getMyY()));
    }

    @org.junit.jupiter.api.Test
    void getMyHeight() {
        assertEquals(maze.getMyHeight(), 5);
    }
}