import java.util.List;

public class ElectricPokemon extends Pokemon {
	
	// attributes
	private double voltageLevel;
    private int speed;
    private double energy;
    
    // constructors
    public ElectricPokemon() {
        super();
        this.voltageLevel = 0.0;
        this.speed = 0;
        this.energy = 0.0;
    }
    
    public ElectricPokemon(String name, String description, Stats baseStats, List<Skill> availableSkills, int baseCatchRate, double voltageLevel, int speed, double energy) {
		super(name, "Electric", description, baseStats, availableSkills, baseCatchRate);
		this.voltageLevel = voltageLevel;
		this.speed = speed;
		this.energy = energy;
	}
    
    // getters and setters
    @Override
    public String getType() {
        return "Electric";
    }
    
    public double getVoltageLevel() {
        return voltageLevel;
    }

    public void setVoltageLevel(double voltageLevel) {
        this.voltageLevel = voltageLevel;
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
    public void thunderStrike() {
        System.out.println(getName() + " uses Thunder Strike with voltage " + voltageLevel + "!");
    }

    // toString
	@Override
	public String toString() {
		return String.format("ElectricPokemon [%s, voltageLevel=%s, speed=%s, energy=%s]", super.toString(), getVoltageLevel(), getSpeed(), getEnergy());
	}

}
