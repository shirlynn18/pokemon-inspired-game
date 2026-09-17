public class WaterDefense {
    private String type;
    private double resistanceMultiplier;
    private double vulnerabilityMultiplier;
    private int health;
    private int wavePower;
    
    public WaterDefense() {
        this.type = "Water";
        this.resistanceMultiplier = 0.5;
        this.vulnerabilityMultiplier = 2.0;
        this.health = 100;
        this.wavePower = 1;
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
    
    public int getWavePower() {
        return wavePower;
    }
    
    public void setWavePower(int wavePower) {
        this.wavePower = wavePower;
    }
    
    public void attack(Pokemon target) {
        System.out.println("Water defense attacks with wave power " + wavePower);
    }
    
    public double calculateResistanceAgainst(AttackMode attack) {
        String attackType = attack.getType();
        
        // water is weak to grass
        if (attackType.equals("Grass")) {
            return vulnerabilityMultiplier;
        }
        // water is resistant to fire
        else if (attackType.equals("Fire")) {
            return resistanceMultiplier;
        }
        // water is weak to electric
        else if (attackType.equals("Electric")) {
            return vulnerabilityMultiplier;
        }
        else {
            return 1.0;
        }
    }
} 