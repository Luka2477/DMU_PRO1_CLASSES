package application.model;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads {

    private double areal;

    public Invalideplads(Parkeringshus parkeringshus, int nummer, double areal) {
        super(parkeringshus, nummer);
        this.areal = areal;
    }

    public double getAreal() {
        return this.areal;
    }

    public void setAreal(double areal) {
        this.areal = areal;
    }

    @Override
    public int beregnPris (LocalTime afgang) {
        return 0;
    }

}
