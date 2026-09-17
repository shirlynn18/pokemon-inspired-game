public class WaterAttack extends AttackMode {
    
    @Override
    public String getType() {
        return "Water";
    }
    
    @Override
    public double calculateDamageAgainst(DefenseMode defense) {
        switch (defense) {
            case FIRE:
                return 2.0; // super effective against fire
            case GRASS:
                return 0.5; // less effective against grass
            case WATER:
                return 0.5; // less effective against water
            case ELECTRIC:
            default:
                return 1.0;
        }
    }
} 