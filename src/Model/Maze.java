package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Nhat & Dylan & Andrew
 * @version 2.0 - 11/19/2021
 * 2D array of Room objects representing the playing field or "Maze".
 */
public class Maze {
    /**
     * Height of the 2D array of rooms.
     */
    private final int myHeight;

    /**
     * Width of the 2D array of rooms.
     */
    private final int myWidth;

    /**
     * X-Coordinate for the room that acts as the exit from the maze.
     */
    private final int myExitX;

    /**
     * Y-Coordinate for the room that acts as the exit from the maze.
     */
    private final int myExitY;

    /**
     * 2D Array of rooms representing the layout of the maze.
     */
    private final Room[][] myMaze;

    /**
     * Getter for the exit x.
     * @return the x exit location.
     */
    public int getMyExitX() {
        return myExitX;
    }

    /**
     * Getter for the exit .
     * @return the y exit.
     */
    public int getMyExitY() {
        return myExitY;
    }

    /**
     * Used to generate a list of Pokemon.
     */
    private final PokeListGenerator myPokeGenerator;

    /**
     * A list of Pokemon.
     */
    private final ArrayList<String> myPokeList;

    /**
     * Used to access to the question.db database file.
     */
    private final SQLDatabase myDatabase;

    /**
     * Public construct for Maze class.
     */
    public Maze(){
        myWidth = 7;
        myHeight = 7;
        myMaze = new Room[myWidth][myHeight];
        myPokeGenerator = new PokeListGenerator();
        myPokeList = myPokeGenerator.getRandomPokeList();
        myDatabase = new SQLDatabase();
        setupDoors();
        Random rand = new Random();
        myExitX = rand.nextInt(myWidth - 2) + 1;
        myExitY = rand.nextInt(myWidth - 2) + 1;
        myMaze[myExitX][myExitY].setExit(true);
    }

    /**
     * This method takes in the position of the player and
     * check to see if an escape is still possible.
     * @param theX the x position of the player.
     * @param theY the y position of the player.
     * @return true if an escape can be made, otherwise false.
     */
    public boolean escapeAble(int theX, int theY) {
        boolean b = escapeAbleHelper(theX, theY);
        for (int i = 1; i < myWidth - 1; i++) {
            for(int j = 1; j < myHeight - 1; j++) {
                myMaze[i][j].setVisited(false);
            }
        }
        return b;
    }

    /**
     * This is a helper method for escapeAble.
     * @param theX the x position of the player.
     * @param theY the y postion of the player.
     * @return true if an escape can be made, otherwise false.
     */
    private boolean escapeAbleHelper(int theX, int theY) {
        boolean allDoor;
        if (myMaze[theX][theY] == null) {
            return false;
        } else {
            boolean wDoor = myMaze[theX][theY].getMyWestDoor().getMyLockedStatus();
            boolean eDoor = myMaze[theX][theY].getMyEastDoor().getMyLockedStatus();
            boolean nDoor = myMaze[theX][theY].getMyNorthDoor().getMyLockedStatus();
            boolean sDoor = myMaze[theX][theY].getMySouthDoor().getMyLockedStatus();
            allDoor = wDoor && eDoor && nDoor && sDoor;
        }
        if(myMaze[theX][theY].getVisitedStatus() || allDoor) {
            return false;
        } else if (theX == myExitX && theY == myExitY) {
            System.out.println("yes");
            return true;
        } else {
            myMaze[theX][theY].setVisited(true);
            return escapeAbleHelper(theX - 1, theY) || escapeAbleHelper(theX + 1, theY) ||
                    escapeAbleHelper(theX, theY + 1) || escapeAbleHelper(theX, theY - 1);
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

        for (int i = 1; i < myWidth - 1; i++) {
            for (int j = 1; j < myHeight - 1; j++) {
                myMaze[i][j] = new Room();
            }
        }

        for (int i = 1; i < myWidth-2; i++) {
            for (int j = 1; j < myHeight-1; j++) {
                questionInfo = myDatabase.getQuestionsFromDB(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMyEastDoor(d);
                myMaze[i + 1][j].setMyWestDoor(d);
                pokeCount++;
            }
        }

        for (int i = 1; i < myWidth-1; i++) {
            for (int j = 1; j < myHeight-2; j++) {
                questionInfo = myDatabase.getQuestionsFromDB(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMySouthDoor(d);
                myMaze[i][j + 1].setMyNorthDoor(d);
                pokeCount++;
            }
        }
        if (myMaze[2][1] == null) {
            System.out.println("...");
        }

        Door northDoor;
        Door southDoor;
        Door eastDoor;
        Door westDoor;
        for(int i = 1; i < myWidth - 1; i++) {
            northDoor = new Door();
            myMaze[i][1].setMyNorthDoor(northDoor);
            southDoor = new Door();
            myMaze[i][myWidth-2].setMySouthDoor(southDoor);
            eastDoor = new Door();
            myMaze[myWidth-2][i].setMyEastDoor(eastDoor);
            westDoor = new Door();
            myMaze[1][i].setMyWestDoor(westDoor);
        }
    }

    /**
     * Get a room from the maze.
     * @param theX the x position of the room.
     * @param theY the y position of the room.
     * @return the room if exist or null.
     */
    public Room getRoom(final int theX, final int theY) {
        if (theX >= myWidth || theY >= myHeight || theX < 1 || theY < 1) {
            System.out.println("There are no room at that index");
            return null;
        } else {
            return myMaze[theX][theY];
        }
    }

    /**
     * Get the length of the maze.
     * @return the maze length.
     */
    public int getMyHeight() {
        return myHeight - 2;
    }

    /**
     * Get the width of the maze.
     * @return the maze's width.
     */
    public int getMyWidth() {
        return myWidth - 2;
    }


}
