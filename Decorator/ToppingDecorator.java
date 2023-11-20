package Decorator;

public abstract class ToppingDecorator implements Decorator.Burger {
    private Decorator.Burger burger;

    public ToppingDecorator(Decorator.Burger burger) {
        this.burger = burger;
    }

    @Override
    public String getName() {
        return burger.getName() + ", " + getToppingName();
    }

    @Override
    public double getPrice() {
        return burger.getPrice() + getToppingPrice();
    }

    protected abstract String getToppingName();

    protected abstract double getToppingPrice();
}