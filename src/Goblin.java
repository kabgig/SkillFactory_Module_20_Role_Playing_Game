public class Goblin extends Personage implements Attack{
    public Goblin(String name, int health, int gold, int skill, int power, int experience) {
        super(name, health, gold, skill, power, experience);
    }
    public Goblin() {
        super("Goblin", 1000, 0, 1, 450, 1);
    }

}
