
public class PokemonBall {
	
	// attributes
	private String type;
    private double catchRate;
    
    // constructor
    public PokemonBall(String type, double catchRate) {
        this.type = type;
        this.catchRate = catchRate;
    }

    // getters and setters
    public String getType() {
        return type;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(double catchRate) {
        this.catchRate = catchRate;
    }

    // toString
	@Override
	public String toString() {
		return String.format("PokemonBall [type=%s, catchRate=%s]", getType(), getCatchRate());
	}
    
}
