package extra_programming.semesteropgave_jan_2018.application.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {

    private String titel;
    private LocalDate date;
    private LocalTime startTid, slutTid;
    private double pris;

    public Arrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
        this.titel = titel;
        this.date = date;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.pris = pris;
    }

    //------------------------------------------------------------------------------------------------------------------


    public String getTitel() {
        return this.titel;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public LocalTime getStartTid() {
        return this.startTid;
    }

    public LocalTime getSlutTid() {
        return this.slutTid;
    }

    public double getPris() {
        return this.pris;
    }

}
