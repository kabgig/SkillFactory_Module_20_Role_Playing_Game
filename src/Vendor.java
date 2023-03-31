import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Vendor {
    int gold = 0;
    HashMap<String, Integer> mixtures;
    int index = 0;

    public Vendor() {
        mixtures = new HashMap<>();
        mixtures.put("Small", 100);
        mixtures.put("Middle", 250);
        mixtures.put("Big", 500);
    }

    public void sellMixture(Hero hero, BufferedReader br, Menu menu) {
        label1:
        while (true) {
            System.out.print(
                            "-------\n" +
                            "Mixture prices:\n" +
                            "1.Large - 500gold\n" +
                            "2.Medium - 250gold\n" +
                            "3.Small - 100gold\n" +
                            "4.Back to village\n" +
                            "--\n" +
                            "Enter number: ");
            try {
                String command = br.readLine();
                switch (command) {
                    case "1": {
                        if (hero.gold < 500) {
                            System.out.println("Not enough gold!");
                        } else {
                            hero.gold -= 500;
                            hero.mixtures.put(index + "-L", 500);
                            System.out.println("--\n" +
                                    "Bought large mixture!\n" +
                                    "Gold left " + hero.gold);
                            index++;
                        }
                        break;
                    }
                    case "2": {
                        if (hero.gold < 250) {
                            System.out.println("Not enough gold!");
                        } else {
                            hero.gold -= 250;
                            hero.mixtures.put(index + "-M", 250);
                            System.out.println("--\n" +
                                    "Bought medium mixture!\n" +
                                    "Gold left " + hero.gold);
                            index++;
                        }
                        break;
                    }
                    case "3": {
                        if (hero.gold < 100) {
                            System.out.println("Not enough gold!");
                        } else {
                            hero.gold -= 100;
                            hero.mixtures.put(index + "-S", 100);
                            System.out.println("--\n" +
                                    "Bought small mixture!\n" +
                                    "Gold left " + hero.gold);
                            index++;
                        }
                        break;
                    }
                    case "4": {
                        break label1;
                    }
                    default:
                        System.out.println("---\nWrong command!!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


//    public void putMixture(int mixtureSize) {
//        int index = 1;
//        mixtures.put(index + "-" + mixtureSize, mixtureSize);
//       // index++;
//    }
}
