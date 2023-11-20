package Singleton_Strategy;

import Adapter.Ice;
import Decorator.Burger;
import Factory.Juice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private LoyaltyDiscountStrategy loyaltyDiscountStrategy;
    private final List<Product> products = new ArrayList<>();
    public void setLoyaltyDiscountStrategy(LoyaltyDiscountStrategy loyaltyDiscountStrategy) {
        this.loyaltyDiscountStrategy = loyaltyDiscountStrategy;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getCheckWithDiscount() {
        return loyaltyDiscountStrategy.applyDiscount(products.stream()
                .mapToDouble(Product::getPrice)
                .sum());
    }
    public double getCheck() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
    public String listBurgers() {
        return getProducts().stream()
                .filter(x -> x instanceof Burger)
                .map(Product::getName)
                .collect(Collectors.joining(" "));
    }
    public String listJuices() {
        return getProducts().stream()
                .filter(x -> x instanceof Juice)
                .map(Product::getName)
                .collect(Collectors.joining(" "));
    }

    public double burgersPrice() {
        return getProducts().stream()
                .filter(x -> x instanceof Burger)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public double juicesPrice() {
        return getProducts().stream()
                .filter(x -> x instanceof Juice)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public int iceCount() {
        return (int) getProducts().stream()
                .filter(x -> x instanceof Ice)
                .count();
    }

}
