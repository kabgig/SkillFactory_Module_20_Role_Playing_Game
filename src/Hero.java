import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Hero extends Personage implements Attack {
    HashMap<String, Integer> mixtures;
    BufferedReader br;

    public Hero(String name, int health, int gold, int skill, int power, int experience, int level, BufferedReader br) {
        super(name, health, gold, skill, power, experience, level);
        mixtures = new HashMap<>();
        this.br = br;
    }

    public void heroMenu(Menu menu, Personage enemy) {
        System.out.print("--------\n" +
                "Encountered " + enemy.name + "!!!\n\n" +
                "What is "+ name + " gonna do?\n");
        label1:
        while (true) {
            System.out.print(
                            "1.Use mixture\n" +
                            "2.Attack!\n" +
                            "3.Run away!\n" +
                            "--\n" +
                            "Enter number: ");
            try {
                String command = br.readLine();
                switch (command) {
                    case "1":
                        useMixture(menu);
                        break;
                    case "2":
                        ExecutorService es = Executors.newFixedThreadPool(2);
                        es.submit(() -> {
                            System.out.println(attack(this, enemy));
                        });
                        es.awaitTermination(500, TimeUnit.MILLISECONDS);
                        if (!enemy.isAlive) break label1;
                        es.submit(() -> {
                            System.out.println(attack(enemy, this));
                        });
                        es.awaitTermination(500, TimeUnit.MILLISECONDS);
                        es.shutdown();
                        if (!this.isAlive) {
                            System.out.println("---------\n" +
                                    "Game over. Hero is dead!");
                            break label1;
                        }
                        System.out.println("--------\n" +
                                "What to do next?");
                        break;
                    case "3":
                        break label1;
                    default:
                        System.out.println("-------\nWrong command!!!!!");
                }
                Thread.sleep(500);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void useMixture(Menu menu) {
        if (mixtures.isEmpty()) {
            System.out.println("-------\nYou don't have mixtures");
            return;
        }
        System.out.println("------\nWhich mixture to use?");
        System.out.println(mixtures.keySet());
        System.out.print("Enter: ");
        try {
            String mix = br.readLine();
            int mixAdd = mixtures.remove(mix);
            health += mixAdd;
            power += mixAdd * 2;
            System.out.println(
                    "--------\nHealth is increased by " + mixAdd +
                            "\nNow health level is " + health +
                            "\nPower is increased by " + mixAdd * 2 +
                            "\nNow power level is " + power +
                            "\n--" +
                            "\nWhat to do now?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
