package opgave2.s1.application.model;

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
}
