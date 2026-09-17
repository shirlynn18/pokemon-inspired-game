public class Move {
    private String name;
    private String type;
    private int power;
    
    public Move() {}
    
    public Move(String name, String type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public int getPower() {
        return power;
    }
    
    public void setPower(int power) {
        this.power = power;
    }
    
    public int calculateDamage() {
        return power;
    }
    
    @Override
    public String toString() {
        return name + " (" + type + ") - Power: " + power;
    }
} 