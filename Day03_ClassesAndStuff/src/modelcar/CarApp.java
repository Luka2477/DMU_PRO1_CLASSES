package modelcar;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Car(50);
        CarTester cart = new CarTester(car);
        cart.test();
    }
}
