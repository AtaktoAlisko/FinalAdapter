package Singelton_Strategy;

public class VIPCustomerDiscount implements LoyaltyDiscountStrategy{
    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice*0.90;
    }
}
