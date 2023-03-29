import java.io.BufferedReader;
import java.util.HashMap;

public class Hero extends Personage implements Attack{
    HashMap<String, Integer> mixtures;
    BufferedReader br;

    public Hero(String name, int health, int gold, int skill, int power, int experience, BufferedReader br) {
        super(name, health, gold, skill, power, experience);
        mixtures = new HashMap<>();
        this.br = br;
    }

    public void mixtureInfo(){  // How many does Hero have
        System.out.println(mixtures.keySet());
    }
    public void useMixture(String mixtureCode){
        int mixAdd = mixtures.remove(mixtureCode);
        health += mixAdd;
        System.out.println("Health is increased by " + mixAdd + ".\n Now health level is " + health);
    }
}
