package opgave4;

public class RadiatorApp {
    public static void main(String[] args) {
        Radiator r1 = new Radiator();
        Radiator r2 = new Radiator(22);
        System.out.printf("Radiator1 is %d degrees and radiator2 is %d degrees%n", r1.getTemperature(), r2.getTemperature());

        r1.skruOp(15);
        r2.skruNed(7);
        System.out.printf("Radiator1 is %d degrees and radiator2 is %d degrees%n", r1.getTemperature(), r2.getTemperature());
    }
}
