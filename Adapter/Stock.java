package Adapter;

import Singleton_Strategy.BurgerKing;

public class Stock implements StockSystem {
    @Override
    public void unload() {
        System.out.println("We have some ice for you");
        Ice ice = new Ice();
        BurgerKing bk = BurgerKing.getInstance();
        bk.getBasket().addProduct(ice);
    }
}
