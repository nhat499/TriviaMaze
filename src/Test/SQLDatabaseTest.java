package Test;

import Model.PokeListGenerator;
import Model.SQLDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for SQLDatabase class.
 * @author Dylan
 * @version 12/5/2021
 */
public class SQLDatabaseTest {

    SQLDatabase myDB;

    @BeforeEach
    void setup() {
        myDB = new SQLDatabase();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ConstructorTest() {
        assertNotNull(myDB, "SQLDatabase is Null!");
    }

    @Test
    void GetQuestionsFromDatabaseTest() {
        ArrayList<String> pokeList = new PokeListGenerator().getSortedPokeList();
        String[] s;
        for (String poke : pokeList) {
            s = myDB.getQuestionsFromDB(poke);
            assertEquals(poke, s[0], "Incorrect primary key!");
            assertNotEquals(poke, s[1], "Duplicate answer!");
            assertNotEquals(poke, s[2], "Duplicate answer!");
            assertNotEquals(poke, s[3], "Duplicate answer!");
        }
    }



}
