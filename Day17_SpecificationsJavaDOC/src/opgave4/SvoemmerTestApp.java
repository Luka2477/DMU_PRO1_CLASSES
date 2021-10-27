package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a svoemmer test application.
 */
public class SvoemmerTestApp {
    /**
     * Main method that tests the svoemmer class.
     *
     * @param args string arguments the system passes to main method
     */
    public static void main(String[] args) {
        ArrayList<Double> tider = new ArrayList<>(List.of(10.5, 11.0, 11.5, 10.2, 10.03, 15.0));
        Svoemmer svoemmer = new Svoemmer("Lukas", LocalDate.of(2000, 2, 19), "Vildbjerg", tider);

        System.out.printf("Bedste tid: %f | Gennemsnitstid: %f | Gennemsnitstid uden dårligste: %f%n",
                svoemmer.bedsteTid(),
                svoemmer.gennemsnitAfTid(),
                svoemmer.snitUdenDaarligste());
    }
}
