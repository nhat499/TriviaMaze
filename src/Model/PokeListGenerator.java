/**
 * Creates and maintains ordered and random Arraylists of pokemon names.
 */

package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Dylan
 * @version 11/19/2021
 * This class creates and maintains ordered and random Arraylists of first generation Pokemon.
 */
public class PokeListGenerator implements Serializable {

    /**
     * String containing the names of all first generation Pokemon.
     */
    private final String myPokeString = "Bulbasaur,Ivysaur,Venusaur,Charmander,Charmeleon,Charizard,Squirtle," +
            "Wartortle,Blastoise,Caterpie,Metapod,Butterfree,Weedle,Kakuna,Beedrill,Pidgey," +
            "Pidgeotto,Pidgeot,Rattata,Raticate,Spearow,Fearow,Ekans,Arbok,Pikachu,Raichu," +
            "Sandshrew,Sandslash,Nidoran,Nidorina,Nidoqueen,Nidorino,Nidoking,Clefairy," +
            "Clefable,Vulpix,Ninetales,Jigglypuff,Wigglytuff,Zubat,Golbat,Oddish,Gloom," +
            "Vileplume,Paras,Parasect,Venonat,Venomoth,Diglett,Dugtrio,Meowth,Persian," +
            "Psyduck,Golduck,Mankey,Primeape,Growlithe,Arcanine,Poliwag,Poliwhirl,Poliwrath," +
            "Abra,Kadabra,Alakazam,Machop,Machoke,Machamp,Bellsprout,Weepinbell,Victreebel," +
            "Tentacool,Tentacruel,Geodude,Graveler,Golem,Ponyta,Rapidash,Slowpoke,Slowbro," +
            "Magnemite,Magneton,Farfetchd,Doduo,Dodrio,Seel,Dewgong,Grimer,Muk,Shellder," +
            "Cloyster,Gastly,Haunter,Gengar,Onix,Drowzee,Hypno,Krabby,Kingler,Voltorb," +
            "Electrode,Exeggcute,Exeggutor,Cubone,Marowak,Hitmonlee,Hitmonchan,Lickitung," +
            "Koffing,Weezing,Rhyhorn,Rhydon,Chansey,Tangela,Kangaskhan,Horsea,Seadra," +
            "Goldeen,Seaking,Staryu,Starmie,Mr-Mime,Scyther,Jynx,Electabuzz,Magmar,Pinsir," +
            "Tauros,Magikarp,Gyarados,Lapras,Ditto,Eevee,Vaporeon,Jolteon,Flareon,Porygon," +
            "Omanyte,Omastar,Kabuto,Kabutops,Aerodactyl,Snorlax,Articuno,Zapdos,Moltres," +
            "Dratini,Dragonair,Dragonite,Mewtwo,Mew";

    /**
     * Scanner used to create an ordered ArrayList of Pokemon names.
     */
    private transient final Scanner myScanner;

    /**
     * Additional scanner used to create a randomized Arraylist of Pokemon names.
     */
    private transient final Scanner myScanner2;

    /**
     * Ordered Arraylist of first generation Pokemon names.
     */
    private final ArrayList<String> myPokeList;

    /**
     * Randomized arraylist of first generation Pokemon names.
     */
    private final ArrayList<String> myRandomPokeList;

    /**
     * Public constructor for PokemonListGenerator.
     */
    public PokeListGenerator() {
        myScanner = new Scanner(myPokeString);
        myScanner.useDelimiter(",");
        myScanner2 = new Scanner(myPokeString);
        myScanner2.useDelimiter(",");
        myPokeList = generatePokeList(myScanner);
        myRandomPokeList = generatePokeList(myScanner2);
    }

    /**
     * Generates an ArrayList of first generation Pokemon. Each element in the array
     * is a String representation of the name of a single Pokemon.
     * @param theScanner
     * @return
     */
    private ArrayList<String> generatePokeList(final Scanner theScanner) {
        final ArrayList<String> pokeList= new ArrayList<>();

        while(theScanner.hasNext()) {
            pokeList.add((theScanner.next().toLowerCase()));
        }
        return pokeList;
    }

    /**
     * A randomly shuffled Arraylist of first generation Pokemon.
     * @return ArrayList<String> of first generation Pokemon.
     */
    public ArrayList<String> getRandomPokeList() {
        Collections.shuffle(myRandomPokeList);
        return myRandomPokeList;
    }

    /**
     * Returns an alphabetically sorted Arraylist of first generation Pokemon.
     * @return ArrayList<String> alphabetically ordered first generation Pokemon.
     */
    public ArrayList<String> getSortedPokeList() {
        Collections.sort(myPokeList);
        return (myPokeList);
    }

    /**
     * Generates a String array of chosen length (thePokeAmount) of random Pokemon
     * names, guaranteed not to include theExcludedPokemon, and guaranteed to produce
     * three unique Pokemon names.
     * @param theExcludedPokemon - the Pokemon not to be included in the list. Assumes
     *                           all lower case input.
     * @return String[] array containing desired number of random Pokemon names.
     */
    public String[] getSomeRandomPokemon(final String theExcludedPokemon) {
        final int totalPokemonCount = 150;
        Random r = new Random();
        String[] output = new String[3];
        String temp = null;
        for (int i = 0; i < 3; i++) {
            while (temp == null || temp.equals(theExcludedPokemon)
                    || temp.equals(output[0]) || temp.equals(output[1]) || temp.equals(output[2])) {
                temp = myRandomPokeList.get(r.nextInt(totalPokemonCount));
            }
            output[i] = temp;
        }
        return output;
    }
}
