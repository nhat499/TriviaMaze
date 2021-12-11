package Model.Mazes;

import Model.Door;

/**
 * @author Nhat & Dylan
 * @version 1.0 - 12/10/2021
 * 2D array of Room objects representing the playing field or "Maze".
 */
public class MediumMaze extends Maze{
    /**
     * Public construct for Maze class.
     */
    public MediumMaze() {
        super();
        lockDoors();
    }

    /**
     * Locks doors in such a pattern that maneuverability through the maze is greatly reduced.
     */
    private void lockDoors() {

        for (int i = 1; i < BUFFERED_SIZE - 1; i++) {
            for (int j = 1; j < BUFFERED_SIZE - 1; j++) {
                if (i % 2 != 0 && j % 2 != 0 ) {
                    myRooms[i][j].getMyEastDoor().setMyLockedStatus(true);
                }

                if (i % 2 == 0 && j % 2 == 0 ) {
                    myRooms[i][j].getMyEastDoor().setMyLockedStatus(true);
                }
            }
        }
    }
}
