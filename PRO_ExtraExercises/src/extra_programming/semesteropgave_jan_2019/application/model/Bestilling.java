package extra_programming.semesteropgave_jan_2019.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {

    private LocalDate dato;

    private final Forestilling forestilling;
    private Kunde kunde;
    private final ArrayList<Plads> pladser = new ArrayList<>();

    public Bestilling(Forestilling forestilling, Kunde kunde, LocalDate dato) {
        this.forestilling = forestilling;
        this.dato = dato;

        this.setKunde(kunde);
    }

    public LocalDate getDato() {
        return this.dato;
    }

    public Forestilling getForestilling () {
        return this.forestilling;
    }

    public void setKunde (Kunde kunde) {
        if (kunde != null) {
            kunde.addBestilling(this);
        }

        this.kunde = kunde;
    }

    public Kunde getKunde () {
        return this.kunde;
    }

    public void addPlads (Plads plads) {
        if (!this.pladser.contains(plads)) {
            this.pladser.add(plads);
        }
    }

    public ArrayList<Plads> getPladser () {
        return new ArrayList<>(this.pladser);
    }

    public int samletPris () {
        int samletPris = 0;

        for (Plads plads : this.pladser) {
            samletPris += plads.getPris();
        }

        return samletPris;
    }

}
