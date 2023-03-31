public interface Attack {
    //at - attacker
    //vic - victim
    default String attack(Personage at, Personage vic) {
        String attackResult = "";
        int kick = (10 * at.experience * at.level) + at.skill;// how hard it kicks
        System.out.println("kick power is " + kick);
        at.power -= kick;
        if (at.power < 0) at.power = 0;

        if (at.skill * at.experience < vic.skill * vic.experience || at.power <= 0) {
            attackResult = at.name + "'s attack is missed,\n" + at.name + "'s power left " + at.power;
        } else {
            vic.health -= kick;
            if (vic.health <= 0) {
                at.experience += 2;
                if (at.experience > 10) {
                    at.level++;
                    at.experience -= 5;
                    System.out.println("New level" + at.level +
                            "\nExperience:" + at.experience +
                            "\nGain more experience and get new level!!!!");
                }
                attackResult = vic.name + " is dead\n" + at.name + "Gained experience 1\nNow experience is " + at.experience;
                if (at.getClass().equals(Hero.class)) {
                    at.gold += 700;
                    attackResult += "\nGold increased by 700\nGold level " + at.gold;
                }
            } else {
                attackResult = at.name + " attacked! Power left " + at.power + "\n" +
                        vic.name + " health " + vic.health;
            }
        }
        System.out.println("------------");
        return attackResult;
    }
}