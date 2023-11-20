package Singleton_Strategy;

public class RegularCustomerDiscount implements LoyaltyDiscountStrategy{
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * 0.95;
    }
}
