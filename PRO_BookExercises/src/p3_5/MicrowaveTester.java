package p3_5;

public class MicrowaveTester {
    public static void main(String[] args) {
        Microwave mw = new Microwave();
        mw.start();
        System.out.println("Expected: 0 n 1");

        mw.incrementTime();
        mw.togglePowerLevel();
        mw.start();
        System.out.println("Expected: 30 n 2");

        mw.togglePowerLevel();
        mw.start();
        System.out.println("Expected: 30 n 1");

        mw.reset();
        mw.start();
        System.out.println("Expected: 0 n 1");
    }
}
