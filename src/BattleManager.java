public class BattleManager {
    private Player player;
    private Player enemy;
    private BattleScoreSystem scoreSystem;

    public BattleManager(Player player, Player enemy, BattleScoreSystem scoreSystem) {
        this.player = player;
        this.enemy = enemy;
        this.scoreSystem = scoreSystem;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getEnemy() {
        return enemy;
    }

    public void startBattle() {
        System.out.println("Starting battle between " + player.getName() + " and " + enemy.getName());

        int playerDiskIndex = 0;
        int enemyDiskIndex = 0;

        while (!player.isDefeated() && !enemy.isDefeated()) {

            // Get next available disks
            GaoleDisk playerDisk = getNextAvailableDisk(player, playerDiskIndex);
            GaoleDisk enemyDisk = getNextAvailableDisk(enemy, enemyDiskIndex);

            if (playerDisk == null || enemyDisk == null) {
                break; // one side is out of Pokémon
            }

            System.out.println("\n" + player.getName() + " sends out " + playerDisk.getPokemon().getName());
            System.out.println(enemy.getName() + " sends out " + enemyDisk.getPokemon().getName());

            Battle battle = new Battle(player, enemy, playerDisk, enemyDisk);
            battle.startBattle();

            // Save player score
            int playerScore = scoreSystem.calculateScore(
                playerDisk,
                battle.getDefeatedEnemies(),
                battle.getTurnsTaken()
            );
            player.addScore(playerScore);
            scoreSystem.saveScore(player.getName(), player.getScore());

            // Save enemy score
            int enemyScore = scoreSystem.calculateScore(
                enemyDisk,
                battle.getDefeatedEnemies(),
                battle.getTurnsTaken()
            );
            enemy.addScore(enemyScore);
            scoreSystem.saveScore(enemy.getName(), enemy.getScore());

            // Move to next disk if fainted
            if (playerDisk.getPokemon().getBaseStats().getHp() <= 0) {
                playerDiskIndex++;
            }
            if (enemyDisk.getPokemon().getBaseStats().getHp() <= 0) {
                enemyDiskIndex++;
            }
        }

        if (player.isDefeated()) {
            System.out.println(player.getName() + " has lost the battle.");
        } else {
            System.out.println(enemy.getName() + " has lost the battle.");
        }
    }

    // Helper method to get the next available disk
    private GaoleDisk getNextAvailableDisk(Player p, int startIndex) {
        for (int i = startIndex; i < p.getDisks().size(); i++) {
            GaoleDisk disk = p.getDisks().get(i);
            if (disk.getPokemon().getBaseStats().getHp() > 0) {
                return disk;
            }
        }
        return null; // no available Pokémon left
    }
}
