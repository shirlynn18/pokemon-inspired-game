import java.util.List;

public class FirePokemon extends Pokemon {
	
	// attributes
    private double flamePower;
    private int speed;
    private double energy;
    
    // constructors
    public FirePokemon() {
        super();
        this.flamePower = 0.0;
        this.speed = 0;
        this.energy = 0.0;
    }
    
    public FirePokemon(String name, String description, Stats baseStats, List<Skill> availableSkills, int baseCatchRate, double flamePower, int speed, double energy) {
		super(name, "Fire", description, baseStats, availableSkills, baseCatchRate);
		this.flamePower = flamePower;
		this.speed = speed;
		this.energy = energy;
	}

    // getters and setters
    @Override
    public String getType() {
        return "Fire";
    }
    
    public double getFlamePower() {
        return flamePower;
    }

    public void setFlamePower(double flamePower) {
        this.flamePower = flamePower;
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

    // other method
    public void specialFlameAttack() {
        System.out.println(getName() + " unleashes a blazing flame attack with power " + flamePower + "!");
    }
    
    // toString
	@Override
	public String toString() {
		return String.format("FirePokemon [%s, flamePower=%s, speed=%s, energy=%s]", super.toString(), getFlamePower(), getSpeed(), getEnergy());
	}

}
