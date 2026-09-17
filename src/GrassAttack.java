public class GrassAttack extends AttackMode {
    
    @Override
    public String getType() {
        return "Grass";
    }
    
    @Override
    public double calculateDamageAgainst(DefenseMode defense) {
        switch (defense) {
            case WATER:
                return 2.0; // super effective against water
            case FIRE:
                return 0.5; // less effective against fire
            case GRASS:
                return 0.5; // less effective against grass
            case ELECTRIC:
            default:
                return 1.0; 
        }
    }
} 