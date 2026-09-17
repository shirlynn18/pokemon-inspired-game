public class ElectricAttack extends AttackMode {
    
    @Override
    public String getType() {
        return "Electric";
    }
    
    @Override
    public double calculateDamageAgainst(DefenseMode defense) {
        switch (defense) {
            case WATER:
                return 2.0; // super effective against Water
            case GRASS:
                return 0.5; // less effective against Grass
            case FIRE:
            default:
                return 1.0;
        }
    }
} 