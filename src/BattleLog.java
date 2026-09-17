import java.util.ArrayList;
import java.util.List;

public class BattleLog {
    private List<String> entries;

    public BattleLog() {
        this.entries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        entries.add(entry);
    }

    public List<String> getHistory() {
        // Return a copy to prevent external modification
        return new ArrayList<>(entries);
    }

    public void clear() {
        entries.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== BATTLE LOG ===\n");
        for (String entry : entries) {
            sb.append(entry).append("\n");
        }
        sb.append("==================");
        return sb.toString();
    }
}