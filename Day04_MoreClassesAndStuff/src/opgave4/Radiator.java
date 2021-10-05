package opgave4;

public class Radiator {
    private int temperature;

    public Radiator() {
        this.temperature = 20;
    }

    public Radiator(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() { return this.temperature; }

    public void skruOp(int grader) { this.temperature += grader; }
    public void skruNed(int grader) { this.temperature -= grader; }
}
