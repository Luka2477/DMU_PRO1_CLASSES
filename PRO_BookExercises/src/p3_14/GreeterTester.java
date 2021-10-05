package p3_14;

public class GreeterTester {
    public static void main(String[] args) {
        Greeter g1 = new Greeter("Lukas");
        Greeter g2 = new Greeter("Dave");

        System.out.printf("%s | %s | %s%n", g1.sayHello(), g1.sayGoodbye(), g1.refuseHelp());
        System.out.printf("%s | %s | %s%n", g2.sayHello(), g2.sayGoodbye(), g2.refuseHelp());
    }
}
