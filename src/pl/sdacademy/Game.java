package pl.sdacademy;

import com.sun.source.doctree.StartElementTree;

import static pl.sdacademy.ConsoleUtils.*;

public class Game {
    private ConsoleUtils ConsoleUnits;

    public void StartGame() {




        // public static void main(String[] args) {

        // HeroBuilder hb = new HeroBuilder();
        HeroBuilder hb = HeroBuilder.getInstance();
        Hero hero = hb.buildHero();



Game game =new Game();





        ConsoleUtils.debugMode = true;

        System.out.println("Just a " + C_PURPLE_UNDERLINED + "RED" + C_RESET + " test...");

        System.out.println(String.format("%20sD %5s C", 93, "X"));
        System.out.printf("My name is %s%n", "joe");

        //HeroBuilder hb = new HeroBuilder();
        // Hero hero = hb.buildHeroForTesting();//hb.buildHero();
        hero.printInfo();

        String names[] = {"A", "B", "C"};

        Enemy enemy = new Enemy(names[0]);
        enemy.name = "wrog";

        System.out.println(hero.getThing().getName());
        Enemy e = hero.getThing();
        e.setName("FAKEY NEMEMEY!");
        System.out.println(hero.getThing().getName());
        //enemy.getInfo();
        //enemy.applyDamage((byte)5);
        enemy.getRandomTaunt();

        String attackType = "";
        do {
            if (Enemy.enemiesCount == 3) {
                System.out.println("Already killed " + c_yellow("" + Enemy.enemiesCount) + " enemies\n");
                System.out.println("Stage 1 Completed!");
                break;
            }
               else if (enemy.isDead()) {
                hero.receiveCoins(enemy.getCoins(), enemy);
                System.out.println("Already killed " + c_yellow("" + Enemy.enemiesCount) + " enemies\n");
                // spawning new enemy
                enemy = new Enemy(names[0]);
                enemy.getInfo();
                enemy.getRandomTaunt();
            }
            attackType = ConsoleUnits.promptForString("ATTACK WITH"
                    + C_BLUE_BOLD + C_GREEN_BACKGROUND + " [S]" + C_RESET + "word"
                    + C_BLACK_BOLD + C_YELLOW_BACKGROUND + " [A]" + C_RESET + "xe"
                    +C_BLACK_BOLD + C_RED_BACKGROUND + " [F]" + C_RESET + "ire"
                    + C_BLACK_BOLD + C_CYAN_BACKGROUND + " [I]" + C_RESET + "ce");
            hero.attack(attackType.charAt(0), enemy);

            System.out.println("\nEnemy health: " + enemy.getHealth());

        } while (!attackType.isEmpty());
        hero.printInfo();
        System.out.println("GAME OVER");
        System.exit(0);

    }
}
