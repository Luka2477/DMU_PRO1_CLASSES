package opgave2.s7.application.controller;

import opgave2.s7.application.model.Plads;
import opgave2.s7.application.model.Reservation;
import opgave2.s7.storage.Storage;
import opgave2.s7.application.model.Arrangement;
import opgave2.s7.application.model.Omraade;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controller {

    public static Arrangement createArrangement (String navn, boolean offentlig) {
        Arrangement arrangement = new Arrangement(navn, offentlig);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static ArrayList<Arrangement> getArrangmenter () {
        return Storage.getArrangementer();
    }

    // --------------------------------------------------------------------------------------------------

    public static Reservation createReservation (LocalDateTime start, LocalDateTime slut) {
        Reservation reservation = new Reservation(start, slut);
        Storage.addReservation(reservation);
        return reservation;
    }

    public static void addReservationToArrangement (Reservation reservation, Arrangement arrangement) {
        arrangement.addReservation(reservation);
    }

    public static void addReservationToPlads (Reservation reservation, Plads plads) {
        plads.addReservation(reservation);
    }

    public static ArrayList<Reservation> getReservationer () {
        return Storage.getReservationer();
    }

    // --------------------------------------------------------------------------------------------------

    public static Plads createPlads (int nr, Omraade omraade) {
        Plads plads = new Plads(nr, omraade);
        Storage.addPlads(plads);
        return plads;
    }

    public static void addPladsToReservation (Plads plads, Reservation reservation) {
        reservation.addPlads(plads);
    }

    public static ArrayList<Plads> getPladser () {
        return Storage.getPladser();
    }

    // --------------------------------------------------------------------------------------------------

    public static void initStorage () {
        Plads p1 = Controller.createPlads(1, Omraade.TURNERING);
        Plads p2 = Controller.createPlads(2, Omraade.TURNERING);
        Plads p3 = Controller.createPlads(3, Omraade.STANDARD);
        Plads p4 = Controller.createPlads(4, Omraade.STANDARD);
        Plads p5 = Controller.createPlads(5, Omraade.BOERNE);
        Plads p6 = Controller.createPlads(6, Omraade.VIP);

        Reservation r1 =  Controller.createReservation(
                LocalDateTime.of(2019, 8, 12, 20, 0),
                LocalDateTime.of(2019, 8, 12, 23, 0));
        r1.addPlads(p1);
        r1.addPlads(p2);
        Reservation r2 =  Controller.createReservation(
                LocalDateTime.of(2019, 8, 13, 19, 0),
                LocalDateTime.of(2019, 8, 14, 6, 0));
        r2.addPlads(p3);
        r2.addPlads(p4);
        Reservation r3 =  Controller.createReservation(
                LocalDateTime.of(2019, 8, 14, 19, 0),
                LocalDateTime.of(2019, 8, 15, 6, 0));
        r3.addPlads(p6);

        Arrangement a1 = Controller.createArrangement("Dota 2 tournament", true);
        a1.addReservation(r1);
        Arrangement a2 = Controller.createArrangement("CS GO tournament", false);
    }

    public static void init () {
        Controller.initStorage();
    }
}
