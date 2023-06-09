import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class Menu {
    BufferedReader br;
    Hero hero;
    Vendor vendor;
    Goblin goblin;
    Skeleton skeleton;

    public Menu(BufferedReader br, Hero hero, Vendor vendor, Goblin goblin, Skeleton skeleton) {
        this.br = br;
        this.hero = hero;
        this.vendor = vendor;
        this.goblin = goblin;
        this.skeleton = skeleton;
    }

    public void menu() {
        label1:
        while (true) {
            System.out.print(
                            "------------\n" +
                            "Village.\n" +
                            "Where " + hero.name + " goes?\n" +
                            "1. To Vendor\n" +
                            "2. To forest\n" +
                            "3. Exit game\n" +
                            "--\n" +
                            "Enter: ");
            try {
                String command = br.readLine();
                switch (command) {
                    case "1":
                        vendor.sellMixture(hero, br, this);
                        break;
                    case "2":
                        hero.heroMenu(this, enemyRandomizer(goblin, skeleton));
                        if (!hero.isAlive) break label1;
                        break;
                    case "3":
                        break label1;
                    default:
                        System.out.println("------\nWrong command!");
                        ;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Personage enemyRandomizer(Goblin goblin, Skeleton skeleton) {
        Random random = new Random();
        int enemyIndex = random.nextInt(1, 3);
        return switch (enemyIndex) {
            case 1 -> goblin;
            case 2 -> skeleton;
            default -> goblin;
        };
    }
}
