package extra_programming.semesteropgave_jan_2019.application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Forestilling {

    private final String navn;
    private final LocalDate startDato, slutDato;

    private final ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return this.navn;
    }

    public LocalDate getStartDato() {
        return this.startDato;
    }

    public LocalDate getSlutDato() {
        return this.slutDato;
    }

    public Bestilling createBestilling (Kunde kunde, LocalDate dato) {
        Bestilling bestilling = new Bestilling(this, kunde, dato);
        this.bestillinger.add(bestilling);
        return bestilling;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(this.bestillinger);
    }

    public int antalBestiltePladserPåDag (LocalDate dato) {
        int antal = 0;

        for (Bestilling bestilling : this.bestillinger) {
            if (bestilling.getDato().equals(dato)) {
                antal += bestilling.getPladser().size();
            }
        }

        return antal;
    }

    public LocalDate succesDato () {
        int max = -1;
        LocalDate dato = null;
        int antalDage = (int) ChronoUnit.DAYS.between(this.startDato, this.slutDato.plusDays(1));

        for (int i = 0; i < antalDage; i++) {
            LocalDate currDate = this.startDato.plusDays(i);

            if (this.antalBestiltePladserPåDag(currDate) > max) {
                dato = currDate;
            }
        }

        return dato;
    }

    public boolean erPladsLedig (int række, int nr, LocalDate dato) {
        int i = 0;
        boolean found = false;

        while (i < this.bestillinger.size() && !found) {
            Bestilling bestilling = this.bestillinger.get(i);

            if (bestilling.getDato().equals(dato)) {
                int j = 0;

                while (j < bestilling.getPladser().size() && !found) {
                    Plads plads = bestilling.getPladser().get(j);

                    if (plads.getRække() == række && plads.getNr() == nr) {
                        found = true;
                    } else {
                        j++;
                    }
                }
            }

            if (!found) {
                i++;
            }
        }

        return !found;
    }

    @Override
    public String toString () {
        return String.format("%s %s, %s", this.navn, this.startDato, this.slutDato);
    }

}
