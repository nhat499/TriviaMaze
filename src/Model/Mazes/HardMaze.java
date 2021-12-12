package Model.Mazes;

import java.io.Serializable;

/**
 * @author Nhat & Dylan
 * @version 1.0 - 12/10/2021
 * 2D array of Room objects representing the playing field or "Maze".
 */
public class HardMaze extends Maze implements Serializable {
    /**
     * Public construct for Maze class.
     */
    public HardMaze() {
        super();
        lockDoors();
    }

    /**
     * Locks doors in such a pattern that there is only a single path out of the maze.
     */
    private void lockDoors() {
        for (int i = 1; i < BUFFERED_SIZE - 1; i++) {
            for (int j = 1; j < BUFFERED_SIZE - 1; j++) {
                if ((j != 5 && i % 2 != 0) || (j != 1 && i % 2 == 0)) {
                    myRooms[i][j].getMyEastDoor().setMyLockedStatus(true);
                }
            }
        }
    }
}
