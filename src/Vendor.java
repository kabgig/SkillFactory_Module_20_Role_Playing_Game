import java.util.HashMap;

public class Vendor  {
    int gold = 0;
    HashMap<String, Integer> mixtures;

    public Vendor() {
        mixtures = new HashMap<>();
        putMixture(50);
        putMixture(50);
        putMixture(100);
        putMixture(100);
        putMixture(250);
        putMixture(250);
        putMixture(500);
        putMixture(500);
    }

    public void sellMixture(){

    }


    public void putMixture(int mixtureSize){
        int index = 1;
        mixtures.put(index + "-" + mixtureSize, mixtureSize);
        index++;
    }
}
