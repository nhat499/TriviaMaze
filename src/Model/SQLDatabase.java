/**
 * This is the class that creates the database for the questions and answers.
 */
package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Andrew and Dylan
<<<<<<< HEAD
 * @version 1.0
=======
 * @version 2.0 - 11/19/2021
>>>>>>> workshop
 * This class establishes a connection to the database and loads the questions and answers to it.
 * This class exits the system if it notices issues, and it currently prints out the contents loaded to
 * the database.
 */
public class SQLDatabase {

    /**
     * Connection to the database.
     */
    SQLiteDataSource myDs = null;

    /**
     * Public constructor for SQLDatabase.
     */
    public SQLDatabase() {
<<<<<<< HEAD
        start();
    }

    /**
     * Start program that runs the methods.
     */
    private void start() {
=======
>>>>>>> workshop
        establishConnection();
        createTable();
    }

    /**
     * Establishes a connection to the database using the connector.
     */
    private void establishConnection() {
        try {
            myDs = new SQLiteDataSource();
            myDs.setUrl("jdbc:sqlite:questions.db");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
<<<<<<< HEAD
        System.out.println("Opened database successfully");
=======
>>>>>>> workshop
    }

    /**
     * Creates the table that will contain the questions and answers.
     */
    private void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS questions (CORRECT TEXT NOT NULL PRIMARY KEY, WRONG1 TEXT NOT NULL, WRONG2 TEXT NOT NULL, WRONG3 TEXT NOT NULL, IMGPATH TEXT NOT NULL)";

        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement();) {
            int rv = stmt.executeUpdate(query);
<<<<<<< HEAD
            System.out.println("executeUpdate() returned " + rv);
=======
>>>>>>> workshop
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
<<<<<<< HEAD
        System.out.println("Created questions table successfully");
    }

    /**
     * Queries the database for contents (will be changed!!!!).
     *
     * @param
     */
    public String[] queryDatabase(final String thePrimaryKey) {
=======
    }

    /**
     * When passed the name of a Pokemon, collects and returns a String array of length 5
     * containing the passed in Pokemon's name in index zero, different random Pokemon
     * names in indexes 1, 2, and 3, and a file path to an image of the passed in Pokemon in
     * index 4.
     *
     * @param - String, the name of a first generation Pokemon. Assumes all lower case.
     */
    public String[] getQuestionsFromDB(final String thePrimaryKey) {
>>>>>>> workshop
        String[] output = new String[5];
        String query = "SELECT * FROM questions WHERE CORRECT = '" + thePrimaryKey + "'";

        try (Connection conn = myDs.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            output[0] = rs.getString("CORRECT");
            output[1] = rs.getString("WRONG1");
            output[2] = rs.getString("WRONG2");
            output[3] = rs.getString("WRONG3");
            output[4] = rs.getString("IMGPATH");

<<<<<<< HEAD

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Huh");
            System.exit(0);
=======
        } catch (SQLException e) {
            populateDatabase();
            output = getQuestionsFromDB(thePrimaryKey);
>>>>>>> workshop
        }
        return output;
    }

    /**
<<<<<<< HEAD
     * Creates the questions and answers, and uploads them to the database.
     */
    private void queryAnswers() {
        System.out.println("Attempting to insert two rows into questions table");
        PokeListGenerator pl = new PokeListGenerator();
        ArrayList<String> sortedPokeArray = pl.getSortedPokeList();
        ArrayList<String> randomPokeArray = pl.getRandomPokeList();

        String questionInput;
        int j = 0;

=======
     * Populates the questions.db file with Pokemon question information
     * in the following format:
     * Column one: Primary key/correct answer Pokemon's name
     * Column two: Incorrect answer, random Pokemon name.
     * Column three: Incorrect answer, random Pokemon name.
     * Column four: Incorrect answer, random Pokemon name.
     * Column five: File path to an image of the primary key/correct answer Pokemon.
     */
    private void populateDatabase() {
        PokeListGenerator pl = new PokeListGenerator();
        ArrayList<String> sortedPokeArray = pl.getSortedPokeList();
        final int incorrectAnswerCount = 3;
        String[] incorrectAnswers;
        String questionInput;
>>>>>>> workshop

        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement()) {

            for (int i = 0; i < sortedPokeArray.size(); i++) {
<<<<<<< HEAD
                if (j + 2 >= randomPokeArray.size()) {
                    randomPokeArray = pl.getRandomPokeList();
                    j = 0;
                }
                while (sortedPokeArray.get(i) == randomPokeArray.get(j) ||
                        sortedPokeArray.get(i) == randomPokeArray.get(j + 1) ||
                        sortedPokeArray.get(i) == randomPokeArray.get(j + 2)) {
                    j += 3;

                }

                questionInput = "INSERT INTO questions (CORRECT, WRONG1, WRONG2, WRONG3, IMGPATH) VALUES ( '"
                        + sortedPokeArray.get(i) + "', '" + randomPokeArray.get(j) + "', '"
                        + randomPokeArray.get(j + 1) + "', '" + randomPokeArray.get(j + 2) + "', '"
                        + "TriviaMaze/src/Model/PokeImages/" + sortedPokeArray.get(i) + ".jpg')";
                stmt.executeUpdate(questionInput);

                j += 3;

                if (j >= randomPokeArray.size()) {
                    randomPokeArray = pl.getRandomPokeList();
                    j = 0;
                }
=======
                incorrectAnswers = pl.getSomeRandomPokemon(sortedPokeArray.get(i), incorrectAnswerCount);

                questionInput = "INSERT INTO questions (CORRECT, WRONG1, WRONG2, WRONG3, IMGPATH) VALUES ( '"
                        + sortedPokeArray.get(i) + "', '" + incorrectAnswers[0] + "', '"
                        + incorrectAnswers[1] + "', '" + incorrectAnswers[2] + "', '"
                        + "TriviaMaze/src/Model/PokeImages/" + sortedPokeArray.get(i) + ".jpg')";
                stmt.executeUpdate(questionInput);
>>>>>>> workshop
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
<<<<<<< HEAD


    /**
     * Main method that executes the start method.
     *
     * @param theArgs
     */

}

=======
}
>>>>>>> workshop
