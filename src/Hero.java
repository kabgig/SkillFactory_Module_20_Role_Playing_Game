import java.util.HashMap;

public class Hero extends Personage{
    HashMap<String, Integer> mixtures;

    public Hero(String name, int health, int gold, int skill, int power, int experience) {
        super(name, health, gold, skill, power, experience);
        mixtures = new HashMap<>();
    }
}
