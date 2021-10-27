package opgave2;

import java.time.LocalDate;

/**
 * Models a rental.
 */
public class Rental {
    private final int number;
    private int days;
    private final LocalDate startDate;
    private final double price;

    /**
     * Initializes a new rental with rental number, amount of days, price per day and start date of rental period.
     * Pre: days > 0, price > 0.0, LocalDate.now().until(startDate).getDays() >= 0
     *
     * @param number the identifier for the rental
     * @param days the amount of days to rent
     * @param price the daily price for the rental
     * @param startDate the start date of the renal period
     */
    public Rental(int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    /**
     * Returns the daily price of the rental.
     *
     * @return the daily price of the rental
     */
    public double getPricePrDay() {
        return this.price;
    }

    /**
     * Registers the amount of days to rent.
     * Pre: days > 0
     *
     * @param days the amount of days to rent
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Returns the amount of days to rent.
     *
     * @return the amount of days to rent
     */
    public int getDays() {
        return this.days;
    }

    /**
     * Returns the start date of the rental period.
     *
     * @return the start date of the rental period
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    /**
     * Returns the end date of the rental period.
     *
     * @return the end date of the rental period
     */
    public LocalDate getEndDate() {
        return this.startDate.plusDays(this.days);
    }

    /**
     * Returns the total price for the rental period.
     *
     * @return the total price for the rental period
     */
    public double getTotalPrice() {
        return this.price * this.days;
    }

    /**
     * Returns the identifier for the rental.
     *
     * @return the identifier for the rental
     */
    public int getNumber() {
        return this.number;
    }
}
