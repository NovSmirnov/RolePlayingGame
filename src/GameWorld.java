import java.util.Scanner;

public final class GameWorld {
    public static void main(String[] args) {
        Scanner scanner;
        int key = 10;
        Player player = createCharacter();
        do {
            System.out.println("MAIN MENU");
            System.out.println();
            System.out.println("Go to the light forest(1, 2 lv.) (input '1' and press Enter)");
            System.out.println("Go to the dark forest(3 - 5 lv.) (input '2' and press Enter)");
            System.out.println("Go to the Trader's shop (input '3' and press Enter)");
            System.out.println("To print character's info (input '4' and press Enter)");
            System.out.println("To leave the Game (input '0' and press Enter)");

            scanner = new Scanner(System.in);
            try {
                key = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("***\nIncorrect value! Try again!\n***");
            }
            if (key == 1) {
                battleInLightForest(player);
            } else if (key == 2) {
                battleInDarkForest(player);
            } else if (key == 3) {
                visitShop(player);
            } else if (key == 4) {
                player.playerInfo();
            } else if (key == 0) {
                System.out.println("Good bye!");
            } else {
                System.out.println("Input another number!");
            }
            if (player.getLife() <= 0) {
                System.out.println("Your character was died! GAME OVER!" );
                break;
            }
        } while (key != 0);
    }

    // Создаём лёгкого монстра 1-2 уровень
    private static Monstrable getEasyMonster() {
        double rate = Math.random();
        double level = Math.random();
        Monstrable monster;
        if (rate < 0.5) {
            if (level < 0.5) {
                monster = new Skeleton(1);
            } else {
                monster = new Skeleton(2);
            }

        } else {
            if (level < 0.5) {
                monster = new Goblin(1);
            } else {
                monster = new Goblin(2);
            }
        }
        System.out.println("Your enemy is " + monster.getMonsterType() + " level " + monster.getMonsterLevel());
        return monster;
    }

    // Создаём монстра посложнее 3-5 уровень
    private static Monstrable getHardMonster() {
        double rate = Math.random();
        double level = Math.random();
        Monstrable monster;
        if (rate < 0.5) {
            if (level < 0.33) {
                monster = new Skeleton(3);
            } else if (level < 0.66){
                monster = new Skeleton(4);
            } else {
                monster = new Skeleton(5);
            }

        } else {
            if (level < 0.33) {
                monster = new Goblin(3);
            } else if (level < 0.66){
                monster = new Goblin(4);
            } else {
                monster = new Goblin(5);
            }
        }
        System.out.println("Your enemy is " + monster.getMonsterType() + " level " + monster.getMonsterLevel());
        return monster;
    }

    // Создаём персонажа
    public static Player createCharacter() {
        String name;
        Scanner scanner;
        int charClass = 3;
        do {
            System.out.println("Create your character");
            System.out.println("Enter name of your character:");
            scanner = new Scanner(System.in);
        } while (((name = scanner.next()).length()) == 0);

        do {
            System.out.println("Choose class of your character");
            System.out.println("input 1 - Warrior");
            System.out.println("input 2 - Thief");
            scanner = new Scanner(System.in);
            try {
                charClass = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("***\nIncorrect value! Try again!\n***");
            }

        } while (charClass != 1 && charClass != 2);

        Player player = new Player(name, charClass);
        System.out.println("Your character info:");
        player.playerInfo();
        System.out.println();
        return player;
    }

    // Битва в светлом в лесу с лёгким монстром
    public static void battleInLightForest(Player player) {
        System.out.println("Battle in the light forest");
        Battle battle = new Battle(player, getEasyMonster());
        battle.start();
        try {
            battle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Битва в тёмном лесу со сложным монстром
    public static void battleInDarkForest(Player player) {
        System.out.println("Battle in the dark forest");
        Battle battle = new Battle(player, getHardMonster());
        battle.start();
        try {
            battle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Идём в магазин
    public static void visitShop(Player player) {
        System.out.println("Welcome to the trader's shop!");
        int goods = 500;
        do {
            System.out.println("If you want to go to main menu, input '0'");
            System.out.println("If you want to buy a healing potion (+50 life, cost 50 gold), input '1'");
            Scanner scanner = new Scanner(System.in);
            try {
                goods = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("***\nIncorrect value! Try again!\n***");
            }
            if (goods == 1) {
                System.out.println("input quantity");
                scanner = new Scanner(System.in);
                int quantity = Integer.parseInt(scanner.next());
                Trader.buyHealingPotion(player, quantity);
                System.out.println("Your life is " + player.getLife() + "/" + player.getMaxLife());
            } else if (goods != 0) {
                System.out.println("Incorrect number!");
            }
        } while (goods != 0);
    }




}
