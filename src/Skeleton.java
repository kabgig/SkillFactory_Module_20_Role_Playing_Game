public class Skeleton extends Personage{

    public Skeleton(String name, int health, int gold, int skill, int power, int experience, int level) {
        super(name, health, gold, skill, power, experience, level);
    }

    public Skeleton() {
        super ("Skeleton",1000,0,10,300,1,1);
    }
}
