package opgave5;

public class BugTester {
    public static void main(String[] args) {
        Bug bug = new Bug(10);
        System.out.printf("Bug position is %d | Expected: 10%n", bug.getPosition());

        bug.move();
        bug.move();
        System.out.printf("Bug position is %d | Expected: 12%n", bug.getPosition());

        bug.move();
        bug.turn();
        bug.move();
        bug.move();
        System.out.printf("Bug position is %d | Expected: 11%n", bug.getPosition());

        bug.turn();
        for(int i=0; i<15; i++) bug.move();
        System.out.printf("Bug position is %d | Expected: 26%n", bug.getPosition());
    }
}
