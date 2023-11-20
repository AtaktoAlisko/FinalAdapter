package Singelton_Strategy;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private double check;
    private List<Singelton_Strategy.Product> products = new ArrayList<>();

    public void setCheck(double check) {
        this.check = check;
    }

    public void addProduct(Singelton_Strategy.Product product){
        products.add(product);
    }
    public List<Singelton_Strategy.Product> getProducts() {
        return products;
    }
    public void setProducts(List<Singelton_Strategy.Product> products) {
        this.products = products;
    }
    public double getCheck() {
        return products.stream()
                .mapToDouble(product -> product.getPrice())
                .sum();
    }

    public void setLoyaltyDiscount(VIPCustomerDiscount vipCustomerDiscount) {
    }

    public void setLoyaltyDiscountStrategy(RegularCustomerDiscount regularCustomerDiscount) {
    }


}
