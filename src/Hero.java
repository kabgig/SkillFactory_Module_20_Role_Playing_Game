import java.util.HashMap;

public class Hero extends Personage implements Attack{
    HashMap<String, Integer> mixtures;

    public Hero(String name, int health, int gold, int skill, int power, int experience) {
        super(name, health, gold, skill, power, experience);
        mixtures = new HashMap<>();
        putMixture(300); //init mixture
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
        int mixAdd = mixtures.remove(mixtureCode);
        health += mixAdd;
        System.out.println("Health is increased by " + mixAdd + ".\n Now health level is " + health);
    }
}
