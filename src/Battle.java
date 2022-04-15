public class Battle extends Thread{

    private Player player;
    private Monstrable monster;


    public Battle(Player player, Monstrable monster) {
        this.player = player;
        this.monster = monster;
    }
    @Override
    public void run() {
        boolean playerTurn = true;
        int hitPower;
        while (player.getLife() > 0 && monster.getLife() > 0) { // Битва продолжается пока у обоих бойцов жизни больше 0
            if (playerTurn) {
                if ((player.getAgility() * 3) > (Math.random() * 100)) { // Условие, что персонаж не промахнулся
                    if ((Math.random() * 100) < ((int) (player.getAgility() / 3))) { // Условие критического удара
                        hitPower = player.getStrength() * 2;
                        System.out.println("Player's CRITICAL hit!");
                    } else {
                        hitPower = player.getStrength();
                        System.out.println("Player's hit!");
                    }
                    System.out.println("Damage " + hitPower + " HP");
                    monster.damage(hitPower);
                } else {
                    System.out.println("Player missed!");
                }
                playerTurn = false;
            } else {
                if ((monster.getAgility() * 3) > (Math.random() * 100)) { // Условие, что монстр не промахнулся
                    if ((Math.random() * 100) < ((int) (monster.getAgility() / 3))) { // Условие критического удара
                        hitPower = monster.getStrength() * 2;
                        System.out.println("Monster's CRITICAL hit!");
                    } else {
                        hitPower = monster.getStrength();
                        System.out.println("Monster's hit!");
                    }
                    System.out.println("Damage " + hitPower + " HP");
                    player.damage(hitPower);
                } else {
                    System.out.println("Monster missed!");
                }
                playerTurn = true;
            }
            try {
                sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (player.getLife() > 0) {
            System.out.println("Your character " + player.getName() + " win!");
            player.receiveTrophy(monster.getGold(), monster.getExperienceForPlayer());
            System.out.println(player.getName() + " receive " + monster.getGold() + " gold , " +
                    monster.getExperienceForPlayer() + " experience");

        } else {
            System.out.println("Your character " + player.getName() + " lose!");
        }
    }
}
