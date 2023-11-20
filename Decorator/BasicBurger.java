package Decorator;

public class BasicBurger implements Burger {
    private String name;
    private double price;

    public BasicBurger(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
