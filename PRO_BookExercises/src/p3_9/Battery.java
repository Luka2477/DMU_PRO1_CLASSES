package p3_9;

public class Battery {
    final private double capacity;
    private double charge;

    public Battery(double capacity) {
        this.capacity = capacity;
        this.charge = this.capacity;
    }

    public void drain(double amount) { this.charge -= amount; }
    public void charge() { this.charge = this.capacity; }
    public double getRemainingCapacity() { return this.charge; }
}
