package Model;

import java.util.ArrayList;

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
        myWidth = theWidth;
        myHeight = theHeight;
        myMaze = new Room[theWidth][theHeight];
        myPokeGenerator = new PokeListGenerator();
        myPokeList = myPokeGenerator.getRandomPokeList();
        myDatabase = new SQLDatabase();
        setupDoors();
    }

    /**
     * TODO!!!
     */
    private void setupDoors() {
        Door d;
        String[] questionInfo;
        int pokeCount = 0;


        for (int i = 0; i < myWidth; i++) {
            for (int j = 0; j < myHeight; j++) {
                myMaze[i][j] = new Room();
            }
        }

        // setup horizontal doors
        for (int i = 0; i < myWidth - 1; i++) {
            for (int j = 0; j < myHeight; j++) {
                questionInfo = myDatabase.queryDatabase(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMyEastDoor(d);
                myMaze[i + 1][j].setMyWestDoor(d);
                pokeCount++;
            }
        }

        // setup vertical doors
        for (int i = 0; i < myWidth; i++) {
            for (int j = 0; j < myHeight - 1; j++) {
                questionInfo = myDatabase.queryDatabase(myPokeList.get(pokeCount));
                d = new Door(questionInfo[0],questionInfo[1],
                        questionInfo[2],questionInfo[3],questionInfo[4]);
                myMaze[i][j].setMySouthDoor(d);
                myMaze[i][j + 1].setMyNorthDoor(d);
                pokeCount++;
            }
        }
    }

    /**
     * get a room from the maze
     * @param theX the x position of the room
     * @param theY the y position of the room
     * @return the room if exist or null
     */
    public Room getRoom(final int theX, final int theY) {
        if (theX > myWidth || theY > myHeight) {
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
