public final class Skeleton extends Unit implements Monstrable{
    private int monsterLevel;
    private String monsterType = "Skeleton";
    private int gold;
    private int experienceForPlayer;

    public Skeleton(int monsterLevel) {
        super(50 * monsterLevel, 5 * monsterLevel, 2 * monsterLevel); // Характеристики монстра в зависимости от уровня
        this.monsterLevel = monsterLevel; // Уровень монстра
        this.gold = (int) (Math.random() * 60 * monsterLevel); // Золото, которое получает игрок от убийства этого монстра
        this.experienceForPlayer = 5 * monsterLevel; // Опыт, который получает игрок от убийства этого монстра
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
