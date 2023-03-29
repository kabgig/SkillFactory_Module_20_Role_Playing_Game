public class Attck {
    //at - attacker
    //vic - victim
    public static String attack(Personage at, Personage vic) {
        String attackResult = "";
        int kick = at.power / (10 * at.experience + at.skill);
        at.power -= kick;
        if (at.power < 0) at.power = 0;

        if (at.skill * at.experience < vic.skill * vic.experience) {
            attackResult = "Attack is missed,\npower level " + at.power;
        } else {
            vic.health -= kick;
            if (vic.health <= 0) attackResult = vic.name + " dead";
        }
        return attackResult;
    }
}
