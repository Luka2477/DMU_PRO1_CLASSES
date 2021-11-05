// OPGAVE A --- en bil kan tilhøre 0 til mange rentals, og en rental har 0 til mange biler

package opgave1;

import java.util.ArrayList;

public class Rental {
    private final int number;
    private int days;
    private final String date;

    private final ArrayList<Car> cars = new ArrayList<>();

    public Rental (int number, String date, int days) {
        this.number = number;
        this.date = date;
        this.days = days;
    }

    public double getPrice () {
        double dayPrice = this.cars.stream().mapToDouble(Car::getDayPrice).sum();

        return dayPrice * this.days;
    }

    public void setDays (int days) {
        this.days = days;
    }

    public int getDays () {
        return this.days;
    }

    public void addCar (Car car) {
        if (!this.cars.contains(car)) {
            this.cars.add(car);
            car.addRental(this);
        }
    }

    public void removeCar (Car car) {
        if (this.cars.contains(car)) {
            this.cars.remove(car);
            car.removeRental(this);
        }
    }

    public ArrayList<Car> getCars () {
        return new ArrayList<>(this.cars);
    }
}
