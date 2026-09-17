import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<GaoleDisk> disks;
    private List<Medal> medal;
    private List<Pokemon> caughtPokemon;
    private int score;
    private int health;
    
    private static final Scanner scanner = new Scanner(System.in);

    public Player() {
        this.name = "Unknown";
        this.disks = new ArrayList<>();
        this.medal = new ArrayList<>();
        this.caughtPokemon = new ArrayList<>();
        this.score = 0;
        this.health = 100;
    }

    public Player(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GaoleDisk> getDisks() {
        return disks;
    }

    public void addDisk(GaoleDisk disk) {
        disks.add(disk);
    }

    public List<Medal> getMedal() {
        return medal;
    }

    public void addMedal(Medal medal) {
        this.medal.add(medal);
    }

    public List<Pokemon> getCaughtPokemon() {
        return caughtPokemon;
    }

    public void catchPokemon(Pokemon p) {
        caughtPokemon.add(p);
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public void reset() {
        this.health = 100;
    }

    public Skill chooseSkill(Pokemon pokemon) {
        List<Skill> skills = pokemon.getAvailableSkills();
        if (skills == null || skills.isEmpty()) {
            System.out.println(pokemon.getName() + " has no available skills.");
            return null;
        }

        System.out.println("\nChoose a skill for " + pokemon.getName() + ":");
        for (int i = 0; i < skills.size(); i++) {
            System.out.println((i + 1) + ". " + skills.get(i).getName() + " (Power: " + skills.get(i).getPower() + ")");
        }


        int choice = -1;
        while (choice < 1 || choice > skills.size()) {
            System.out.print("Enter choice (1-" + skills.size() + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next();  // Consume invalid input
            }
        }

        return skills.get(choice - 1);
    }

    @Override
    public String toString() {
        return "Player: " + name +
               " | Score: " + score +
               " | Health: " + health +
               " | Disks: " + disks.size() +
               " | Medals: " + medal.size() +
               " | Pokémon: " + caughtPokemon.size();
    }
}
