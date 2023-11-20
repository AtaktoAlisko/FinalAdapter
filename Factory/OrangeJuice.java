package Factory;

public class OrangeJuice implements Juice{
    @Override
    public double getPrice() {
        return 3.0;
    }

    @Override
    public String getName() {
        return "Orange juice";
    }
}
