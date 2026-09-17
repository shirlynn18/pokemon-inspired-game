import java.util.List;

public class WaterPokemon extends Pokemon {
	
	// attributes
	private double waterPressure;
    private int speed;
    private double energy;
    
    // constructors
    public WaterPokemon() {
        super();
        this.waterPressure = 0.0;
        this.speed = 0;
        this.energy = 0.0;
    }
    
    public WaterPokemon(String name, String description, Stats baseStats, List<Skill> availableSkills, int baseCatchRate, double waterPressure, int speed, double energy) {
		super(name, "Water", description, baseStats, availableSkills, baseCatchRate);
		this.waterPressure = waterPressure;
		this.speed = speed;
		this.energy = energy;
	}
    
    // getters and setters
    @Override
    public String getType() {
        return "Water";
    }
    
    public double getWaterPressure() {
        return waterPressure;
    }

    public void setWaterPressure(double waterPressure) {
        this.waterPressure = waterPressure;
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
    public void tsunamiWave() {
        System.out.println(getName() + " unleashes a massive tsunami wave with pressure " + waterPressure + "!");
    }
    
    // toString
	@Override
	public String toString() {
		return String.format("WaterPokemon [%s, waterPressure=%s, speed=%s, energy=%s]", super.toString(), getWaterPressure(), getSpeed(), getEnergy());
	}    

}
