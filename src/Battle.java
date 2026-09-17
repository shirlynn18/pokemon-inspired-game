public class Battle {
    private Player player;
    private Player enemy;
    private GaoleDisk playerDisk;
    private GaoleDisk enemyDisk;
    private int turnsTaken;
    private int defeatedEnemies;
    private BattleLog log;

    // Constructor
    public Battle(Player player, Player enemy, GaoleDisk playerDisk, GaoleDisk enemyDisk) {
        this.player = player;
        this.enemy = enemy;
        this.playerDisk = playerDisk;
        this.enemyDisk = enemyDisk;
        this.turnsTaken = 0;
        this.defeatedEnemies = 0;
        this.log = new BattleLog();
    }

    // Main battle loop for ONE vs ONE
    public void startBattle() {
        while (playerDisk.getPokemon().getBaseStats().getHp() > 0 &&
               enemyDisk.getPokemon().getBaseStats().getHp() > 0) {

            // --- Player's Turn ---
            Skill playerSkill = player.chooseSkill(playerDisk.getPokemon());
            int damageToEnemy = calculateDamage(playerDisk, enemyDisk);
            enemyDisk.getPokemon().getBaseStats().receiveDamage(damageToEnemy);
            System.out.println(playerDisk.getPokemon().getName() + " used " + playerSkill.getName()
                               + " on " + enemyDisk.getPokemon().getName() + " for " + damageToEnemy + " damage.");
            log.addEntry(playerDisk.getPokemon().getName() + " used " + playerSkill.getName()
                         + " on " + enemyDisk.getPokemon().getName() + " for " + damageToEnemy + " damage.");

            if (enemyDisk.getPokemon().getBaseStats().getHp() <= 0) {
                System.out.println(enemyDisk.getPokemon().getName() + " fainted!");
                defeatedEnemies++;
                break; // this battle ends
            }

            // --- Enemy's Turn ---
            Skill enemySkill = enemy.chooseSkill(enemyDisk.getPokemon());
            int damageToPlayer = calculateDamage(enemyDisk, playerDisk);
            playerDisk.getPokemon().getBaseStats().receiveDamage(damageToPlayer);
            System.out.println(enemyDisk.getPokemon().getName() + " used " + enemySkill.getName()
                               + " on " + playerDisk.getPokemon().getName() + " for " + damageToPlayer + " damage.");
            log.addEntry(enemyDisk.getPokemon().getName() + " used " + enemySkill.getName()
                         + " on " + playerDisk.getPokemon().getName() + " for " + damageToPlayer + " damage.");

            if (playerDisk.getPokemon().getBaseStats().getHp() <= 0) {
                System.out.println(playerDisk.getPokemon().getName() + " fainted!");
                break; // this battle ends
            }

            turnsTaken++;
        }
    }

    // Getters
    public int getTurnsTaken() {
        return turnsTaken;
    }

    public int getDefeatedEnemies() {
        return defeatedEnemies;
    }

    public GaoleDisk getPlayerDisk() {
        return playerDisk;
    }

    public GaoleDisk getEnemyDisk() {
        return enemyDisk;
    }

    public BattleLog getLog() {
        return log;
    }

    // Damage calculation
    public int calculateDamage(GaoleDisk attacker, GaoleDisk defender) {
        int basePower = attacker.getPokemon().getBaseStats().getAttack();
        int damage = basePower;

        String attackerType = attacker.getPokemon().getType();
        String defenderType = defender.getPokemon().getType();

        if (isSuperEffective(attackerType, defenderType)) {
            damage *= 2;
        } else if (isNotEffective(attackerType, defenderType)) {
            damage /= 2;
        } else if (isNoEffect(attackerType, defenderType)) {
            damage = 0;
        }
        return Math.max(damage, 0);
    }

    // Type effectiveness
    public boolean isSuperEffective(String attackerType, String defenderType) {
        return (attackerType.equals("Fire") && defenderType.equals("Grass")) ||
               (attackerType.equals("Water") && defenderType.equals("Fire")) ||
               (attackerType.equals("Grass") && defenderType.equals("Water"));
    }

    public boolean isNotEffective(String attackerType, String defenderType) {
        return (attackerType.equals("Fire") && defenderType.equals("Water")) ||
               (attackerType.equals("Water") && defenderType.equals("Grass")) ||
               (attackerType.equals("Grass") && defenderType.equals("Fire"));
    }

    public boolean isNoEffect(String attackerType, String defenderType) {
        return attackerType.equals("Normal") && defenderType.equals("Ghost");
    }
}
