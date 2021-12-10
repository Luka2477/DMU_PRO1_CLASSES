package extra_programming.semesteropgave_jan_2016.application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation implements Comparable<Reservation> {

    private LocalDate dato;
    private LocalTime startTid;

    private Bane bane;
    private Medlem booker, makker;

    public Reservation(LocalDate dato, LocalTime startTid, Bane bane, Medlem booker, Medlem makker) {
        this.dato = dato;
        this.startTid = startTid;
        this.booker = booker;

        this.setBane(bane);
        this.setMakker(makker);
    }

    //------------------------------------------------------------------------------------------------------------------


    public LocalDate getDato() {
        return this.dato;
    }

    public LocalTime getStartTid() {
        return this.startTid;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setBane (Bane bane) {
        if (bane != null && this.bane != bane) {
            if (this.bane != null) {
                this.bane.removeReservation(this);
            }

            this.bane = bane;
            this.bane.addReservation(this);
        }
    }

    public Bane getBane() {
        return this.bane;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setBooker (Medlem booker) {
        if (booker != null && this.booker != booker) {
            if (this.booker != null) {
                this.booker.removeBookerReservation(this);
            }

            this.booker = booker;
            this.booker.addBookerReservation(this);
        }
    }

    public Medlem getBooker() {
        return this.booker;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setMakker (Medlem makker) {
        if (makker != null && this.makker != makker) {
            if (this.makker != null) {
                this.makker.removeMakkerReservation(this);
            }

            this.makker = makker;
            this.makker.addMakkerReservation(this);
        }
    }

    public Medlem getMakker() {
        return this.makker;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public int compareTo (Reservation reservation) {
        int comp = this.dato.compareTo(reservation.getDato());

        if (comp == 0) {
            comp = this.startTid.compareTo(reservation.getStartTid());

            if (comp == 0) {
                comp = this.bane.getNummer() - reservation.getBane().getNummer();
            }
        }

        return comp;
    }

}
