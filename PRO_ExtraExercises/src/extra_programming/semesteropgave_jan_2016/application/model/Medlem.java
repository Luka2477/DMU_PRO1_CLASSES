package extra_programming.semesteropgave_jan_2016.application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {

    private String navn, mobil, mail;

    private ArrayList<Reservation> bookerReservationer = new ArrayList<>();
    private ArrayList<Reservation> makkerReservationer = new ArrayList<>();

    public Medlem(String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNavn() {
        return this.navn;
    }

    public String getMobil() {
        return this.mobil;
    }

    public String getMail() {
        return this.mail;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Reservation createReservation (LocalDate dato, LocalTime startTid, Bane bane, Medlem makker) {
        Reservation reservation = new Reservation(dato, startTid, bane, this, makker);
        this.bookerReservationer.add(reservation);
        return reservation;
    }

    public void addBookerReservation (Reservation reservation) {
        if (!this.bookerReservationer.contains(reservation)) {
            this.bookerReservationer.add(reservation);
            reservation.setBooker(this);
        }
    }

    public boolean removeBookerReservation (Reservation reservation) {
        return this.bookerReservationer.remove(reservation);
    }

    public ArrayList<Reservation> getBookerReservationer () {
        return new ArrayList<>(this.bookerReservationer);
    }

    //------------------------------------------------------------------------------------------------------------------

    public void addMakkerReservation (Reservation reservation) {
        if (!this.makkerReservationer.contains(reservation)) {
            this.makkerReservationer.add(reservation);
            reservation.setMakker(this);
        }
    }

    public boolean removeMakkerReservation (Reservation reservation) {
        return this.makkerReservationer.remove(reservation);
    }

    public ArrayList<Reservation> getMakkerReservationer () {
        return new ArrayList<>(this.makkerReservationer);
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean hasAktivReservation () {
        LocalDateTime now = LocalDateTime.now();
        ArrayList<Reservation> reservationer = new ArrayList<>(this.bookerReservationer);
        reservationer.addAll(this.makkerReservationer);

        for (Reservation reservation : reservationer) {
            LocalDateTime resDateTime = reservation.getDato().atTime(reservation.getStartTid()).plusHours(1);

            if (resDateTime.isAfter(now)) {
                return true;
            }
        }

        return false;
    }

}
