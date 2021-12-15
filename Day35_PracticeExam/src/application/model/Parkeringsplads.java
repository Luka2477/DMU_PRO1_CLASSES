package application.model;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Parkeringsplads {

    private int nummer;
    private LocalTime ankomst = null;

    private Parkeringshus parkeringshus;
    private Bil bil;

    public Parkeringsplads(Parkeringshus parkeringshus, int nummer) {
        this.parkeringshus = parkeringshus;
        this.nummer = nummer;
    }

    public int getNummer() {
        return this.nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public LocalTime getAnkomst() {
        return this.ankomst;
    }

    public void setAnkomst(LocalTime ankomst) {
        this.ankomst = ankomst;
    }

    public void setParkeringshus (Parkeringshus parkeringshus) {
        if (parkeringshus != null) {
            if (this.parkeringshus != null) {
                this.parkeringshus.removeParkeringsplads(this);
            }

            parkeringshus.addParkeringsplads(this);
        }

        this.parkeringshus = parkeringshus;
    }

    public Parkeringshus getParkeringshus () {
        return this.parkeringshus;
    }

    public void setBil (Bil bil) {
        this.bil = bil;
        this.ankomst = LocalTime.now();
    }

    public Bil getBil () {
        return this.bil;
    }

    public int beregnPris (LocalTime afgang) {
        int pris = 0;

        if (this.bil != null) {
            int minutter = (int) ChronoUnit.MINUTES.between(this.ankomst, afgang);
            pris = Math.max(minutter, 10) / 10 * 6;
        }

        return pris;
    }

    public void hentBil (LocalTime afgangstidpunkt) {
        if (this.bil != null) {
            this.parkeringshus.addSaldo(this.beregnPris(afgangstidpunkt));
            this.bil = null;
            this.ankomst = null;
        }
    }

}
