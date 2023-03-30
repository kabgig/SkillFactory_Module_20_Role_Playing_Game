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

    public void heroMenu(Menu menu) {
        while (true) {
            System.out.print("--------\nWhat the Hero is gonna do?\n1.Use mixture\n2.Attack\n3.Main menu\nEnter number:");
            try {
                String command = br.readLine();
                switch (command) {
                    case "1":
                        useMixture(menu);
                        break;
                    case "2":
                        System.out.println("fix attack!");
                        break;
                    case "3":
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            break;
        }
        menu.menu();
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
            System.out.println("------\nHealth is increased by " + mixAdd + ".\nNow health level is " + health);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       // heroMenu(menu);
    }
}
