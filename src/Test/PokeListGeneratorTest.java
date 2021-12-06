package Test;

import Model.Door;
import Model.PokeListGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for Door class.
 * @author Dylan
 * @version 12/5/2021
 */
public class PokeListGeneratorTest {

    PokeListGenerator myListGen;
    ArrayList<String> myList;
    ArrayList<String> mySortedList;
    ArrayList<String> myShuffledList;

    @BeforeEach
    void setup() {
        myListGen = new PokeListGenerator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ParameterlessConstructorTest(){
        assertNotNull(myListGen, "myListGen is Null!");
    }

    @Test
    void GetSortedListTest(){
        // Must temporarily make field "myPokeList" in PokeListGenerator class public visibility for this test to work.
//        ArrayList<String> list = myListGen.myPokeList;
//        Collections.sort(list);
//        ArrayList<String> list2 = myListGen.getSortedPokeList();
//
//        for (int i = 0; i < list.size(); i++) {
//            assertEquals(list.get(i), list2.get(i), list.get(i) + "!= " + list2.get(i));
//        }
    }

    @Test
    void GetRandomListTest(){
        // Must temporarily make field "myPokeList" in PokeListGenerator class public visibility for this test to work.
//        ArrayList<String> list = myListGen.myPokeList;
//        ArrayList<String> list2 = myListGen.getRandomPokeList();
//
//        for (String poke : list) {
//            assertTrue(list2.contains(poke), "Random list does not contain pokemon: " + poke);
//        }
    }

    @Test
    void GetSomeRandomTest(){
        // Must temporarily make field "myPokeList" in PokeListGenerator class public visibility for this test to work.
//        ArrayList<String> list = myListGen.myPokeList;
//
//        for (int i = 0; i < 1000; i++) {
//            String[] s = myListGen.getSomeRandomPokemon("charizard");
//            assertTrue(list.contains(s[0]));
//            assertTrue(list.contains(s[1]));
//            assertTrue(list.contains(s[2]));
//            assertNotEquals("charizard", s[0], "Charizard in list twice.");
//            assertNotEquals("charizard", s[1], "Charizard in list twice.");
//            assertNotEquals("charizard", s[2], "Charizard in list twice.");
//        }
    }
}
