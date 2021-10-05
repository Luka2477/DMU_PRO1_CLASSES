package p3_11;

public class RoachPopulation {
    private double population;

    public RoachPopulation(double population) { this.population = population; }

    public void breed() { this.population *= 2; }
    public void spray(double percent) { this.population *= 1 - percent / 100; }
    public double getRoaches() { return this.population; }
}
