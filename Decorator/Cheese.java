package Decorator;

public class Cheese extends Decorator.ToppingDecorator {
    public Cheese(Decorator.Burger item) {
        super(item);
    }

    @Override
    public String getToppingName() {
        return "Cheese";
    }

    @Override
    public double getToppingPrice() {
        return 1.0;
    }
}