/**
 * This is the class that creates the database for the questions and answers.
 */
package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        private void start () {
            establishConnection();
            createTable();
        }

        /**
         * Establishes a connection to the database using the connector.
         */
        private void establishConnection () {
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
        private void createTable () {
            String query = "CREATE TABLE IF NOT EXISTS questions ( " +
                    "CORRECT TEXT NOT NULL PRIMARY KEY, " +
                    "WRONG1 TEXT NOT NULL," +
                    "WRONG2 TEXT NOT NULL," +
                    "WRONG3 TEXT NOT NULL)";

            try (Connection conn = myDs.getConnection();
                 Statement stmt = conn.createStatement();) {
                int rv = stmt.executeUpdate(query);
                System.out.println("executeUpdate() returned " + rv);
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
            System.out.println("Created questions table successfully");
            queryAnswers();
            queryDatabase(query);
        }

        /**
         * Queries the database for contents (will be changed!!!!).
         *
         * @param theQuery
         */
        private void queryDatabase ( final String theQuery){

            String query = theQuery;
            System.out.println("Selecting all rows from test table");
            query = "SELECT * FROM questions"; // Selecting everything?

            try (Connection conn = myDs.getConnection();
                 Statement stmt = conn.createStatement();) {

                ResultSet rs = stmt.executeQuery(query);

                // walk through each 'row' of results, grab data by column/field name
                // and print it
                while (rs.next()) {
                    String correct = rs.getString("CORRECT");
                    String wrong1 = rs.getString("WRONG1");
                    String wrong2 = rs.getString("WRONG2");
                    String wrong3 = rs.getString("WRONG3");

                    System.out.println("Result: Correct answer: " + correct +
                            ", Wrong answer1: " + wrong1 +
                            ", Wrong answer2: " + wrong2 +
                            ", Wrong answer3: " + wrong3);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }

        /**
         * Creates the questions and answers, and uploads them to the database.
         */
        private void queryAnswers () {
            System.out.println("Attempting to insert two rows into questions table");
            PokemonList pl = new PokemonList();
            ArrayList<String> sortedPokeArray = pl.getSortedPokeList();
            ArrayList<String> randomPokeArray = pl.getRandomPokeList();

            String questionInput;
            int j = 0;


            try (Connection conn = myDs.getConnection();
                 Statement stmt = conn.createStatement()) {

                for (int i = 0; i < sortedPokeArray.size(); i++) {
                    while (sortedPokeArray.get(i) == randomPokeArray.get(j) ||
                            sortedPokeArray.get(i) == randomPokeArray.get(j + 1) ||
                            sortedPokeArray.get(i) == randomPokeArray.get(j + 2)) {
                        j += 3;
                        if (j >= randomPokeArray.size()) {
                            randomPokeArray = pl.getRandomPokeList();
                            j = 0;
                        }
                    }

                    questionInput = "INSERT INTO questions (CORRECT, WRONG1, WRONG2, WRONG3) VALUES ( '"
                            + sortedPokeArray.get(i) + "', '" + randomPokeArray.get(j) + "', '"
                            + randomPokeArray.get(j + 1) + "', '" + randomPokeArray.get(j + 2) + "' )";
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
        public static void main (String[]theArgs){
            SQLDatabase db = new SQLDatabase();
        }
    }

