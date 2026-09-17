
public class Stats {

    // Attributes
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;

    // Default constructor
    public Stats() {
        this.hp = 0;
        this.maxHp = 0;
        this.attack = 0;
        this.defense = 0;
        this.spAttack = 0;
        this.spDefense = 0;
        this.speed = 0;
    }

    // Parameterized constructor
    public Stats(int hp, int maxHp, int attack, int defense, int spAttack, int spDefense, int speed) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
    }

    // Getters and setters
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp, maxHp);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    public int getPower() {
        return attack + defense + spAttack + spDefense + speed + hp;
    }

    // Reduces HP when taking damage
    public void receiveDamage(int amount) {
        hp -= amount;
        if (hp < 0) {
            hp = 0;
        }
    }

    // Check if Pokémon is defeated
    public boolean isDefeated() {
        return hp <= 0;
    }

    // toString override
    @Override
    public String toString() {
        return String.format("Stats [hp=%s, maxHp=%s, attack=%s, defense=%s, spAttack=%s, spDefense=%s, speed=%s]",
                getHp(), getMaxHp(), getAttack(), getDefense(), getSpAttack(), getSpDefense(), getSpeed());
    }
}
