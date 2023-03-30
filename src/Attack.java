public interface Attack {
    //at - attacker
    //vic - victim
    default String attack(Personage at, Personage vic) {
        String attackResult = "";
        int kick = (10 * at.experience) + at.skill;// how hard it kicks
        System.out.println("kick power is " + kick);
        at.power -= kick;
        if (at.power < 0) at.power = 0;

        if (at.skill * at.experience < vic.skill * vic.experience || at.power <= 0) {
            attackResult = at.name + "'s attack is missed,\n" + at.name + "'s power left " + at.power;
        } else {
            vic.health -= kick;
            if (vic.health <= 0) {
                at.experience += 2;
                attackResult = vic.name + " is dead\n" + at.name + " gained experience 1\n now experience is " + at.experience;
                if (at.getClass().equals(Hero.class)) {
                    at.gold += 700;
                    attackResult += "\ngold increased by 700\n gold level " + at.gold;
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