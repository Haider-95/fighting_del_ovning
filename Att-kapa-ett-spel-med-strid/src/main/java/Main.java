import se.trixzta.adventure.model.Creature;
import se.trixzta.adventure.model.Monster;
import se.trixzta.adventure.model.Player;
import java.util.Scanner;

public class Main {
    private static Player player;
    private static Monster monster;
    private static boolean running = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        player = new Player(90, 10, "Gladiator");
        monster = new Monster(30, 1, "Slime");

        System.out.println("Welcome to the arena!");
        System.out.println("Only one will survive. Do you wish to fight or surrender the game?");

        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Fight")) {
            while (player.isAlive() && monster.isAlive()) {
                fightOneRound();
            }
        } else if (input.equalsIgnoreCase("Surrender")) {
            System.out.println("Game ends by Surrender");
            running = false;
        } else {
            System.out.println("Make a new choice\n ");
            main(args);
            return;
        }

        if (running) {
            if (player.isAlive()) {
                System.out.println(player.getName() + " wins the fight");
            } else if (monster.isAlive()) {
                System.out.println(monster.getName() + " wins the fight");
            } else {
                System.out.println("both have fallen");
            }
        }
        scanner.close();
    }

    public static void fightOneRound() {

        executeAttack(player, monster);

        if (monster.isAlive()) {
            executeAttack(monster, player);
            System.out.println();
        }
    }

    static void executeAttack(Creature attacker, Creature defender) {

        attacker.attack(defender);
        System.out.println(attacker.getName() + " attacked " + defender.getName());

        if (defender.isAlive()) {
            System.out.println(defender.getName() + " has " + defender.getHealth() + "  hp left");
        } else {
            System.out.println(defender.getName() + " has been slain!!");
        }
    }
}
