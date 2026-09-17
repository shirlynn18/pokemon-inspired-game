import java.util.List;
import java.util.ArrayList;

public class Medal {
    private String name;
    private String description;
    private Player player;
    private List<Pokemon> wildPokemons;

    public Medal(String name, String description) {
        this.name = name;
        this.description = description;
        this.player = null;
        this.wildPokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Pokemon> getWildPokemons() {
        return wildPokemons;
    }

    public void setWildPokemons(List<Pokemon> pokemons) {
        this.wildPokemons = pokemons;
    }

    public void addWildPokemon(Pokemon pokemon) {
        wildPokemons.add(pokemon);
    }
}