import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
    BufferedReader br;
    Hero hero;
    Vendor vendor;

    public Menu(BufferedReader br, Hero hero, Vendor vendor) {
        this.br = br;
        this.hero = hero;
        this.vendor = vendor;
    }

    public void menu() {
        while (true) {
            System.out.println("----\nMain Menu\n1. To Vendor\n2. To forest\n3. Exit\n-------");
            System.out.print("Enter: ");
            try {
                String command = br.readLine();
                switch (command) {
                    case "1":
                        vendor.sellMixture(hero, br, this);
                        break;
                    case "2":
                        hero.heroMenu(this);
                        break;
                    case "3":
                        break;
                    default:
                        menu();
                }
            break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void forestMenu() {
        System.out.println("forest menu");
    }
}
