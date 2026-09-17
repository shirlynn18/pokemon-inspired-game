import java.io.*;
import java.util.*;

public class Game {
    private Player player;
    private BattleManager battleManager;
    private Catch catchManager;
    private BattleScoreSystem scoreSystem;

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SCORE_FILE = "top_scores.txt";
    private static final String CAUGHT_POKEMON_FILE = "caught_pokemon.dat";

    public Game() {
        this.player = new Player();
        this.scoreSystem = new BattleScoreSystem(SCORE_FILE);
        this.catchManager = null;
    }

    public void start() {
        System.out.println("===== Welcome to Pokémon Ga-Olé =====");
        System.out.print("Enter your name: ");
        player.setName(scanner.nextLine());

        boolean playing = true;
        while (playing) {
            int mode = selectMode();
            switch (mode) {
                case 1:
                    Stage stage = selectStage();
                    preBattleCatch(player, stage);
                    startBattle(player, stage);
                    calculateResult();
                    scoreSystem.displayTopScores();
                    saveCaughtPokemonToDisk();
                    break;
                case 2:
                    scoreSystem.displayTopScores();
                    break;
                case 0:
                    System.out.println("Thank you for playing!");
                    playing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public int selectMode() {
        System.out.println("\nSelect Mode:");
        System.out.println("1. Battle and Catch");
        System.out.println("2. View Top Scores");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Stage selectStage() {
        System.out.println("\nSelect Stage:");
        Stage stage = new Stage("Forest Stage", new ArrayList<>());
        stage.generateWildPokemon(1);

        System.out.println("Stage selected: " + stage.getName());
        System.out.println("Wild Pokémon in this stage:");
        int index = 1;
        for (Pokemon p : stage.getWildPokemons()) {
            System.out.println(index++ + ". " + p.getName());
        }
        return stage;
    }

    public void preBattleCatch(Player player, Stage stage) {
        System.out.println("\n--- Pre-Battle Catch ---");
        List<Pokemon> wild = stage.getWildPokemons();
        for (int i = 0; i < wild.size(); i++) {
            System.out.println((i + 1) + ". " + wild.get(i).getName());
        }
        System.out.print("Select a Pokémon to try to catch (1-" + wild.size() + "): ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice >= 0 && choice < wild.size()) {
            Pokemon chosen = wild.get(choice);
            PokemonBall ball = chooseBallType();
            catchManager = new Catch(chosen, ball); // assign to field
            if (catchManager.attemptCatch()) {
                player.catchPokemon(chosen);
                player.addDisk(new GaoleDisk(
                        "PLAYER", chosen, chosen.getType(), chosen.getType(),
                        "", 0, "C", chosen.getBaseStats(), chosen.getAvailableSkills()
                ));
            }
        }
    }

    public void startBattle(Player player, Stage stage) {
        System.out.println("\n--- Battle Start ---");

        // Ensure player has at least 1 Pokémon to battle with
        if (player.getDisks().isEmpty()) {
            System.out.println("You have no Pokémon to battle with! You will be given one from the stage.");
            Pokemon starter = stage.getWildPokemons().get(0); // Take first wild Pokémon
            player.addDisk(new GaoleDisk(
                "TEMP",
                starter,
                starter.getType(),
                starter.getType(),
                "",
                0,
                "C",
                starter.getBaseStats(),
                starter.getAvailableSkills()
            ));
        }

        // Let the player choose up to 2 Pokémon from their disks
        List<GaoleDisk> chosenDisks = new ArrayList<>();
        System.out.println("\n--- Choose up to 2 Pokémon to send into battle ---");
        for (int i = 0; i < player.getDisks().size(); i++) {
            System.out.println((i + 1) + ". " + player.getDisks().get(i).getPokemon().getName());
        }

        for (int i = 0; i < 2; i++) {
            System.out.print("Select Pokémon #" + (i + 1) + " (or 0 to stop choosing): ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) break;
            if (choice > 0 && choice <= player.getDisks().size()) {
                chosenDisks.add(player.getDisks().get(choice - 1));
            }
        }

        // Create enemy trainer with all wild Pokémon from stage
        Player enemy = new Player("Wild Trainer");
        for (Pokemon p : stage.getWildPokemons()) {
            enemy.addDisk(new GaoleDisk(
                "WILD",
                p,
                p.getType(),
                p.getType(),
                "",
                0,
                "C",
                p.getBaseStats(),
                p.getAvailableSkills()
            ));
        }

        // Replace player's disks with chosen ones for this battle
        player.getDisks().clear();
        player.getDisks().addAll(chosenDisks);

        // Start the battle
        battleManager = new BattleManager(player, enemy, scoreSystem);
        battleManager.startBattle();

        // Catch defeated enemy Pokémon
        List<Pokemon> defeated = new ArrayList<>();
        for (GaoleDisk disk : enemy.getDisks()) {
            if (disk.getPokemon().getBaseStats().getHp() <= 0) {
                defeated.add(disk.getPokemon());
            }
        }
        if (!defeated.isEmpty()) {
            catchTime(player, defeated);
        }
    }

    public void catchTime(Player player, List<Pokemon> wild) {
        System.out.println("\n--- Catch Time ---");
        for (Pokemon p : wild) {
            System.out.println("Attempting to catch " + p.getName() + "...");
            PokemonBall ball = chooseBallType();
            catchManager = new Catch(p, ball); // assign to field
            if (catchManager.attemptCatch()) {
                player.catchPokemon(p);
                player.addDisk(new GaoleDisk(
                        "PLAYER", p, p.getType(), p.getType(),
                        "", 0, "C", p.getBaseStats(), p.getAvailableSkills()
                ));
            }
        }
    }

    public void calculateResult() {
        System.out.println("\nYour final score: " + player.getScore());
        scoreSystem.saveScore(player.getName(), player.getScore());
    }

    public void saveCaughtPokemonToDisk() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAUGHT_POKEMON_FILE))) {
            oos.writeObject(player.getCaughtPokemon());
            System.out.println("Caught Pokémon saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving caught Pokémon: " + e.getMessage());
        }
    }

    private PokemonBall chooseBallType() {
        System.out.println("Choose a Poké Ball:");
        System.out.println("1. Poké Ball");
        System.out.println("2. Great Ball");
        System.out.println("3. Ultra Ball");
        System.out.println("4. Master Ball");
        System.out.print("Enter choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 2: return new PokemonBall("Great Ball", 1.5);
            case 3: return new PokemonBall("Ultra Ball", 2.0);
            case 4: return new PokemonBall("Master Ball", 255.0);
            default: return new PokemonBall("Poké Ball", 1.0);
        }
    }
}
