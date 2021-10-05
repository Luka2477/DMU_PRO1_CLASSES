package modelcar;

public class Car {
    private double fuel = 0;
    private double fuel_efficiency;

    public Car(double input_fuel_efficiency) {
        fuel_efficiency = input_fuel_efficiency;
    }

    public void drive(double distance_driven) { fuel -= distance_driven / fuel_efficiency; }
    public void addGas(double amount) { fuel += amount; }
    public double getGasInTank() { return fuel; }
}
