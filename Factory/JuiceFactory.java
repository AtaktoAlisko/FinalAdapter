package Factory;

public class JuiceFactory {
    public Juice createJuice(String type) {
        switch (type.toLowerCase()) {
            case "apple":
                return new AppleJuice();
            case "orange":
                return new OrangeJuice();
            case "grape":
                return new GrapeJuice();
            default:
                throw new IllegalArgumentException("Unknown juice type: " + type);
        }
    }
}
