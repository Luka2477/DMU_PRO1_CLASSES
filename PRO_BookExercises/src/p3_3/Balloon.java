package p3_3;

public class Balloon {
    private double radius;

    public Balloon() {
        this.radius = 0;
    }

    public void inflate(double amount) {
        this.radius += amount;
    }

    public double getVolume() {
        return 4d / 3d * Math.PI * Math.pow(this.radius, 3);
    }
}
