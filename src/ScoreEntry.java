public class ScoreEntry implements Comparable<ScoreEntry> {
    private String username;
    private int score;

    public ScoreEntry(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(ScoreEntry other) {
        // Sort by highest score first (descending order)
        return Integer.compare(other.score, this.score);
    }

    @Override
    public String toString() {
        return username + ": " + score;
    }
}