import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
    BufferedReader br;
    Hero hero;
    Vendor vendor;

    public Menu(BufferedReader br, Hero hero, Vendor vendor) {
        this.br = br;
        this.hero = hero;
        this.vendor = vendor;
    }

    public void menu(){
        System.out.println("----\nMenu\n1. To Vendor\n2. To forest\n3. Exit\n-------");
        System.out.print("Enter: ");
        try {
            String command = br.readLine();
            switch(command){
                case "1": vendorMenu(hero,vendor); break;
                case "2": forestMenu(); break;
                case "3": break;
                default: menu();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void vendorMenu(Hero hero,Vendor vendor){
        vendor.sellMixture(hero,br);
    }
    public void forestMenu(){
        System.out.println("forest menu");
    }
}
