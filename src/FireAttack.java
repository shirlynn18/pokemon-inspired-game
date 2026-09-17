public class FireAttack extends AttackMode {
    
    @Override
    public String getType() {
        return "Fire";
    }
    
    @Override
    public double calculateDamageAgainst(DefenseMode defense) {
        switch (defense) {
            case GRASS:
                return 2.0; // super effective against grass
            case WATER:
                return 0.5; // less effective against water
            case FIRE:
                return 0.5; // less effective against fire
            case ELECTRIC:
            default:
                return 1.0;
        }
    }
} 