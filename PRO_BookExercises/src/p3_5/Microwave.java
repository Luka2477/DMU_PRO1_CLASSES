package p3_5;

public class Microwave {
    final private int initTime;
    private int time;
    final private int initPowerLevel;
    private int powerLevel;

    public Microwave() {
        this.initTime = 0;
        this.time = 0;
        this.initPowerLevel = 1;
        this.powerLevel = this.initPowerLevel;
    }

    public void incrementTime() {
        this.time += 30;
    }

    public void togglePowerLevel() {
        this.powerLevel = (this.powerLevel == 1) ? 2 : 1;
    }

    public void reset() {
        this.time = this.initTime;
        this.powerLevel = this.initPowerLevel;
    }

    public void start() {
        System.out.println("Cooking for " + this.time + " seconds at level " + this.powerLevel);
    }
}
