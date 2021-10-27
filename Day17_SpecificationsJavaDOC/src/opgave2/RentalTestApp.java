package opgave2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Models a rental test application.
 */
public class RentalTestApp {
    /**
     * Main method that tests the rental class.
     *
     * @param args string arguments the system passes to main method
     */
    public static void main(String[] args) {
        LocalDate currDate = LocalDate.now();
        LocalDate nextMonth = currDate.plusMonths(1);
        nextMonth = nextMonth.minusDays(nextMonth.getDayOfMonth() - 1);
        Rental audiA4 = new Rental(0, 14, 100, nextMonth);

        LocalDate inTenMonths = currDate.plusMonths(10);
        Rental mercedesC350 = new Rental(1, 21, 150, inTenMonths);

        System.out.printf("Total price: %f | End date: %s | Day before start: %s%n",
                audiA4.getTotalPrice(),
                audiA4.getEndDate(),
                audiA4.getStartDate().minusDays(1));
        System.out.printf("Total price: %f | End date: %s | Day before start: %s%n",
                mercedesC350.getTotalPrice(),
                mercedesC350.getEndDate(),
                mercedesC350.getStartDate().minusDays(1));

        Period dateDiff = audiA4.getStartDate().until(mercedesC350.getStartDate());
        System.out.printf("Years: %d | Months: %d | days: %d%n", dateDiff.getYears(), dateDiff.getMonths(), dateDiff.getDays());

        System.out.printf("Days between rentals: %d", ChronoUnit.DAYS.between(audiA4.getStartDate(), mercedesC350.getStartDate()));
    }
}
