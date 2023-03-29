import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {

            System.out.print("enter: ");
            System.out.println(br.readLine());


            var hero = new Hero("Hero", 1000, 1000, 15, 450, 3);
            var goblin = new Goblin();
            var skeleton = new Skeleton();

            var res = goblin.attack(hero, goblin);
            System.out.println(res);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}