package Singelton_Strategy;

import Adapter.*;
import Decorator.*;
import Factory.Juice;
import Factory.JuiceFactory;
import Observer.Client;
import Observer.NotificationManager;

import java.util.*;

public class BurgerKing implements InternalBKSystem {
  private StockManagementAdapter stock;
  private NotificationManager notificationManager;
  private List<Client> clients;

  public void setStock(StockSystem stock) {
    this.stock = new StockManagementAdapter(stock);
  }
  private static BurgerKing burgerKing;
  private Basket basket = new Basket();

  private BurgerKing() {
    notificationManager = new NotificationManager();
    clients = new ArrayList<>(Arrays.asList(
            new Client(1,"client", "VIP",18, true),
            new Client(2,"client", "regular", 22, false)));
  }
  public static BurgerKing getInstance() {
    if (burgerKing == null) burgerKing = new BurgerKing();
    return burgerKing;
  }
  public StockManagementAdapter getStock() {
    return stock;
  }

  public Basket getBasket() {
    return basket;
  }

  public List<Client> getClients() {
    return clients;
  }

  public Juice chooseJuice(Scanner scanner) {
    System.out.println("Выберите вид сока:");
    System.out.println("1. Яблочный сок");
    System.out.println("2. Апельсиновый сок");
    System.out.println("3. Виноградный сок");
    int juiceChoice = scanner.nextInt();
    Juice juice = null;

    JuiceFactory juiceFactory = new JuiceFactory();

    switch (juiceChoice) {
      case 1:
        juice = juiceFactory.createJuice("apple");
        break;
      case 2:
        juice = juiceFactory.createJuice("orange");
        break;
      case 3:
        juice = juiceFactory.createJuice("grape");
        break;
      default:
        System.out.println("Неверный выбор сока. Программа завершается.");
        break;
    }
    basket.addProduct((Product) juice);
    System.out.println("Сок готов: " + juice.getName() + ", Цена: " + juice.getPrice());
    return juice;
  }

  public Decorator.Burger chooseBurger(Scanner scanner) {
    Decorator.Burger burger = new Decorator.BasicBurger("Basic Burger", 2.0);

    while (true) {
      System.out.println("Выберите начинку для бургера:");
      System.out.println("1. Сыр");
      System.out.println("2. Салат");
      System.out.println("3. Завершить");

      int choice = scanner.nextInt();
      switch (choice) {
        case 1 -> burger = new Decorator.Cheese(burger);
        case 2 -> burger = new Decorator.Lettuce(burger);
        case 3 -> {
          System.out.println("Бургер готов: " + burger.getName() + ", Цена: " + burger.getPrice());
          basket.addProduct(burger);
          return burger;
        }
        default -> System.out.println("Некорректный выбор. Попробуйте снова.");
      }
    }
  }

  public void getCheck(Client client) {
    if (client.isVIP()) basket.setLoyaltyDiscount(new VIPCustomerDiscount());
    else basket.setLoyaltyDiscountStrategy(new RegularCustomerDiscount());

    System.out.println("Бургеры: " + basket.listBurgers() + " на сумму " + basket.burgersPrice());

    if (basket.getProducts().stream().anyMatch(x -> x instanceof Ice))
      System.out.println("Лед: " + basket.iceCount() + " на сумму " + 0.5 * basket.iceCount());

    System.out.println("Соки: " + basket.listJuices() + " на сумму " + basket.juicesPrice());
    System.out.printf("Общая сумма: %.2f%n", basket.getCheck());
    System.out.printf("Скидка:  %.2f%n", (basket.getCheck() - basket.getCheckWithDiscount()));
    System.out.printf("Итоговая сумма: %.2f%n", basket.getCheckWithDiscount());
  }


  @Override
  public void makeOrder() {
    System.out.println("Нажмите 1 для покупки бургера");
    System.out.println("Нажмите 2 для покупки сока");
    System.out.println("Нажмите 3 для чека");
    System.out.println("Нажмите 4 чтобы взять лед со склада");
    System.out.println("Нажмите 5 чтобы узнать о супер-мега бургере");
    System.out.println("Нажмите 0 для выхода");
  }

  public void unload() {
    setStock(new Stock());
    stock.makeOrder();
  }

  public void makeAnons(Scanner scanner) {
    scanner.nextLine();
    String message = scanner.nextLine();
    for(Client client : clients) {
      notificationManager.addObserver(client);
    }

    notificationManager.setMessage(message);
    notificationManager.notifyObservers();
  }
  public Client findClient(int id) {
    return clients.stream()
            .filter(x -> x.getId() == id)
            .findFirst()
            .orElse(null);
  }
  public void displayClients() {
    System.out.println("List of clients:");
    getClients().forEach(System.out::println);
  }
}
