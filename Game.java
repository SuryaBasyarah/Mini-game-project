import java.util.Random;
import java.util.Scanner;

public class Game {
    private static boolean gameRunning = true;
    private static Map map;
    private static Player player;
    private static Boss boss;
    private static String[] Enemies = {"Gunner", "Suicidal bomber", "Sniper"};
    private static int[] Damage = {20, 40, 60};

    private static void movePlayer(char move) {
        int newX = player.getX();
        int newY = player.getY();

        switch (move) {
            case 'w':
                newX--;
                break;
            case 'a':
                newY--;
                break;
            case 's':
                newX++;
                break;
            case 'd':
                newY++;
                break;
            default:
                System.out.println("Use wasd");
                return;
        }

        if (map.isValidMove(newX, newY)) {
            player.setPosition(newX, newY);
            interact();
        } else {
            System.out.println("X is wall, [space] is path");
        }
    }

    private static void interact() {
        // Random random = new Random();
        // Scanner scanner = new Scanner(System.in);
        if (map.getTile(player.getX(), player.getY()) == " ? ") {
            System.out.println("What is this?");
            double randomEvent = Math.random();
            if (randomEvent < 0.5) {
                // int enemyDataIndex = random.nextInt(Enemies.length);
                // System.out.println(Enemies[enemyDataIndex] + " appears");
                System.out.println("WAR!");
                battle();
            } else {
                System.out.println("You found something!");
                player.getInventory().addItem("Health Potion");
            }
            
            map.clearInteraction(player.getX(), player.getY());
        }

        if (player.getX() == boss.getX() && player.getY() == boss.getY()) {
            System.out.println("You've encountered the boss, but not anymore");
            battleBoss();
        }
    }

    private static void battle() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int enemyDataIndex = random.nextInt(Enemies.length);
        System.out.println(Enemies[enemyDataIndex] + " appears");
        System.out.println("Player HP: " + player.getHealth());
        System.out.println("Player armor: " + player.getArmor());
        enemyDataIndex = random.nextInt(Damage.length);
        System.out.println("Enemy damage: " + Damage[enemyDataIndex]);
        player.takeDamage(Damage[enemyDataIndex]);
        System.out.println("wait, you can get hit? you're not supposed to");
        if (player.getHealth() == 0) {
            System.out.println("How did you die?");
            System.exit(1);
        }
        System.out.println("btw here is your HP: " + player.getHealth());
        System.out.println("Choose action: 1) Heal 2) No heal");
        int action = scanner.nextInt();
        if (action == 1) {
            System.out.println("Why did you heal? just play it");
            player.getInventory().useItem(player);
            System.out.println("Player HP: " + player.getHealth());
        }
        else {
            System.out.println("Remember, no heal.");
        }
    }

    private static void battleBoss() {
        Scanner scanner = new Scanner(System.in);

        while (player.getHealth() > 0 && boss.getHealth() > 0) {
            System.out.println("Player HP: " + player.getHealth() + ", Player attack: 20");
            System.out.println("boss HP: " + boss.getHealth());
            System.out.println("Choose action: 1) Kill 2) Use item");
            int action = scanner.nextInt();

            if (action == 1) {
                boss.takeDamage(player.attack());
                if (boss.getHealth() > 0) {
                    player.takeDamage(boss.attack());
                }
                System.out.println("You've been attack");
            } else if (action == 2) {
                player.getInventory().useItem(player);
            } else {
                System.out.println("what r u looking for?");
            }
        }

        if (player.getHealth() > 0) {
            System.out.println("You've killed the boss!");
            System.out.println("Thank you for playing this noob game");
            gameRunning = false;
        } else {
            System.out.println("How did you die?");
            gameRunning = false;
        }
        scanner.close();
    }
    public static void main(String[] args) {
        map = new Map();
        player = new Player(1, 1);
        boss = new Boss(8, 8);

        Scanner scanner = new Scanner(System.in);

        while (gameRunning) {
            map.printMap(player, boss);
            System.out.println("Enter move (wasd): ");
            char move = scanner.next().charAt(0);
            movePlayer(move);
        }

        scanner.close();
    }

}
