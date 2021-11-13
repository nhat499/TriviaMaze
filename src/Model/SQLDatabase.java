/**
 * This is the class that creates the database for the questions and answers.
 */
package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Andrew
 * @version 1.0
 * This class establishes a connection to the database and loads the questions and answers to it.
 * This class exits the system if it notices issues, and it currently prints out the contents loaded to
 * the database.
 *
 */
public class SQLDatabase {

    /**
     * Connection to the database.
     */
    SQLiteDataSource myDs = null;

    /**
     * Start program that runs the methods.
     */
    private void start() {
        establishConnection();
        createTable();
    }

    /**
     * Main method that executes the start method.
     * @param theArgs
     */
    public static void main(String[] theArgs) {
        SQLDatabase db = new SQLDatabase();
        db.start();
    }

    /**
     * Establishes a connection to the database using the connector.
     */
    private void establishConnection() {
        try {
            myDs = new SQLiteDataSource();
            myDs.setUrl("jdbc:sqlite:questions.db");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println( "Opened database successfully" );
    }

    /**
     * Creates the table that will contain the questions and answers.
     */
    private void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS questions ( " +
                "QUESTION TEXT NOT NULL PRIMARY KEY, " +
                "ANSWER TEXT NOT NULL )";
        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query );
            System.out.println( "executeUpdate() returned " + rv );
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
        System.out.println( "Created questions table successfully" );
        queryAnswers();
        queryDatabase(query);
    }

    /**
     * Queries the database for contents (will be changed!!!!).
     * @param theQuery
     */
    private void queryDatabase(final String theQuery) {

        String query = theQuery;
        System.out.println( "Selecting all rows from test table" );
        query = "SELECT * FROM questions";

        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement(); ) {

            ResultSet rs = stmt.executeQuery(query);

            //walk through each 'row' of results, grab data by column/field name
            // and print it
            while ( rs.next() ) {
                String question = rs.getString( "QUESTION" );
                String answer = rs.getString( "ANSWER" );

                System.out.println( "Result: Question = " + question +
                        ", Answer = " + answer );
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }

    }

    /**
     * Creates the questions and answers, and uploads them to the database.
     */
    private void queryAnswers() {
        System.out.println( "Attempting to insert two rows into questions table" );

        String query1 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( 'what is the pokemon that is yellow and black', 'pikachu' )";
        String query2 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( 'what is the only other name I remember', 'Charizard' )";
        String query3 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '3', 'pikachu' )";
        String query4 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '4', 'Charizard' )";
        String query5 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '5', 'pikachu' )";
        String query6 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '6', 'Charizard' )";
        String query7 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '7', 'pikachu' )";
        String query8 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '8', 'Charizard' )";
        String query9 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '9', 'pikachu' )";
        String query10 = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '10', 'Charizard' )";

        try (Connection conn = myDs.getConnection();
             Statement stmt = conn.createStatement(); ) {
            int rv = stmt.executeUpdate( query1 );
            System.out.println( "1st executeUpdate() returned " + rv );

            rv = stmt.executeUpdate( query2 );
            System.out.println( "2nd executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query3 );
            System.out.println( "3rd executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query4 );
            System.out.println( "4th executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query5 );
            System.out.println( "5th executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query6 );
            System.out.println( "6th executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query7 );
            System.out.println( "7th executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query8 );
            System.out.println( "8th executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query9 );
            System.out.println( "9th executeUpdate() returned " + rv );
            rv = stmt.executeUpdate( query10 );
            System.out.println( "10th executeUpdate() returned " + rv );

        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
}
