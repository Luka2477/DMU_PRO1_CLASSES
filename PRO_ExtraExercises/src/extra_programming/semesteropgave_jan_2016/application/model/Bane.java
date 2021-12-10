package extra_programming.semesteropgave_jan_2016.application.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {

    private int nummer;
    private String baneInfo;

    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Bane(int nummer, String baneInfo) {
        this.nummer = nummer;
        this.baneInfo = baneInfo;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getNummer() {
        return this.nummer;
    }

    public String getBaneInfo() {
        return this.baneInfo;
    }

    //------------------------------------------------------------------------------------------------------------------

    /*
    public void addReservation (Reservation reservation) {
        if (!this.reservationer.contains(reservation)) {
            this.reservationer.add(reservation);
            reservation.setBane(this);
        }
    }
    */

    public void addReservation (Reservation reservation) {
        if (!this.reservationer.contains(reservation)) {
            boolean found = false;
            int i = 0;

            while (i < this.reservationer.size() && !found) {
                if (reservation.compareTo(this.reservationer.get(i)) < 0) {
                    found = true;
                } else {
                    i++;
                }
            }

            this.reservationer.add(i, reservation);
        }
    }

    public boolean removeReservation (Reservation reservation) {
        return this.reservationer.remove(reservation);
    }

    public ArrayList<Reservation> getReservationer () {
        return new ArrayList<>(this.reservationer);
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean isLedig (LocalDate dato, LocalTime tid) {
        for (Reservation reservation : this.reservationer) {
            if (reservation.getDato() == dato && reservation.getStartTid() == tid) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<LocalTime> getLedigeTiderPaaDag (LocalDate dato) {
        ArrayList<LocalTime> ledigeTider = new ArrayList<>();

        for (int i = 6; i <= 22; i++) {
            ledigeTider.add(LocalTime.of(i, 0));
        }

        for (Reservation reservation : reservationer) {
            ledigeTider.remove(reservation.getStartTid());
        }

        return ledigeTider;
    }

    @Override
    public String toString () {
        return this.nummer + " " + this.baneInfo;
    }

}
