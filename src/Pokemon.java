import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	
	// attributes
	private String name;
    private String type;
    private String description;
    private Stats baseStats;
    private List<Skill> availableSkills;
    private int baseCatchRate;
	
    // constructors
    public Pokemon() {
        this.name = "";
        this.type = "";
        this.description = "";
        this.baseStats = new Stats();
        this.availableSkills = new ArrayList<>();
        this.baseCatchRate = 0;
    }

	public Pokemon(String name, String type, String description, Stats baseStats, List<Skill> availableSkills, int baseCatchRate) {
		this.name = name;
		this.type = type;
		this.description = description;
		this.baseStats = baseStats;
		this.availableSkills = availableSkills;
		this.baseCatchRate = baseCatchRate;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Stats getBaseStats() {
		return baseStats;
	}

	public void setBaseStats(Stats baseStats) {
		this.baseStats = baseStats;
	}

	public List<Skill> getAvailableSkills() {
		return availableSkills;
	}

	public void setAvailableSkills(List<Skill> availableSkills) {
		this.availableSkills = availableSkills;
	}

	public int getBaseCatchRate() {
		return baseCatchRate;
	}

	public void setBaseCatchRate(int baseCatchRate) {
		this.baseCatchRate = baseCatchRate;
	}

	// toString
	@Override
	public String toString() {
		return String.format("name=%s, type=%s, description=%s, baseStats=%s, availableSkills=%s, baseCatchRate=%d",
		        			  getName(), getType(), getDescription(), getBaseStats(), getAvailableSkills(), getBaseCatchRate());
	}

}
