import java.util.Random;

public interface Attack {
    Random random = new Random();
    //at - attacker
    //vic - victim
    default String attack(Personage at, Personage vic) {
        String attackResult = "";
        int kick = (10 * at.experience * at.level * randomPowerBoost()) + at.skill;// how hard it kicks
        at.power -= kick;
        if (at.power < 0) at.power = 0;
        if (at.skill * 3 < random.nextInt(0, 60) || at.power <= 0) {
            attackResult = at.name + "'s attack is missed,\n" + at.name + "'s power left " + at.power;

        } else {
            vic.health -= kick;
            if (vic.health <= 0) {
                vic.isAlive = false;
                at.experience += 3;
                if (at.experience > 10) {
                    at.level++;
                    at.experience -= 5;
                    System.out.println("\n\n\n" +
                            "---------\n" +
                            "---------\n" +
                            "NEW LEVEL " + at.level + " !!!!!\n" +
                            "---------\n" +
                            "Experience:" + at.experience +
                            "\nGain more experience and get new level!!!!");
                }
                attackResult =at.name + " attacked! \n" + vic.name + " is dead\n" +
                        at.name + " gained 3 experience points\n" +
                        "Experience level " + at.experience;
                if (at.getClass().equals(Hero.class)) {
                    at.gold += 700;
                    attackResult +=
                            "\nGold increased by 700" +
                            "\nGold level " + at.gold;
                }
            } else {
                attackResult = at.name + " attacked!" +
                        " Power left " + at.power + "\n" +
                        vic.name + " health " + vic.health;
            }
        }
        System.out.println("------------");
        return attackResult;
    }
    static int randomPowerBoost() {
        return random.nextInt(1, 3);
    }
}