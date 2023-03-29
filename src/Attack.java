public class Attack {
    public static String attack(Personage attacker, Personage victim){
        if (attacker.skill < victim.skill) return "промах";

        return "Done";
    }
}
