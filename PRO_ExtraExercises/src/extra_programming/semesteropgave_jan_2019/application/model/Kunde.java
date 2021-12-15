package extra_programming.semesteropgave_jan_2019.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {

    private final String navn, mobil;

    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public String getNavn() {
        return this.navn;
    }

    public String getMobil() {
        return this.mobil;
    }

    public void addBestilling (Bestilling bestilling) {
        if (!this.bestillinger.contains(bestilling)) {
            this.bestillinger.add(bestilling);
            bestilling.setKunde(this);
        }
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(this.bestillinger);
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPåDag (Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> bestiltePladser = new ArrayList<>();

        for (Bestilling bestilling : this.bestillinger) {
            if (bestilling.getForestilling() == forestilling && bestilling.getDato().equals(dato)) {
                bestiltePladser.addAll(bestilling.getPladser());
            }
        }

        return bestiltePladser;
    }

    @Override
    public String toString () {
        return this.navn + " " + this.mobil;
    }
}
