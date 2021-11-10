package opgave2.s5.storage;

import opgave2.s5.application.model.Arrangement;
import opgave2.s5.application.model.Plads;
import opgave2.s5.application.model.Reservation;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static final ArrayList<Reservation> reservationer = new ArrayList<>();
    private static final ArrayList<Plads> pladser = new ArrayList<>();

    // ------------------------------------------------------------------------------

    public static void addArrangement (Arrangement arrangement) {
        if (!Storage.arrangementer.contains(arrangement)) {
            Storage.arrangementer.add(arrangement);
        }
    }

    public static ArrayList<Arrangement> getArrangementer () {
        return new ArrayList<>(Storage.arrangementer);
    }

    // ------------------------------------------------------------------------------

    public static void addReservation (Reservation reservation) {
        if (!Storage.reservationer.contains(reservation)) {
            Storage.reservationer.add(reservation);
        }
    }

    public static ArrayList<Reservation> getReservationer () {
        return new ArrayList<>(Storage.reservationer);
    }

    // ------------------------------------------------------------------------------

    public static void addPlads (Plads plads) {
        if (!Storage.pladser.contains(plads)) {
            Storage.pladser.add(plads);
        }
    }

    public static ArrayList<Plads> getPladser () {
        return new ArrayList<>(Storage.pladser);
    }
}
