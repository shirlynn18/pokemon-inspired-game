public class GrassDefense {
    private String type;
    private double resistanceMultiplier;
    private double vulnerabilityMultiplier;
    private int health;
    private int leafSharpness;
    
    public GrassDefense() {
        this.type = "Grass";
        this.resistanceMultiplier = 0.5;
        this.vulnerabilityMultiplier = 2.0;
        this.health = 100;
        this.leafSharpness = 1;
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
    
    public int getLeafSharpness() {
        return leafSharpness;
    }
    
    public void setLeafSharpness(int leafSharpness) {
        this.leafSharpness = leafSharpness;
    }
    
    public void attack(Pokemon target) {
        System.out.println("Grass defense attacks with leaf sharpness " + leafSharpness);
    }
    
    public double calculateResistanceAgainst(AttackMode attack) {
        String attackType = attack.getType();
        
        // grass is weak to fire
        if (attackType.equals("Fire")) {
            return vulnerabilityMultiplier;
        }
        // grass is resistant to water
        else if (attackType.equals("Water")) {
            return resistanceMultiplier;
        }
        // grass is weak to electric
        else if (attackType.equals("Electric")) {
            return vulnerabilityMultiplier;
        }
        else {
            return 1.0;
        }
    }
} 