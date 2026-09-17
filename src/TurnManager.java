public class TurnManager {
    private GaoleDisk currentAttacker;
    private GaoleDisk currentDefender;

    // Constructor
    public TurnManager(GaoleDisk attacker, GaoleDisk defender) {
        this.currentAttacker = attacker;
        this.currentDefender = defender;
    }

    // Determine the next turn based on the selected skills
    public void decideNext(Skill attackerSkill, Skill defenderSkill) {
        // Example logic: The skill with higher power gets to attack first
        if (attackerSkill.getPower() < defenderSkill.getPower()) {
            swapRoles();
        }
    }

    // Swap attacker and defender roles
    public void swapRoles() {
        GaoleDisk temp = currentAttacker;
        currentAttacker = currentDefender;
        currentDefender = temp;
    }

    // Getters and Setters
    public GaoleDisk getCurrentAttacker() {
        return currentAttacker;
    }

    public void setCurrentAttacker(GaoleDisk attacker) {
        this.currentAttacker = attacker;
    }

    public GaoleDisk getCurrentDefender() {
        return currentDefender;
    }

    public void setCurrentDefender(GaoleDisk defender) {
        this.currentDefender = defender;
    }

    @Override
    public String toString() {
        return "TurnManager{" +
                "currentAttacker=" + currentAttacker +
                ", currentDefender=" + currentDefender +
                '}';
    }
}
