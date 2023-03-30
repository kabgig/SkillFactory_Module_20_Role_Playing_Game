import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Vendor  {
    int gold = 0;
    HashMap<String, Integer> mixtures;

    public Vendor() {
        mixtures = new HashMap<>();
        mixtures.put("Small",100);
        mixtures.put("Middle",250);
        mixtures.put("Big",500);
    }

    public void sellMixture(Hero hero, BufferedReader br){
        System.out.print("Mixture prices:\n1.Big - 500gold\n2.Medium - 250gold\n3.Small - 100gold\n------\nEnter: ");
        try {
            String command = br.readLine();
            switch(command){
                case "1": hero.mixtures.put()
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void putMixture(int mixtureSize){
        int index = 1;
        mixtures.put(index + "-" + mixtureSize, mixtureSize);
        index++;
    }
}
