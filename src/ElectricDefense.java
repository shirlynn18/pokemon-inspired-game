public class ElectricDefense {
    private String type;
    private double resistanceMultiplier;
    private double vulnerabilityMultiplier;
    private int health;
    private int voltage;
    
    public ElectricDefense() {
        this.type = "Electric";
        this.resistanceMultiplier = 0.5;
        this.vulnerabilityMultiplier = 2.0;
        this.health = 100;
        this.voltage = 1;
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
    
    public int getVoltage() {
        return voltage;
    }
    
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    
    public void attack(Pokemon target) {
        System.out.println("Electric defense attacks with voltage " + voltage);
    }
    
    public double calculateResistanceAgainst(AttackMode attack) {
        String attackType = attack.getType();
        // electric is weak to water
        if (attackType.equals("Water")) {
            return vulnerabilityMultiplier;
        }
        // electric is resistant to fire
        else if (attackType.equals("Fire")) {
            return resistanceMultiplier;
        }
        // electric is weak to grass
        else if (attackType.equals("Grass")) {
            return vulnerabilityMultiplier;
        }
        
        else {
            return 1.0;
        }
    }
} 