package p3_11;

public class RoachSimulation {
    public static void main(String[] args) {
        RoachPopulation rp = new RoachPopulation(10);

        for(int i=0; i<4; i++) {
            rp.breed();
            rp.spray(10);
            System.out.printf("After %d iteration, there are %d roaches alive.%n", i + 1, (int)rp.getRoaches());
        }
    }
}
