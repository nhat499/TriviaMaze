package Model;

import java.util.ArrayList;
<<<<<<< HEAD

/**
 * @author Nhat & Dylan
 * @version 2.0
 * This class create a maze for the trivia maze
 */

public class Maze {
    // Need java docs for these fields
    private int myHeight;
    private int myWidth;
    private int myX = 0;
    private int myY = 0;
=======
import java.util.Random;

/**
 * @author Nhat & Dylan
 * @version 2.0 - 11/19/2021
 * 2D array of Room objects representing the playing field or "Maze".
 */
public class Maze {
    /**
     * Height of the 2D array of rooms.
     */
    private int myHeight;

    /**
     * Width of the 2D array of rooms.
     */
    private int myWidth;

    /**
     * X-Coordinate for the room that acts as the exit from the maze.
     */
    private int myExitX;

    /**
     * Y-Coordinate for the room that acts as the exit from the maze.
     */
    private int myExitY;

    /**
     * 2D Array of rooms representing the layout of the maze.
     */
>>>>>>> workshop
    private Room[][] myMaze;

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
     * @param theHeight the number of rooms counted vertically in the maze.
     * @param theWidth the number of rooms counted horizontally in the maze.
     */
    public Maze(final int theWidth, final int theHeight){
<<<<<<< HEAD
        myWidth = theWidth;
        myHeight = theHeight;
        myMaze = new Room[theWidth][theHeight];
=======
        myWidth = theWidth + 2;
        myHeight = theHeight + 2;
        myMaze = new Room[myWidth][myHeight];
>>>>>>> workshop
        myPokeGenerator = new PokeListGenerator();
        myPokeList = myPokeGenerator.getRandomPokeList();
        myDatabase = new SQLDatabase();
        setupDoors();
<<<<<<< HEAD
    }

    /**
     * TODO!!!
=======
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
        if (myMaze[theX][theY] == null || myMaze[theX][theY].getVisitedStatus() == true) {
            return false;
        } else if (theX == myExitX && theY == myExitY) {
            System.out.println("yes");
            return true;
        } else {
            myMaze[theX][theY].setVisited(true);
            boolean wDoor = myMaze[theX][theY].getMyWestDoor().getMyLockedStatus();
            boolean eDoor = myMaze[theX][theY].getMyEastDoor().getMyLockedStatus();
            boolean nDoor = myMaze[theX][theY].getMyNorthDoor().getMyLockedStatus();
            boolean sDoor = myMaze[theX][theY].getMySouthDoor().getMyLockedStatus();
            if (!wDoor) {
                wDoor = escapeAbleHelper(theX - 1, theY);
            }
            if (!eDoor) {
                eDoor = escapeAbleHelper(theX + 1, theY);
            }
            if (!nDoor) {
                nDoor = escapeAbleHelper(theX, theY + 1);
            }
            if (!sDoor) {
                sDoor = escapeAbleHelper(theX, theY - 1);
            }
            return wDoor || eDoor || nDoor ||sDoor;
        }
    }

    /**
     * Create and add doors to each room within the 2D array of rooms. Adjacent rooms
     * share door objects, for example if two rooms are side by side, the left room's east
     * door is the same door object as the right room's west door. All doors around the
     * perimeter of the maze are permanently locked.
>>>>>>> workshop
     */
    private void setupDoors() {
        Door d;
        String[] questionInfo;
        int pokeCount = 0;

<<<<<<< HEAD

        for (int i = 0; i < myWidth; i++) {
            for (int j = 0; j < myHeight; j++) {
=======
        for (int i = 1; i < myWidth - 1; i++) {
            for (int j = 1; j < myHeight - 1; j++) {
>>>>>>> workshop
                myMaze[i][j] = new Room();
            }
        }

<<<<<<< HEAD
        // setup horizontal doors
        for (int i = 0; i < myWidth - 1; i++) {
            for (int j = 0; j < myHeight; j++) {
                questionInfo = myDatabase.queryDatabase(myPokeList.get(pokeCount));
=======
        for (int i = 1; i < myWidth-2; i++) {
            for (int j = 1; j < myHeight-1; j++) {
                questionInfo = myDatabase.getQuestionsFromDB(myPokeList.get(pokeCount));
>>>>>>> workshop
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMyEastDoor(d);
                myMaze[i + 1][j].setMyWestDoor(d);
                pokeCount++;
            }
        }

<<<<<<< HEAD
        // setup vertical doors
        for (int i = 0; i < myWidth; i++) {
            for (int j = 0; j < myHeight - 1; j++) {
                questionInfo = myDatabase.queryDatabase(myPokeList.get(pokeCount));
=======
        for (int i = 1; i < myWidth-1; i++) {
            for (int j = 1; j < myHeight-2; j++) {
                questionInfo = myDatabase.getQuestionsFromDB(myPokeList.get(pokeCount));
>>>>>>> workshop
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMySouthDoor(d);
                myMaze[i][j + 1].setMyNorthDoor(d);
                pokeCount++;
            }
        }
<<<<<<< HEAD
    }

    /**
     * get a room from the maze
=======
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
>>>>>>> workshop
     * @param theX the x position of the room
     * @param theY the y position of the room
     * @return the room if exist or null
     */
    public Room getRoom(final int theX, final int theY) {
<<<<<<< HEAD
        if (theX > myWidth || theY > myHeight) {
=======
        if (theX >= myWidth || theY >= myHeight || theX < 1 || theY < 1) {
>>>>>>> workshop
            System.out.println("There are no room at that index");
            return null;
        } else {
            return myMaze[theX][theY];
        }
    }

    /**
<<<<<<< HEAD
     * get the length of the maze
=======
     * Get the length of the maze.
>>>>>>> workshop
     * @return the maze length
     */
    public int getMyHeight() {
        return myHeight;
    }

    /**
<<<<<<< HEAD
     * get the width of the maze
=======
     * Get the width of the maze.
>>>>>>> workshop
     * @return the maze's width
     */
    public int getMyWidth() {
        return myWidth;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < myHeight; i++) {
            for (int j = 0; j < myWidth; j++) {
                s+= "*";
            }
            s+="\n";
        }
        return s;
    }

    private void printTest() {
        for (int i = 0; i < myWidth; i++) {
            for (int j = 0; j < myHeight; j++) {
                System.out.println("My coordinates are " + i + " " + j);
                if (myMaze[j][i].getMyEastDoor() != null) {
                    System.out.println("East door: " + myMaze[j][i].getMyEastDoor().printDoor());
                }
                if (myMaze[j][i].getMyNorthDoor() != null) {
                    System.out.println("North door: " + myMaze[j][i].getMyNorthDoor().printDoor());
                }
                if (myMaze[j][i].getMyWestDoor() != null) {
                    System.out.println("West door: " + myMaze[j][i].getMyWestDoor().printDoor());
                }
                if (myMaze[j][i].getMySouthDoor() != null) {
                    System.out.println("South door: " + myMaze[j][i].getMySouthDoor().printDoor());
                }
            }
        }
    }

    public static void main(String[] args) {
        Maze m = new Maze(7, 7);
        m.printTest();
    }
}
=======
}
>>>>>>> workshop
