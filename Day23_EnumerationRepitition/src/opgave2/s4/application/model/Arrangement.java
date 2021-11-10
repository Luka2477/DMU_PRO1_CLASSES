package opgave2.s4.application.model;

import opgave2.s1.application.model.Plads;
import opgave2.s1.application.model.Reservation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Arrangement {

    private String navn;
    private boolean offentlig;

    private final ArrayList<Reservation> reservationer = new ArrayList<>();

    public Arrangement (String navn, boolean offentlig) {
        this.navn = navn;
        this.offentlig = offentlig;
    }

    // ----------------------------------------------------------------------------

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isOffentlig() {
        return offentlig;
    }

    public void setOffentlig(boolean offentlig) {
        this.offentlig = offentlig;
    }

    // ---------------------------------------------------------------------------

    public void addReservation (Reservation reservation) {
        if (!this.reservationer.contains(reservation)) {
            this.reservationer.add(reservation);
        }
    }

    public void removeReservation (Reservation reservation) {
        this.reservationer.remove(reservation);
    }

    public ArrayList<Reservation> getReservationer () {
        return new ArrayList<>(this.reservationer);
    }

    // ----------------------------------------------------------------------------

    public int antalReserveredePladser () {
        int sum = 0;
        for (Reservation reservation : this.reservationer) {
            for (Plads plads : reservation.getPladser()) {
                sum++;
            }
        }
        return sum;
    }
}
