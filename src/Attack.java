public interface Attack {
    //at - attacker
    //vic - victim
    default String attack(Personage at, Personage vic) {
        String attackResult = "";
        int kick = at.power / (10 * at.experience + at.skill); // how hard it kicks
        at.power -= kick;
        if (at.power < 0) at.power = 0;

        if (at.skill * at.experience < vic.skill * vic.experience || at.power <= 0) {
            attackResult = "Attack is missed,\npower level " + at.power;
        } else {
            vic.health -= kick;
            if (vic.health <= 0) {
                at.experience += 1;
                attackResult = vic.name + " dead\n" + at.name + "'s experience is increased by 1\n experience level is " + at.experience;
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