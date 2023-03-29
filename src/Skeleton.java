public class Skeleton extends Personage{

    public Skeleton(String name, int health, int gold, int skill, int power, int experience) {
        super(name, health, gold, skill, power, experience);
    }

    public Skeleton() {
        super ("Skeleton",1000,0,10,300,1);
    }
}
