package Factory;

public class GrapeJuice implements Juice {

    @Override
    public double getPrice() {
        return 2.0;
    }

    @Override
    public String getName() {
        return "Grape juice";
    }
}
