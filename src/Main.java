import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
            //personages
            var hero = new Hero("Hero", 1, 10000, 15, 12450, 4,1, br);
            var goblin = new Goblin();
            var skeleton = new Skeleton();
            var vendor = new Vendor();
            var menu = new Menu(br, hero, vendor,goblin,skeleton);
            //starting the game
            menu.menu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}