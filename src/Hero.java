import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Hero extends Personage implements Attack {
    HashMap<String, Integer> mixtures;
    BufferedReader br;

    public Hero(String name, int health, int gold, int skill, int power, int experience, int level,BufferedReader br) {
        super(name, health, gold, skill, power, experience,level);
        mixtures = new HashMap<>();
        this.br = br;
    }

    public void heroMenu(Menu menu, Personage enemy) {
        System.out.print("--------\nEncountered " + enemy.name + "!!!\nWhat is the Hero gonna do?\n");
        label1:
        while (true) {
            System.out.println("1.Use mixture\n2.Attack!\n3.Run away!\nEnter number:");
            try {
                String command = br.readLine();
                switch (command) {
                    case "1":
                        useMixture(menu);
                        break;
                    case "2":
                        System.out.println(attack(this, enemy));
                        System.out.println("-------\n" + enemy.name + " attacked!!!");
                        System.out.println(attack(enemy, this));
                        System.out.println("--------\nWhat to do next?");
                        break;
                    case "3":
                        break label1;
                    default:
                        System.out.println("-------\nWrong command!!!!!");
                }
            } catch (IOException e) {
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
                            "\nPower is increased by" + mixAdd * 2 +
                            "\nNow power level is " + power +
                            "\n------" +
                            "\nWhat to do now?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
