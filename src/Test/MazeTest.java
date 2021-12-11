package Test;

import Model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MazeTest {
//    Maze maze;
//    Player player;
//
//    @BeforeEach
//    void setUp() {
//        maze = new Maze(5,5);
//        player = new Player(1,1, maze);
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @Test
//    void escapeAbleDoorLockAroundPlayer() {
//        maze.getRoom(1,1).getMySouthDoor().setMyLockedStatus(true);
//        maze.getRoom(1,1).getMyEastDoor().setMyLockedStatus(true);
//        assertFalse(maze.escapeAble(player.getMyX(),player.getMyY()));
//    }
//    @Test
//    void escapeAbleDoorNoLock() {
//        assertTrue(maze.escapeAble(player.getMyX(),player.getMyY()));
//    }
//
//    @Test
//    void escapeAbleDoorLockAroundExit() {
//        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
//                getMyWestDoor().setMyLockedStatus(true);
//        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
//                getMyNorthDoor().setMyLockedStatus(true);
//        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
//                getMyEastDoor().setMyLockedStatus(true);
//        maze.getRoom(maze.getMyExitX(), maze.getMyExitY()).
//                getMySouthDoor().setMyLockedStatus(true);
//        assertFalse(maze.escapeAble(player.getMyX(),player.getMyY()));
//    }
//
//    @Test
//    void getMyHeight() {
//        assertEquals(maze.getMyHeight(), 7);
//    }
//
//    @Test
//    void getRoomNotNull() {
//        assertNotNull(maze.getRoom(1,1));
//        assertNotNull(maze.getRoom(3,3));
//        assertNotNull(maze.getRoom(5,5));
//    }
//
//    @Test
//    void getRoomNull() {
//        assertNull(maze.getRoom(0,0));
//        assertNull(maze.getRoom(8,8));
//        assertNull(maze.getRoom(-1,-3));
//    }
}