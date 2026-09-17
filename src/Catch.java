import java.util.Random;

public class Catch {
	
	// attributes
    private Pokemon pokemonToCatch;
    private PokemonBall ballType;
    
    // constructor
	public Catch(Pokemon pokemonToCatch, PokemonBall ballType) {
		this.pokemonToCatch = pokemonToCatch;
		this.ballType = ballType;
	}
    
	// getters
	public String getBallType() {
        return ballType.getType();
    }
	
	public double getCatchRate() {
        return pokemonToCatch.getBaseCatchRate() * ballType.getCatchRate();
    }
	
	// other method
	public boolean attemptCatch() {
        double catchRate = getCatchRate();
        Random random = new Random();
        double randomRoll = random.nextDouble() * 100;

        if (randomRoll < catchRate) {
            System.out.println("Caught " + pokemonToCatch.getName() + "!");
            return true;
        } else {
            System.out.println("Failed to catch " + pokemonToCatch.getName() + ".");
            return false;
        }

    }

}
