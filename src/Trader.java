public class Trader {
    private static int healingPotionPrice = 50;
    private static int healingPotionPower = 50;

    public static void buyHealingPotion(Player player, int quantity) {
        player.heal(healingPotionPower, quantity);
        player.giveGold(healingPotionPrice);
    }


}
