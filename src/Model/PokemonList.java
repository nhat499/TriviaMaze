/**
 * Used for creating an ArrayList of first generation Pokemon.
 * Created for development purposes.
 */

package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PokemonList {
    private final String myPokeString = "Bulbasaur,Ivysaur,Venusaur,Charmander,Charmeleon,Charizard,Squirtle," +
            "Wartortle,Blastoise,Caterpie,Metapod,Butterfree,Weedle,Kakuna,Beedrill,Pidgey," +
            "Pidgeotto,Pidgeot,Rattata,Raticate,Spearow,Fearow,Ekans,Arbok,Pikachu,Raichu," +
            "Sandshrew,Sandslash,Nidoran,Nidorina,Nidoqueen,Nidorino,Nidoking,Clefairy," +
            "Clefable,Vulpix,Ninetales,Jigglypuff,Wigglytuff,Zubat,Golbat,Oddish,Gloom," +
            "Vileplume,Paras,Parasect,Venonat,Venomoth,Diglett,Dugtrio,Meowth,Persian," +
            "Psyduck,Golduck,Mankey,Primeape,Growlithe,Arcanine,Poliwag,Poliwhirl,Poliwrath," +
            "Abra,Kadabra,Alakazam,Machop,Machoke,Machamp,Bellsprout,Weepinbell,Victreebel," +
            "Tentacool,Tentacruel,Geodude,Graveler,Golem,Ponyta,Rapidash,Slowpoke,Slowbro," +
            "Magnemite,Magneton,Farfetch’d,Doduo,Dodrio,Seel,Dewgong,Grimer,Muk,Shellder," +
            "Cloyster,Gastly,Haunter,Gengar,Onix,Drowzee,Hypno,Krabby,Kingler,Voltorb" +
            "Electrode,Exeggcute,Exeggutor,Cubone,Marowak,Hitmonlee,Hitmonchan,Lickitung," +
            "Koffing,Weezing,Rhyhorn,Rhydon,Chansey,Tangela,Kangaskhan,Horsea,Seadra," +
            "Goldeen,Seaking,Staryu,Starmie,Mr-Mime,Scyther,Jynx,Electabuzz,Magmar,Pinsir," +
            "Tauros,Magikarp,Gyarados,Lapras,Ditto,Eevee,Vaporeon,Jolteon,Flareon,Porygon," +
            "Omanyte,Omastar,Kabuto,Kabutops,Aerodactyl,Snorlax,Articuno,Zapdos,Moltres," +
            "Dratini,Dragonair,Dragonite,Mewtwo,Mew";

    private final Scanner myScanner;

    private final Scanner myScanner2;

    private final ArrayList<String> myPokeList;

    private final ArrayList<String> myRandomPokeList;

    /**
     * Public constructor for PokemonList.
     */
    public PokemonList() {
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
     * Randomly shuffles the existing ArrayList<String> of Pokemon.
     * @return ArrayList<String>
     */
    public ArrayList<String> getRandomPokeList() {
        Collections.shuffle(myRandomPokeList);
        return myRandomPokeList;
    }

    /**
     * Returns an alphabetically sorted list of first generation Pokemon.
     * @return ArrayList<String>
     */
    public ArrayList<String> getSortedPokeList() {
        Collections.sort(myPokeList);
        return (myPokeList);
    }

    public static void main(String[] theArgs) {
        PokemonList p = new PokemonList();

    }
}
