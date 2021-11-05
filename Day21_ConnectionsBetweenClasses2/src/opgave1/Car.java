package opgave1;

import java.util.ArrayList;

public class Car {
    private final String license;
    private double pricePerDay;
    private final int purchaseYear;

    private final ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String license, int year) {
        this.license = license;
        this.purchaseYear = year;
    }

    public void setDayPrice (double price) {
        this.pricePerDay = price;
    }

    public double getDayPrice () {
        return this.pricePerDay;
    }

    public String getLicense () {
        return this.license;
    }

    public int getPurchaseYear () {
        return this.purchaseYear;
    }

    public void addRental (Rental rental) {
        if (!this.rentals.contains(rental)) {
            this.rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental (Rental rental) {
        if (this.rentals.contains(rental)) {
            this.rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    public ArrayList<Rental> getRentals () {
        return new ArrayList<>(this.rentals);
    }

    public int maxDaysRented () {
        return this.rentals.stream().mapToInt(Rental::getDays).max().orElse(0);
    }
}
