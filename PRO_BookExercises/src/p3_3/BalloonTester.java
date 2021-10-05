package p3_3;

public class BalloonTester {
    public static void main(String[] args) {
        Balloon balloon = new Balloon();

        balloon.inflate(10);
        double volume = balloon.getVolume();
        System.out.println(volume + " | Expected: 4188.7902");

        balloon.inflate(15);
        volume = balloon.getVolume();
        System.out.println(volume + " | Expected: 65449.8469");
    }
}
