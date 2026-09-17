# Pokémon Ga-Olé

A command-line Pokémon-inspired battle and collection game written in Java. Choose a player name, encounter random wild Pokémon, try to catch them with different Poké Balls, battle using up to two Ga-Olé Disks, and compete for a place on the high-score table.

> This is a fan-made educational project and is not affiliated with Nintendo, Game Freak, Creatures Inc., or The Pokémon Company.

## Features

- Random Forest Stage encounters with three wild Pokémon
- Twelve available Pokémon across Fire, Water, Grass, and Electric types
- Pre-battle and post-battle catching with Poké Ball, Great Ball, Ultra Ball, and Master Ball choices
- Turn-based one-on-one battles using Pokémon stats and elemental effectiveness
- A selection of up to two Pokémon disks for each battle
- Persistent top-ten scoreboard stored locally
- Saved caught-Pokémon collection after each completed game session

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal, Command Prompt, or PowerShell window

No external libraries are required.

## Run the game

From the project folder, compile the source files:

```powershell
javac -d bin src\*.java
```

Then start the game:

```powershell
java -cp bin Main
```

If you are using Eclipse, import the folder as an existing Java project and run `Main.java`.

## How to play

1. Enter a player name.
2. Choose **Battle and Catch** from the main menu.
3. A Forest Stage generates three random wild Pokémon.
4. Select one wild Pokémon for a pre-battle catch attempt, then choose a ball.
5. Select up to two Pokémon disks to take into battle. If no Pokémon was caught, the game provides a temporary stage Pokémon.
6. During battle, choose skills when prompted. The battle ends when either side has no remaining usable Pokémon.
7. Try to catch defeated wild Pokémon, view the leaderboard, or start another round.

## Battle mechanics

Damage begins with the attacking Pokémon's Attack stat. The game applies the following type relationships during battle:

| Attacking type | Strong against | Reduced against |
| --- | --- | --- |
| Fire | Grass | Water |
| Water | Fire | Grass |
| Grass | Water | Fire |

Strong attacks deal double damage; reduced attacks deal half damage. The score for a battle is based on defeated enemies, Pokémon power, and the number of turns taken.

## Project structure

```text
src/
  Main.java                Application entry point
  Game.java                Menus, game flow, saving, and catch sequence
  Battle.java              One-on-one battle loop and damage calculation
  BattleManager.java       Manages a battle between the player and wild trainer
  Pokedex.java             Pokémon and skill definitions
  Pokemon.java             Base Pokémon model
  FirePokemon.java         Type-specific Pokémon classes
  WaterPokemon.java
  GrassPokemon.java
  ElectricPokemon.java
  Catch.java               Catch probability and catch attempts
  PokemonBall.java          Ball catch-rate modifiers
  GaoleDisk.java            Pokémon disk model
  BattleScoreSystem.java   Leaderboard calculation and persistence
```

## Saved data

The game writes these files in the project folder:

- `top_scores.txt` — the highest ten recorded scores.
- `caught_pokemon.dat` — a serialized list of Pokémon caught in the latest session.

Deleting either file resets the corresponding saved data; it will be recreated when the game saves again.

## Notes for developers

- Source files use the default Java package, so compile all files together as shown above.
- `TypeEffectiveness.java` provides a broader type-effectiveness lookup table that can be used when expanding the battle system.
- Input is currently expected to be numeric at menu prompts; entering non-numeric text may end the program with an input error.
