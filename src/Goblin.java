public class Goblin extends Personage implements Attack{
    public Goblin(String name, int health, int gold, int skill, int power, int experience, int level) {
        super(name, health, gold, skill, power, experience, level);
    }
    public Goblin() {
        super("Goblin", 1000, 0, 10, 450, 1,1);
    }

}
