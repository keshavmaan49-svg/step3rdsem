abstract class Toy {
    protected String toyName;
    protected int recommendedAge;

    public Toy(String toyName, int recommendedAge) {
        this.toyName = toyName;
        this.recommendedAge = recommendedAge;
    }

    public abstract void operate();

    public void displayToyInfo() {
        System.out.printf("Toy: %s | Recommended Age: %d+%n", toyName, recommendedAge);
    }
}

class RcCar extends Toy {
    public RcCar() {
        super("Remote Control Drift Car", 8);
    }

    @Override
    public void operate() {
        System.out.println("Accelerating and steering via 2.4GHz wireless controller.");
    }
}

class LegoSet extends Toy {
    public LegoSet() {
        super("Architectural Lego Castle", 12);
    }

    @Override
    public void operate() {
        System.out.println("Snapping interlocking modular bricks into architectural models.");
    }
}
