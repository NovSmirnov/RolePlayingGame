public abstract class Unit {

    protected int life;
    protected int strength;
    protected int agility;

    public Unit(int life, int strength, int agility) {
        this.life = life;
        this.strength = strength;
        this.agility = agility;
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public void damage(int life) {
        this.life -= life;
    }
}
