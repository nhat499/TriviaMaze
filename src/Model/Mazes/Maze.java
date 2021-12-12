package Model.Mazes;

import Model.Door;
import Model.PokeListGenerator;
import Model.Room;
import Model.SQLDatabase;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nhat & Dylan
 * @version 2.0 - 11/19/2021
 * 2D array of Room objects representing the playing field or "Maze".
 */
public abstract class Maze implements Serializable {

    /**
     * Height of the 2D array of rooms.
     */
    protected static final int EXIT = 5;

    /**
     * Height of the 2D array of rooms.
     */
    protected static final int BUFFERED_SIZE = 7;

    /**
     * 2D Array of rooms representing the layout of the maze.
     */
    protected final Room[][] myRooms;

    /**
     * Used to generate a list of Pokemon.
     */
    protected final PokeListGenerator myPokeGenerator;

    /**
     * A list of Pokemon.
     */
    protected final ArrayList<String> myPokeList;

    /**
     * Used to access to the question.db database file.
     */
    protected final SQLDatabase myDatabase;

    /**
     * Public construct for Maze class.
     *
     */
    public Maze() {
        myRooms = new Room[BUFFERED_SIZE][BUFFERED_SIZE];
        myPokeGenerator = new PokeListGenerator();
        myPokeList = myPokeGenerator.getRandomPokeList();
        myDatabase = new SQLDatabase();
        setupDoors();
    }

    /**
     * This method takes in the position of the player and
     * check to see if an escape is still possible.
     *
     * @param theX the x position of the player.
     * @param theY the y position of the player.
     * @return true if an escape can be made, otherwise false.
     */
    public boolean escapeAble(int theX, int theY) {
        boolean[][] visitedRoom = new boolean[BUFFERED_SIZE][BUFFERED_SIZE];
        boolean b = escapeAbleHelper(theX, theY, visitedRoom, false);
        return b;
    }

    /**
     * This is a helper method for escapeAble.
     *
     * @param theX the x position of the player.
     * @param theY the y postion of the player.
     * @return true if an escape can be made, otherwise false.
     */
    private boolean escapeAbleHelper(int theX, int theY, boolean[][] theVisitedRoom, boolean thePreviousDoor) {
        if (theVisitedRoom[theX][theY] || thePreviousDoor || myRooms[theX][theY] == null) {
            return false;
        } else if (theX == EXIT && theY == EXIT) {
            return true;
        } else {
            theVisitedRoom[theX][theY] = true;
            boolean up = escapeAbleHelper(theX, theY - 1, theVisitedRoom, myRooms[theX][theY].getMyNorthDoor().getMyLockedStatus());
            boolean down = escapeAbleHelper(theX, theY + 1, theVisitedRoom, myRooms[theX][theY].getMySouthDoor().getMyLockedStatus());
            boolean left = escapeAbleHelper(theX - 1, theY, theVisitedRoom, myRooms[theX][theY].getMyWestDoor().getMyLockedStatus());
            boolean right = escapeAbleHelper(theX + 1, theY, theVisitedRoom, myRooms[theX][theY].getMyEastDoor().getMyLockedStatus());
            return up || down || left || right;
        }
    }

    /**
     * Create and add doors to each room within the 2D array of rooms. Adjacent rooms
     * share door objects, for example if two rooms are side by side, the left room's east
     * door is the same door object as the right room's west door. All doors around the
     * perimeter of the maze are permanently locked.
     */
    private void setupDoors() {
        Door d;
        String[] questionInfo;
        int pokeCount = 0;

        for (int i = 1; i < BUFFERED_SIZE - 1; i++) {
            for (int j = 1; j < BUFFERED_SIZE - 1; j++) {
                myRooms[i][j] = new Room();
            }
        }

        for (int i = 1; i < BUFFERED_SIZE - 2; i++) {
            for (int j = 1; j < BUFFERED_SIZE - 1; j++) {
                questionInfo = myDatabase.getQuestionsFromDB(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0], questionInfo[1],
                        questionInfo[2], questionInfo[3]);
                myRooms[i][j].setMyEastDoor(d);
                myRooms[i + 1][j].setMyWestDoor(d);
                pokeCount++;
            }
        }

        for (int i = 1; i < BUFFERED_SIZE - 1; i++) {
            for (int j = 1; j < BUFFERED_SIZE - 2; j++) {
                questionInfo = myDatabase.getQuestionsFromDB(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0], questionInfo[1],
                        questionInfo[2], questionInfo[3]);
                myRooms[i][j].setMySouthDoor(d);
                myRooms[i][j + 1].setMyNorthDoor(d);
                pokeCount++;
            }
        }

        Door northDoor;
        Door southDoor;
        Door eastDoor;
        Door westDoor;
        for (int i = 1; i < BUFFERED_SIZE - 1; i++) {
            northDoor = new Door();
            myRooms[i][1].setMyNorthDoor(northDoor);
            southDoor = new Door();
            myRooms[i][BUFFERED_SIZE - 2].setMySouthDoor(southDoor);
            eastDoor = new Door();
            myRooms[BUFFERED_SIZE - 2][i].setMyEastDoor(eastDoor);
            westDoor = new Door();
            myRooms[1][i].setMyWestDoor(westDoor);
        }
    }

    /**
     * Get a room from the maze.
     *
     * @param theX the x position of the room
     * @param theY the y position of the room
     * @return the room if exist or null
     */
    public Room getRoom(final int theX, final int theY) {
        if (theX >= BUFFERED_SIZE || theY >= BUFFERED_SIZE || theX < 1 || theY < 1) {
            System.out.println("There are no room at that index");
            return null;
        } else {
            return myRooms[theX][theY];
        }
    }

    /**
     * Get the length of the maze.
     *
     * @return the maze length
     */
    public int getMyHeight() {
        return BUFFERED_SIZE;
    }

    /**
     * Get the width of the maze.
     *
     * @return the maze's width
     */
    public int getMyWidth() {
        return BUFFERED_SIZE;
    }

    /**
     * Getting for exitX
     */
    public int getMyExitX() {
        return EXIT;
    }

    /**
     * Getting for exitY
     */
    public int getMyExitY() {
        return EXIT;
    }
}
