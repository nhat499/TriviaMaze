/**
 * This is the class that creates the database for the questions and answers.
 */
package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Andrew and Dylan
 * @version 1.0
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
        start();
    }

    /**
     * Start program that runs the methods.
     */
    private void start() {
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
        System.out.println("Opened database successfully");
    }

    /**
     * Creates the table that will contain the questions and answers.
     */
    private void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS questions (CORRECT TEXT NOT NULL PRIMARY KEY, WRONG1 TEXT NOT NULL, WRONG2 TEXT NOT NULL, WRONG3 TEXT NOT NULL, IMGPATH TEXT NOT NULL)";

        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement();) {
            int rv = stmt.executeUpdate(query);
            System.out.println("executeUpdate() returned " + rv);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Created questions table successfully");
    }

    /**
     * Queries the database for contents (will be changed!!!!).
     *
     * @param
     */
    public String[] queryDatabase(final String thePrimaryKey) {
        String[] output = new String[5];
        String query = "SELECT * FROM questions WHERE CORRECT = '" + thePrimaryKey + "'";

        try (Connection conn = myDs.getConnection(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            output[0] = rs.getString("CORRECT");
            output[1] = rs.getString("WRONG1");
            output[2] = rs.getString("WRONG2");
            output[3] = rs.getString("WRONG3");
            output[4] = rs.getString("IMGPATH");


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Huh");
            System.exit(0);
        }
        return output;
    }

    /**
     * Creates the questions and answers, and uploads them to the database.
     */
    private void queryAnswers() {
        System.out.println("Attempting to insert two rows into questions table");
        PokeListGenerator pl = new PokeListGenerator();
        ArrayList<String> sortedPokeArray = pl.getSortedPokeList();
        ArrayList<String> randomPokeArray = pl.getRandomPokeList();

        String questionInput;
        int j = 0;


        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement()) {

            for (int i = 0; i < sortedPokeArray.size(); i++) {
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


    /**
     * Main method that executes the start method.
     *
     * @param theArgs
     */

}
