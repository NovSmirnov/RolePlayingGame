public final class Player extends Unit{
    private String name;
    private String playersClass;
    private int gold;
    private int experience;
    private int level;
    private int maxLife;

    public Player(String name, int playClass) {
        super(0, 0, 0);
        if (playClass == 1) {
            super.life = 500;
            this.maxLife = 500;
            super.strength = 20;
            super.agility = 10;
            playersClass = "Warrior";

        } else if(playClass == 2) {
            super.life = 400;
            super.strength = 12;
            super.agility = 20;
            playersClass = "Thief";
            this.maxLife = 400;
        }
        this.name = name;
        this.gold = 0;
        this.experience = 0;
        this.level = 1;
    }

    public String getName() {
        return name;
    }

    public void receiveTrophy(int experience, int gold) { // получение золота и опыта с убитых монстров
        if (life > 0) {
            this.experience += experience;
            this.gold +=gold;
            if (experience > 100 && level < 2) {
                level = 2;
                statIncrease();
                System.out.println("Level up to 2");
            } else if (experience > 300 && level < 3) {
                level = 3;
                statIncrease();
                System.out.println("Level up to 3");
            } else if (experience > 600 && level < 4) {
                level = 4;
                statIncrease();
                System.out.println("Level up to 4");
            } else if (experience > 1000 && level < 5) {
                level = 5;
                statIncrease();
                System.out.println("Level up to 5");
            }

        } else {
            System.out.println("Your hero is dead!");
        }

    }

    private void statIncrease() {
        maxLife *= 1.2;
        life = maxLife;
        strength *= 1.2;
        agility *= 1.2;
    }

    public void playerInfo () {
        System.out.println("Name = " + name);
        System.out.println("Class = " + playersClass);
        System.out.println("Level = " + level);
        System.out.println("Life = " + life + "/" + maxLife);
        System.out.println("Strength = " + strength);
        System.out.println("Agility = " + agility);
        System.out.println("Gold = " + gold);
        System.out.println("Experience = " + experience);
        System.out.println(" ");
    }

    public void heal(int potionScores, int quantity) { // Лечение персонажа
        if ((super.life += (potionScores * quantity)) <= maxLife) {
            super.life += (potionScores * quantity);
        } else {
            super.life = maxLife;
        }

    }

    public void giveGold(int gold) {
        if ((this.gold - gold) >= 0 ) {
            this.gold -= gold;
        } else {
            System.out.println("You have not enough gold");
        }
    }

    public int getMaxLife() {
        return maxLife;
    }

}
