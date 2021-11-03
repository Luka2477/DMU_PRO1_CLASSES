package opgave3;

public class Car {
    private final String license;
    private double pricePerDay;
    private final int purchaseYear;

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
}
