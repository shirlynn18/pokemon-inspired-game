public class Skill {
    private String name;
    private int power;
    private int accuracy;
    private AttackMode attackMode;
    private DefenseMode defenseMode;
    private String effect;
    
    // default constructor
    public Skill() {}
    
    // full constructor
    public Skill(String name, int power, int accuracy, String effect) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.effect = effect;
    }
    
    // getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPower() {
        return power;
    }
    
    public void setPower(int power) {
        this.power = power;
    }
    
    public int getAccuracy() {
        return accuracy;
    }
    
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    
    public AttackMode getAttackMode() {
        return attackMode;
    }
    
    public void setAttackMode(AttackMode attackMode) {
        this.attackMode = attackMode;
    }
    
    public DefenseMode getDefenseMode() {
        return defenseMode;
    }
    
    public void setDefenseMode(DefenseMode defenseMode) {
        this.defenseMode = defenseMode;
    }
    
    public String getEffect() {
        return effect;
    }
    
    public void setEffect(String effect) {
        this.effect = effect;
    }
    
    // activate the skill
    public void activate(GaoleDisk user, GaoleDisk target) {
        System.out.println(user.getPokemon().getName() + " uses " + name + "!");
        System.out.println("Power: " + power + ", Accuracy: " + accuracy + ", Effect: " + effect);
        
        if (attackMode != null) {
            double damage = attackMode.calculateDamageAgainst(target.getDefenseMode());
            int finalDamage = (int) (power * damage);
            target.receiveDamage(finalDamage);
        }
    }
    
    @Override
    public String toString() {
        return name + " - Power: " + power + ", Accuracy: " + accuracy + ", Effect: " + effect;
    }
} 