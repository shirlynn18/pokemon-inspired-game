import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pokedex {
	
	// attribute
	private List<Pokemon> pokemonList;
	
	// constructor
	public Pokedex() {
        this.pokemonList = new ArrayList<>();
        initializePokemon();
    }
	
	// add a Pokemon to the list
	public void addPokemon(Pokemon pokemon) {
	    if (!hasPokemon(pokemon.getName())) {
	        pokemonList.add(pokemon);
	    }
	}
    
	// retrieves a Pokemon by its name
    public Pokemon getPokemonByName(String name) {
        for (Pokemon p : pokemonList) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null; // Pokemon not found
    }
    
    // returns the list of all Pokemon in the Pokedex
    public List<Pokemon> getAllPokemon() {
        return pokemonList;
    }
    
    // check if a Pokemon exists in the list
    public boolean hasPokemon(String name) {
        return getPokemonByName(name) != null;
    }
    
    // toString
    @Override
    public String toString() {
        String result = "Pokedex:\n";
        for (Pokemon pokemon : pokemonList) {
            result += pokemon.toString() + "\n";
        }
        return result;
    }
    
    // initialize Pokemon
    private void initializePokemon() {
        // Fire Pokemon
        Skill flameThrower = new Skill("Flame Thrower", 90, 100, "Burns the opponent");
        flameThrower.setAttackMode(new FireAttack());
        flameThrower.setDefenseMode(DefenseMode.FIRE);

        Skill ember = new Skill("Ember", 40, 100, "Small flame attack");
        ember.setAttackMode(new FireAttack());
        ember.setDefenseMode(DefenseMode.FIRE);

        Skill fireSpin = new Skill("Fire Spin", 35, 85, "Traps the opponent");
        fireSpin.setAttackMode(new FireAttack());
        fireSpin.setDefenseMode(DefenseMode.FIRE);

        FirePokemon charmander = new FirePokemon(
            "Charmander",
            "A fire lizard",
            new Stats(39, 39, 52, 43, 60, 50, 65),
            Arrays.asList(flameThrower, ember),
            45,
            1.5,
            65,
            100
        );

        FirePokemon vulpix = new FirePokemon(
            "Vulpix",
            "Fox Pokémon with six tails",
            new Stats(38, 38, 41, 40, 50, 65, 65),
            Arrays.asList(ember, fireSpin),
            50,
            1.2,
            65,
            95
        );

        FirePokemon growlithe = new FirePokemon(
            "Growlithe",
            "Loyal and protective",
            new Stats(55, 55, 70, 45, 70, 50, 60),
            Arrays.asList(flameThrower, fireSpin),
            45,
            1.7,
            60,
            110
        );

        // Water Pokemon
        Skill waterGun = new Skill("Water Gun", 40, 100, "Shoots water");
        waterGun.setAttackMode(new WaterAttack());
        waterGun.setDefenseMode(DefenseMode.WATER);

        Skill bubble = new Skill("Bubble", 30, 100, "Traps and damages");
        bubble.setAttackMode(new WaterAttack());
        bubble.setDefenseMode(DefenseMode.WATER);

        Skill aquaTail = new Skill("Aqua Tail", 90, 90, "Powerful tail attack");
        aquaTail.setAttackMode(new WaterAttack());
        aquaTail.setDefenseMode(DefenseMode.WATER);

        WaterPokemon squirtle = new WaterPokemon(
            "Squirtle",
            "Tiny turtle Pokémon",
            new Stats(44, 44, 48, 65, 50, 64, 43),
            Arrays.asList(waterGun, bubble),
            45,
            1.3,
            43,
            100
        );

        WaterPokemon poliwag = new WaterPokemon(
            "Poliwag",
            "Tadpole Pokémon",
            new Stats(40, 40, 50, 40, 40, 40, 90),
            Arrays.asList(waterGun, aquaTail),
            50,
            1.1,
            90,
            95
        );

        WaterPokemon psyduck = new WaterPokemon(
            "Psyduck",
            "Constant headache Pokémon",
            new Stats(50, 50, 52, 48, 65, 50, 55),
            Arrays.asList(bubble, aquaTail),
            45,
            1.4,
            55,
            105
        );

        // Grass Pokemon
        Skill vineWhip = new Skill("Vine Whip", 45, 100, "Whips opponent with vines");
        vineWhip.setAttackMode(new GrassAttack());
        vineWhip.setDefenseMode(DefenseMode.GRASS);

        Skill razorLeaf = new Skill("Razor Leaf", 55, 95, "Sharp leaves attack");
        razorLeaf.setAttackMode(new GrassAttack());
        razorLeaf.setDefenseMode(DefenseMode.GRASS);

        Skill solarBeam = new Skill("Solar Beam", 120, 100, "Charges sunlight attack");
        solarBeam.setAttackMode(new GrassAttack());
        solarBeam.setDefenseMode(DefenseMode.GRASS);

        GrassPokemon bulbasaur = new GrassPokemon(
            "Bulbasaur",
            "Seed Pokémon",
            new Stats(45, 45, 49, 49, 65, 65, 45),
            Arrays.asList(vineWhip, razorLeaf),
            45,
            1.2,
            45,
            100
        );

        GrassPokemon oddish = new GrassPokemon(
            "Oddish",
            "Weed Pokémon",
            new Stats(45, 45, 50, 55, 75, 65, 30),
            Arrays.asList(vineWhip, solarBeam),
            50,
            1.0,
            30,
            90
        );

        GrassPokemon bellsprout = new GrassPokemon(
            "Bellsprout",
            "Flower Pokémon",
            new Stats(50, 50, 75, 35, 70, 30, 40),
            Arrays.asList(razorLeaf, solarBeam),
            45,
            1.3,
            40,
            95
        );

        // Electric Pokemon
        Skill thunderShock = new Skill("Thunder Shock", 40, 100, "Electric shock attack");
        thunderShock.setAttackMode(new ElectricAttack());
        thunderShock.setDefenseMode(DefenseMode.ELECTRIC);

        Skill spark = new Skill("Spark", 65, 100, "Electric spark attack");
        spark.setAttackMode(new ElectricAttack());
        spark.setDefenseMode(DefenseMode.ELECTRIC);

        Skill thunderbolt = new Skill("Thunderbolt", 90, 100, "Strong electric attack");
        thunderbolt.setAttackMode(new ElectricAttack());
        thunderbolt.setDefenseMode(DefenseMode.ELECTRIC);

        ElectricPokemon pikachu = new ElectricPokemon(
            "Pikachu",
            "Mouse Pokémon",
            new Stats(35, 35, 55, 40, 50, 50, 90),
            Arrays.asList(thunderShock, spark),
            45,
            1.6,
            90,
            120
        );

        ElectricPokemon magnemite = new ElectricPokemon(
            "Magnemite",
            "Magnet Pokémon",
            new Stats(25, 25, 35, 70, 95, 55, 45),
            Arrays.asList(spark, thunderbolt),
            50,
            1.3,
            45,
            110
        );

        ElectricPokemon jolteon = new ElectricPokemon(
            "Jolteon",
            "Lightning Pokémon",
            new Stats(65, 65, 65, 60, 110, 95, 130),
            Arrays.asList(thunderShock, thunderbolt),
            45,
            1.8,
            130,
            130
        );

        // Add all Pokemon to the list
        addPokemon(charmander);
        addPokemon(vulpix);
        addPokemon(growlithe);

        addPokemon(squirtle);
        addPokemon(poliwag);
        addPokemon(psyduck);

        addPokemon(bulbasaur);
        addPokemon(oddish);
        addPokemon(bellsprout);

        addPokemon(pikachu);
        addPokemon(magnemite);
        addPokemon(jolteon);
    }

}
