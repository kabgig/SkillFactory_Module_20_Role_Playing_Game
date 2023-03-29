public class Main {
    public static void main(String[] args) {

        var hero = new Hero("Bob",1000, 1000, 15, 450, 3);
        var goblin = new Goblin();
        var skeleton =  new Skeleton();

        var res = goblin.attack(hero, goblin);
        System.out.println(res);

    }

}