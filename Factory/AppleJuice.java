package Factory;

class AppleJuice implements Juice{

    @Override
    public double getPrice() {
        return 2.5;
    }

    @Override
    public String getName() {
        return "Apple juice";
    }
}
