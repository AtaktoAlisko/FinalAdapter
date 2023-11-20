package Decorator;

public class Lettuce extends Decorator.ToppingDecorator {
    public Lettuce(Decorator.Burger burger) {
        super(burger);
    }

    @Override
    protected String getToppingName() {
        return "Lettuce";
    }

    @Override
    protected double getToppingPrice() {
        return 0.5;
    }

}