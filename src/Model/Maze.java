package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Nhat & Dylan
 * @version 2.0
 * This class create a maze for the trivia maze
 */

public class Maze {
    // Need java docs for these fields
    private int myHeight;
    private int myWidth;
    private int myExitX;
    private int myExitY;
    private Room[][] myMaze;

    public int getMyExitX() {
        return myExitX;
    }

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
     * @param theHeight the number of rooms counted vertically in the maze.
     * @param theWidth the number of rooms counted horizontally in the maze.
     */
    public Maze(final int theWidth, final int theHeight){
        myWidth = theWidth + 2;
        myHeight = theHeight + 2;
        myMaze = new Room[myWidth][myHeight];
        myPokeGenerator = new PokeListGenerator();
        myPokeList = myPokeGenerator.getRandomPokeList();
        myDatabase = new SQLDatabase();
        setupDoors();
        Random rand = new Random();
        //myExitX = rand.nextInt(myWidth - 2) + 1;
        //myExitY = rand.nextInt(myWidth - 2) + 1;
        myExitX = 3;
        myExitY = 3;
        myMaze[myExitX][myExitY].setExit(true);
    }

    /**
     * This method takes in the positon of the player and
     * check to see if an escape is still possible.
     * @param theX the x position of the player.
     * @param theY the y postion of the player.
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
        if(myMaze[theX][theY].getVisited() || allDoor) {
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
     * TODO!!!
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

        // setup horizontal doors
        for (int i = 1; i < myWidth-2; i++) {
            for (int j = 1; j < myHeight-1; j++) {
                questionInfo = myDatabase.queryDatabase(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMyEastDoor(d);
                myMaze[i + 1][j].setMyWestDoor(d);
                pokeCount++;
            }
        }

        // setup vertical doors
        for (int i = 1; i < myWidth-1; i++) {
            for (int j = 1; j < myHeight-2; j++) {
                questionInfo = myDatabase.queryDatabase(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMySouthDoor(d);
                myMaze[i][j + 1].setMyNorthDoor(d);
                pokeCount++;
            }
        }
        // create and lock outer door
        Door northDoor;
        Door southDoor;
        Door eastDoor;
        Door westDoor;
        for(int i = 1; i < myWidth - 1; i++) { // assuming myWidth is the same as myHeight
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
     * get a room from the maze
     * @param theX the x position of the room
     * @param theY the y position of the room
     * @return the room if exist or null
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
     * get the length of the maze
     * @return the maze length
     */
    public int getMyHeight() {
        return myHeight;
    }

    /**
     * get the width of the maze
     * @return the maze's width
     */
    public int getMyWidth() {
        return myWidth;
    }

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
        for (int i = 1; i < myWidth-1; i++) {
            for (int j = 1; j < myHeight-1; j++) {
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
        Maze m = new Maze(5, 5);
        // System.out.println(m.getRoom(1,1).getMyWestDoor().);
        //System.out.println(m.getRoom(0,0));
        System.out.println(m.getMyExitX() + ", " + m.getMyExitY()) ;
        m.getRoom(2,2).getMyEastDoor().setMyLockedStatus(true);

        //m.getRoom(1,1).getMyEastDoor().setMyLockedStatus(true);
        m.getRoom(1,1).getMyWestDoor().setMyLockedStatus(true);
        //m.getRoom(1, 1).getMySouthDoor().setMyLockedStatus(true);
        m.getRoom(1,1).getMyNorthDoor().setMyLockedStatus(true);
        System.out.println(m.escapeAble(1,1));
    }
}