import java.util.HashMap;

public class Hero extends Personage{
    HashMap<String, Integer> mixtures;

    public Hero(String name, int health, int gold, int skill, int power, int experience) {
        super(name, health, gold, skill, power, experience);
        mixtures = new HashMap<>();
        mixtures.put("10",10);
        mixtures.put("20",10);
        mixtures.put("30",10);
        mixtures.put("40",10);
        mixtures.put("10",10);
    }
}
