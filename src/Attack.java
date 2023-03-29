public interface Attack {
        //at - attacker
        //vic - victim
        default String attack(Personage at, Personage vic) {
            String attackResult = "";
            int kick = at.power / (10 * at.experience + at.skill); // how hard it kicks
            at.power -= kick;
            if (at.power < 0) at.power = 0;

            if (at.skill * at.experience < vic.skill * vic.experience) {
                attackResult = "Attack is missed,\npower level " + at.power;
            } else {
                vic.health -= kick;
                attackResult = at.name + " attacked! Power left " + at.power + "\n" +
                        vic.name + " health " + vic.health;
                if (vic.health <= 0) attackResult = vic.name + " dead";
            }
            System.out.println("------------");
            return attackResult;
        }
}