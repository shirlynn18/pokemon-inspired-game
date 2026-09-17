import java.io.*;
import java.util.*;

public class BattleScoreSystem {
    private List<ScoreEntry> topScores;
    private String filePath;

    public BattleScoreSystem(String filePath) {
        this.filePath = filePath;
        this.topScores = new ArrayList<>();
        loadTopScores();
    }

    public int calculateScore(GaoleDisk playerDisk, int defeatedEnemies, int turnsTaken) {
        int baseScore = defeatedEnemies * 100;
        int diskBonus = playerDisk.getPokemon().getBaseStats().getPower() / 10; 
        int timePenalty = turnsTaken * 5;
        
        int finalScore = baseScore + diskBonus - timePenalty;
        return Math.max(finalScore, 0);  // Ensure score doesn't go negative
    }

    public void saveScore(String username, int score) {
        topScores.add(new ScoreEntry(username, score));
        Collections.sort(topScores);  // Sort descending (highest first)
        
        // Keep only top 10 scores
        if (topScores.size() > 10) {
            topScores = new ArrayList<>(topScores.subList(0, 10));
        }
        
        saveToFile();
    }

    public void loadTopScores() {
        topScores.clear();
        File file = new File(filePath);
        
        if (!file.exists()) {
            return;  // No file to load
        }
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length == 2) {
                    String username = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    topScores.add(new ScoreEntry(username, score));
                }
            }
            Collections.sort(topScores);
        } catch (FileNotFoundException e) {
            System.err.println("Error loading scores: " + e.getMessage());
        }
    }

    public List<ScoreEntry> getTopScores() {
        return Collections.unmodifiableList(topScores);  // Prevent external modification
    }

    public void displayTopScores() {
        System.out.println("\n=== TOP SCORES ===");
        if (topScores.isEmpty()) {
            System.out.println("No scores recorded yet!");
            return;
        }
        
        for (int i = 0; i < topScores.size(); i++) {
            ScoreEntry entry = topScores.get(i);
            System.out.println((i + 1) + ". " + entry.getUsername() + " - " + entry.getScore());
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (ScoreEntry entry : topScores) {
                writer.println(entry.getUsername() + "," + entry.getScore());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error saving scores: " + e.getMessage());
        }
    }
}