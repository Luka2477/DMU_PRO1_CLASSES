package extra_programming.semesteropgave_jan_2014.application.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Arrangement {

    private String navn, ansvarlig;
    private LocalDate premiereDato;
    private int pris;

    private ArrayList<Event> eventer = new ArrayList<>();

    public Arrangement(String navn, String ansvarlig, LocalDate premiereDato, int pris) {
        this.navn = navn;
        this.ansvarlig = ansvarlig;
        this.premiereDato = premiereDato;
        this.pris = pris;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAnsvarlig() {
        return this.ansvarlig;
    }

    public void setAnsvarlig(String ansvarlig) {
        this.ansvarlig = ansvarlig;
    }

    public LocalDate getPremiereDato() {
        return this.premiereDato;
    }

    public void setPremiereDato(LocalDate premiereDato) {
        this.premiereDato = premiereDato;
    }

    public int getPris() {
        return this.pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Event createEvent (String navn, LocalDate startDato, LocalDate slutDato) {
        if (startDato.isAfter(slutDato)) {
            throw new WrongDateException("Datoer indtastet forkert : " + startDato + " | " + slutDato);
        } else {
            return new Event(this, navn, startDato, slutDato);
        }
    }

    public void addEvent (Event event) {
        if (!this.eventer.contains(event)) {
            this.eventer.add(event);
            event.setArrangement(this);
        }
    }

    public boolean removeEvent (Event event) {
        boolean removed = this.eventer.remove(event);

        if (removed) {
            event.setArrangement(null);
        }

        return removed;
    }

    public ArrayList<Event> getEventer () {
        return new ArrayList<>(this.eventer);
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getAntalLangeEvents () {
        int count = 0;

        for (Event event : this.eventer) {
            if (ChronoUnit.DAYS.between(event.getStartDato(), event.getSlutDato()) > 3) {
                count++;
            }
        }

        return count;
    }

    public Event eventOnDate (LocalDate date) {
        Event event = null;
        int i = 0;

        while (i < this.eventer.size() && event == null) {
            LocalDate start = this.eventer.get(i).getStartDato(), slut = this.eventer.get(i).getSlutDato();

            if (date.isEqual(start) || (date.isAfter(start) && date.isBefore(slut))) {
                event = this.eventer.get(i);
            } else {
                i++;
            }
        }

        return event;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString () {
        return this.navn + " | " + this.ansvarlig + "\n" + this.premiereDato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " | " + this.pris;
    }

}
