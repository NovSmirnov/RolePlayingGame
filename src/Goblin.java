public final class Goblin extends Unit implements Monstrable {
    private int monsterLevel;
    private String monsterType = "Goblin";
    private int gold;
    private int experienceForPlayer;

    public Goblin(int monsterLevel) {
        super(40 * monsterLevel, 3 * monsterLevel, 5 * monsterLevel);
        this.monsterLevel = monsterLevel;
        this.gold = (int) (Math.random() * 50 * monsterLevel);
        this.experienceForPlayer = 4 * monsterLevel;
    }

    @Override
    public int getMonsterLevel() {
        return monsterLevel;
    }

    @Override
    public String getMonsterType() {
        return monsterType;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public int getExperienceForPlayer() {
        return experienceForPlayer;
    }

}
