import java.util.List;

public class GrassPokemon extends Pokemon {
	
	// attributes
	private double leafSharpness;
    private int speed;
    private double energy;
    
    // constructors
    public GrassPokemon() {
        super();
        this.leafSharpness = 0.0;
        this.speed = 0;
        this.energy = 0.0;
    }
    
    public GrassPokemon(String name, String description, Stats baseStats, List<Skill> availableSkills, int baseCatchRate, double leafSharpness, int speed, double energy) {
		super(name, "Grass", description, baseStats, availableSkills, baseCatchRate);
		this.leafSharpness = leafSharpness;
		this.speed = speed;
		this.energy = energy;
	}
    
    // getters and setters
    @Override
    public String getType() {
        return "Grass";
    }
    
    public double getLeafSharpness() {
        return leafSharpness;
    }

    public void setLeafSharpness(double leafSharpness) {
        this.leafSharpness = leafSharpness;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
    
    // other methods
    public void vineWhip() {
        System.out.println(getName() + " uses Vine Whip with sharpness " + leafSharpness + "!");
    }

    // toString
	@Override
	public String toString() {
		return String.format("GrassPokemon [%s, leafSharpness=%s, speed=%s, energy=%s]", super.toString(), getLeafSharpness(), getSpeed(), getEnergy());
	}
    
}
