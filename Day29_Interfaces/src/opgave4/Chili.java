package opgave4;

public class Chili implements Measurable {

    private String name;
    private double strength;

    public Chili(String name, double strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public double getMeasure () {
        return this.strength;
    }

    @Override
    public String toString () {
        return String.format("Chili %s has strength %.2f", this.name, this.strength);
    }
}
