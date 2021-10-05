package modelcar;

public class CarTester {
    private Car car;

    public CarTester(Car input_car) {
        car = input_car;
    }

    public void test() {
        car.addGas(20);
        printCar();
        car.drive(100);
        printCar();
    }

    private void printCar() { System.out.println("Fuel left: " + car.getGasInTank()); }
}
