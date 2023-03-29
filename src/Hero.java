import java.util.HashMap;

public class Hero extends Personage{
    HashMap<String, Integer> mixtures;

    public Hero(String name, int health, int gold, int skill, int power, int experience) {
        super(name, health, gold, skill, power, experience);
        mixtures = new HashMap<>();
        putMixture(20);
    }

    public void putMixture(int mixtureSize){
        int index = 1;
        mixtures.put(index + "-" + mixtureSize, mixtureSize);
        index++;
    }
    public void mixtureInfo(){
        System.out.println(mixtures.keySet());
    }
    public void useMixture(String mixtureCode){
        mixtures.
    }
}
