public abstract class Personage{
    String name;
    int health, gold, skill, power, experience, level;
    boolean isAlive = true;

    public Personage(
            String name,
            int health,
            int gold,
            int skill,
            int power,
            int experience,
            int level
    ) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.skill = skill;
        this.power = power;
        this.experience = experience;
        this.level = level;
    }
}
