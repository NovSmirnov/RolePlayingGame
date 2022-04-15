public interface Monstrable {
    int getMonsterLevel();
    String getMonsterType();
    int getGold();
    int getExperienceForPlayer();
    int getLife();
    void damage(int life);
    int getAgility();
    int getStrength();
}
