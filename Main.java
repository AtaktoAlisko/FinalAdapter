import Observer.Client;
import Singleton_Strategy.BurgerKing;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        BurgerKing burgerKing = BurgerKing.getInstance();
        while (true) {
            burgerKing.makeOrder();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> burgerKing.chooseBurger(scanner);
                case 2 -> burgerKing.chooseJuice(scanner);
                case 3 -> {
                    burgerKing.displayClients();
                    int id = scanner.nextInt();
                    Client client = burgerKing.findClient(id);
                    if (client != null) burgerKing.getCheck(client);
                    else System.out.println("Client not found.");
                }
                case 4 -> burgerKing.unload();
                case 5 -> burgerKing.makeAnons(scanner);
                case 0 -> {
                    System.out.println("Good bye!");
                    System.exit(1);
                }
            }
        }

    }
}
