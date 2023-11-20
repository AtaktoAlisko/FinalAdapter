package Adapter;

import Singleton_Strategy.Product;

public class Ice implements Product {
    @Override
    public String getName() {
        return "Ice";
    }

    @Override
    public double getPrice() {
        return 0.5;
    }
}
