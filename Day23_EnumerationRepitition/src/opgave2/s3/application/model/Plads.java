package opgave2.s3.application.model;

import java.util.ArrayList;

public class Plads {

    private int nr;
    private Omraade omraade;

    private final ArrayList<Reservation> reservationer = new ArrayList<>();

    private static int standardTimePris = 50;

    public Plads (int nr, Omraade omraade) {
        this.nr = nr;
        this.omraade = omraade;
    }

    // ----------------------------------------------------------------------

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public Omraade getOmraade() {
        return omraade;
    }

    public void setOmraade(Omraade omraade) {
        this.omraade = omraade;
    }

    public static int getStandardTimePris () {
        return Plads.standardTimePris;
    }

    public static void setStandardTimePris (int standardTimePris) {
        Plads.standardTimePris = standardTimePris;
    }

    // ---------------------------------------------------------------------------

    public void addReservation (Reservation reservation) {
        if (!this.reservationer.contains(reservation)) {
            this.reservationer.add(reservation);
            reservation.addPlads(this);
        }
    }

    public void removeReservation (Reservation reservation) {
        if (this.reservationer.contains(reservation)) {
            this.reservationer.remove(reservation);
            reservation.removePlads(this);
        }
    }

    public ArrayList<Reservation> getReservationer () {
        return new ArrayList<>(this.reservationer);
    }
}
