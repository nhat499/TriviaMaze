package Model;

import java.util.Arrays;

/**
 * @author Nhat
 * @version 1.0
 * This class create a maze for the trivia maze
 */

public class Maze {
    private int myLength;
    private int myWidth;
    private int myX = 0;
    private int myY = 0;
    private Room[][] myMaze;

    // constructor for the maze
    public Maze(final int theLength, final int theWidth){
        myMaze = new Room[theLength][theWidth];
    }

    // add room to the maze
    public void addRoom(final Room theRoom) {
        myX++;
        if (myX > myLength) {
            myX = 0;
            myY++;
        }
        myY++;
        if (myY <= myWidth) {
            myMaze[myX][myY] = theRoom;
        } else {
            System.out.println("the maze is full");
        }
    }

    /**
     * get a room from the maze
     * @param theX the x position of the room
     * @param theY the y position of the room
     * @return the room if exist or null
     */
    public Room getRoom(final int theX, final int theY) {
        if (theX > myWidth || theY > myLength) {
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
    public int getMyLength() {
        return myLength;
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
        for (int i = 0; i < myLength; i++) {
            for (int j = 0; j < myWidth; i++) {
                s+= "#";
            }
            s+="\n";
        }
        return s;
    }
}
