package opgave2.s2.application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {

    private LocalDateTime start;
    private LocalDateTime slut;

    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Reservation (LocalDateTime start, LocalDateTime slut) {
        this.start = start;
        this.slut = slut;
    }

    // ------------------------------------------------------------------------------

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getSlut() {
        return slut;
    }

    public void setSlut(LocalDateTime slut) {
        this.slut = slut;
    }

    // ------------------------------------------------------------------------------

    public void addPlads (Plads plads) {
        if (!this.pladser.contains(plads)) {
            this.pladser.add(plads);
            plads.addReservation(this);
        }
    }

    public void removePlads (Plads plads) {
        if (this.pladser.contains(plads)) {
            this.pladser.remove(plads);
            plads.removeReservation(this);
        }
    }

    public ArrayList<Plads> getPladser () {
        return new ArrayList<>(this.pladser);
    }
}
