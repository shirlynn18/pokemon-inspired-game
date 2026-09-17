public class FireDefense {
    private String type;
    private double resistanceMultiplier;
    private double vulnerabilityMultiplier;
    private int health;
    private int flameLevel;
    
    public FireDefense() {
        this.type = "Fire";
        this.resistanceMultiplier = 0.5;
        this.vulnerabilityMultiplier = 2.0;
        this.health = 100;
        this.flameLevel = 1;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public double getResistanceMultiplier() {
        return resistanceMultiplier;
    }
    
    public void setResistanceMultiplier(double resistanceMultiplier) {
        this.resistanceMultiplier = resistanceMultiplier;
    }
    
    public double getVulnerabilityMultiplier() {
        return vulnerabilityMultiplier;
    }
    
    public void setVulnerabilityMultiplier(double vulnerabilityMultiplier) {
        this.vulnerabilityMultiplier = vulnerabilityMultiplier;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getFlameLevel() {
        return flameLevel;
    }
    
    public void setFlameLevel(int flameLevel) {
        this.flameLevel = flameLevel;
    }
    
    public void attack(Pokemon target) {
        System.out.println("Fire defense attacks with flame level " + flameLevel);
    }
    
    public double calculateResistanceAgainst(AttackMode attack) {
        String attackType = attack.getType();
        
        // fire is weak to water
        if (attackType.equals("Water")) {
            return vulnerabilityMultiplier;
        }
        // fire is resistant to grass
        else if (attackType.equals("Grass")) {
            return resistanceMultiplier;
        }
        // fire is weak to electric
        else if (attackType.equals("Electric")) {
            return vulnerabilityMultiplier;
        }
        else {
            return 1.0;
        }
    }
} 