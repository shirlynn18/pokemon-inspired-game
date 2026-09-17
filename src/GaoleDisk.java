import java.util.List;

public class GaoleDisk {
	private String collectionNumber;
	private Pokemon pokemon;
	private String pokemonType;
	private String moveType;
	private String zMove;
	private int pokeEnergy;
	private String grade;
	private Stats stats;
	private List<Skill> skills;
	private boolean available;
	
	//default constructor
	public GaoleDisk() {}
	
	//full constructor
	public GaoleDisk(String collectionNumber, Pokemon pokemon, String pokemonType, String moveType, String zMove, int pokeEnergy, String grade, Stats stats, List<Skill> skills) {
		this.collectionNumber = collectionNumber;
		this.pokemon = pokemon;
		this.pokemonType = pokemonType;
		this.moveType = moveType;
		this.zMove = zMove;
		this.pokeEnergy = pokeEnergy;
		this.grade = grade;
		this.stats = stats;
		this.skills = skills;
		this.available = true;
		}
		
	// getters and setters
	public String getCollectionNumber() { 
		return collectionNumber; 
	}
	
	public void setCollectionNumber(String collectionNumber) { 
		this.collectionNumber = collectionNumber; 
	}
	
	public Pokemon getPokemon() { 
		return pokemon; 
	}
	
	public void setPokemon(Pokemon pokemon) { 
		this.pokemon = pokemon; 
	}
	
	public String getPokemonType() { 
		return pokemonType; 
	}
	
	public void setPokemonType(String pokemonType) { 
		this.pokemonType = pokemonType; 
	}
	
	public String getMoveType() { 
		return moveType; 
	}
	
	public void setMoveType(String moveType) { 
		this.moveType = moveType; 
	}
	
	public String getZMove() { 
		return zMove; 
	}
	
	public void setZMove(String zMove) { 
		this.zMove = zMove; 
	}
	
	public int getPokeEnergy() { 
		return pokeEnergy; 
	}
	
	public void setPokeEnergy(int pokeEnergy) { 
		this.pokeEnergy = pokeEnergy; 
	}
	
	public String getGrade() { 
		return grade; 
	}
	
	public void setGrade(String grade) { 
		this.grade = grade; 
	}
	
	public Stats getStats() { 
		return stats; 
	}
	
	public void setStats(Stats stats) { 
		this.stats = stats; 
	}
	
	public List<Skill> getSkills() { 
		return skills; 
	}
	
	public void setSkills(List<Skill> skills) { 
		this.skills = skills; 
	}
	
	public void attack(GaoleDisk target) {
		int attackPower = this.stats.getAttack(); 
		System.out.println(this.pokemon.getName() + " attacks " + target.getPokemon().getName());
		target.receiveDamage(attackPower);
	}
	
	public void useSkill(int index, GaoleDisk target) {
		if (index >= 0 && index < skills.size()) {
			Skill skill = skills.get(index);
			System.out.println(pokemon.getName() + " uses " + skill.getName() + "!");
			skill.activate(this, target);
		} 
		else {
			System.out.println("Invalid skill index.");
		}
	}
	
	public void receiveDamage(int amount) {
		this.stats.receiveDamage(amount); 
		if (stats.getHp() <= 0) {
			available = false;
			System.out.println(pokemon.getName() + " is knocked out!");
		}
	}
	
	public boolean isAvailable() {
		return available;
	}
	
	public DefenseMode getDefenseMode() {
		// convert pokemonType string to DefenseMode enum
		switch (pokemonType.toLowerCase()) {
			case "fire":
				return DefenseMode.FIRE;
			case "water":
				return DefenseMode.WATER;
			case "grass":
				return DefenseMode.GRASS;
			case "electric":
				return DefenseMode.ELECTRIC;
			default:
				return DefenseMode.FIRE;
		}
	}
	
	@Override
	public String toString() {
		return "[" + collectionNumber + "] " + pokemon.getName() + " (" + grade + ")";
	}
}
