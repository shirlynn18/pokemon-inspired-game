public abstract class AttackMode {
    
    public abstract String getType();
    
    public abstract double calculateDamageAgainst(DefenseMode defense);
} 