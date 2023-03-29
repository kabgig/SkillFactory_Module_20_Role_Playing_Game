public class Main {
    public static void main(String[] args) {
        var hero = new Hero("Bob",1000, 1000, 15, 450, 3);
        var goblin = new Goblin("Goblin",1000,0,15,460,2);
        var res = Attack.attack(hero, goblin);
        System.out.println(res);
        hero.mixtureInfo();
    }

}