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
    public Maze(int theLength, int theWidth){
        myMaze = new Room[theLength][theWidth];
    }

    // add room to the maze
    public void addRoom(Room theRoom) {
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
    public Room getRoom(int theX, int theY) {
        if (theX > myWidth || theY > myLength) {
            System.out.println("There are no room at that index");
            return null;
        } else {
            return myMaze[theX][theY];
        }
    }

    // set and get size of the maze
    public void setMyLength(int theLength) {
        myLength = theLength;
    }
    public int getMyLength() {
        return myLength;
    }
    public int getMyWidth() {
        return myWidth;
    }
    public void setMyWidth(int theWidth) {
        myWidth = theWidth;
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
