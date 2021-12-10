package extra_programming.semesteropgave_jan_2016.application.controller;

import extra_programming.semesteropgave_jan_2016.application.model.Bane;
import extra_programming.semesteropgave_jan_2016.application.model.Medlem;
import extra_programming.semesteropgave_jan_2016.application.model.Reservation;
import extra_programming.semesteropgave_jan_2016.storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Service {

    public static Bane createBane (int nummer, String baneInfo) {
        Bane bane = new Bane(nummer, baneInfo);
        Storage.addBane(bane);
        return bane;
    }

    public static ArrayList<Bane> getBaner () {
        return Storage.getBaner();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Medlem createMedlem (String navn, String mobil, String mail) {
        Medlem medlem = new Medlem(navn, mobil, mail);
        Storage.addMedlem(medlem);
        return medlem;
    }

    public static ArrayList<Medlem> getMedlemmer () {
        return Storage.getMedlemmer();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Reservation createReservation (LocalDate dato, LocalTime startTid, Bane bane, Medlem booker, Medlem makker) {
        if (bane.isLedig(dato, startTid) && !booker.hasAktivReservation() && !makker.hasAktivReservation()) {
            return booker.createReservation(dato, startTid, bane, makker);
        }

        return null;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void initStorage () {
        Service.createMedlem("Lene Mikkelsen", "12345678", "lm@msn.com");
        Service.createMedlem("Finn Jensen", "22331144", "fj@msn.com");

        Service.createBane(1, "Nord/syd vendt");
        Service.createBane(2, "Under Egetræet");
        Service.createBane(3, "Med tilskuerpladser");
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void writeLedigeTider (LocalDate dato, String filnavn) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("pro_extraexercises/src/extra_programming/semesteropgave_jan_2016/textfiler/" + filnavn);

        writer.println("Dato: " + dato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        writer.println();

        for (Bane bane : Service.getBaner()) {
            writer.println("Bane " + bane.getNummer());

            for (LocalTime time : bane.getLedigeTiderPaaDag(dato)) {
                writer.println("    " + time.format(DateTimeFormatter.ofPattern("HH:mm")));
            }

            writer.println();
        }

        writer.flush();
        writer.close();
    }

}
