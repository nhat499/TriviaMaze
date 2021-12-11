package Model.Mazes;

/**
 * MazeFactory class used to generate Mazes of different difficulty.
 * @author - Dylan
 * @version - 12/10/2021
 */
public class MazeFactory {

    public static Maze CreateMaze(final String theDifficulty) {
        Maze output;

        if (theDifficulty.equals("easy")) {
            output = new EasyMaze();
        } else if (theDifficulty.equals("medium")) {
            output = new MediumMaze();
        } else if (theDifficulty.equals("hard")) {
            output = new HardMaze();
        } else {
            throw new IllegalArgumentException("theDifficulty must be one of the following" +
                    "Strings: easy, medium, or hard");
        }
        return output;
    }
}
