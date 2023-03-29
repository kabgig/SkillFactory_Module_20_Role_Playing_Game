public abstract class Personage{
    String name;
    int health, gold, skill, power, experience;

    public Personage(
            String name,
            int health, // 1000 initial
            int gold, //1000 initial
            int skill, //0-20
            int power, //0-500
            int experience // 1-5
    ) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.skill = skill;
        this.power = power;
        this.experience = experience;
    }
}
