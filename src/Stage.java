import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Stage {

    // attributes
    private String name;
    private List<Pokemon> wildPokemons;

    // constructor
    public Stage(String name, List<Pokemon> wildPokemons) {
        this.name = name;
        this.wildPokemons = wildPokemons != null ? wildPokemons : new ArrayList<>();
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getWildPokemons() {
        return wildPokemons;
    }

    public void setWildPokemons(List<Pokemon> pokemons) {
        this.wildPokemons = pokemons;
    }

    public void addWildPokemon(Pokemon pokemon) {
        if (pokemon != null) {
            this.wildPokemons.add(pokemon);
        }
    }

    public void generateWildPokemon(int playerLevel) {
        // Create a Pokedex and get all Pokémon
        Pokedex pokedex = new Pokedex();
        List<Pokemon> allPokemon = new ArrayList<>(pokedex.getAllPokemon());

        // Shuffle to randomize order
        Collections.shuffle(allPokemon);

        // Clear previous list and add first 3 Pokémon
        wildPokemons.clear();
        for (int i = 0; i < 3 && i < allPokemon.size(); i++) {
            wildPokemons.add(allPokemon.get(i));
        }
    }
}
