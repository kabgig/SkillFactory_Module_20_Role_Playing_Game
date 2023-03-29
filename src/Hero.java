import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Hero extends Personage implements Attack {
    HashMap<String, Integer> mixtures;
    BufferedReader br;

    public Hero(String name, int health, int gold, int skill, int power, int experience, BufferedReader br) {
        super(name, health, gold, skill, power, experience);
        mixtures = new HashMap<>();
        this.br = br;
    }

    public void useMixture() {
        if(mixtures.isEmpty()){
            System.out.println("You don't have mixtures");
            return;
        }
        System.out.println("Which mixture to use?");
        System.out.println(mixtures.keySet());
        System.out.println("Enter: ");
        try {
            String mix = br.readLine();
            int mixAdd = mixtures.remove(mix);
            health += mixAdd;
            System.out.println("Health is increased by " + mixAdd + ".\n Now health level is " + health);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
