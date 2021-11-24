package extra_programming.opgave_med_gui_11_17.opgave6.application.model;

import java.util.ArrayList;

public class PersonChip {

    private int nr;
    private String navn;
    private int maxSaldo;
    private int alder;

    private ArrayList<Facilitet> faciliteter = new ArrayList<>();

    public PersonChip(int nr, String navn, int maxSaldo, int alder) {
        this.nr = nr;
        this.navn = navn;
        this.maxSaldo = maxSaldo;
        this.alder = alder;
    }

    public int getNr() {
        return this.nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getMaxSaldo() {
        return this.maxSaldo;
    }

    public void setMaxSaldo(int maxSaldo) {
        this.maxSaldo = maxSaldo;
    }

    public int getAlder() {
        return this.alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public void addFacilitet (Facilitet facilitet) {
        if (!this.faciliteter.contains(facilitet)) {
            this.faciliteter.add(facilitet);
            facilitet.addPersonChip(this);
        }
    }

    public void removeFacilitet (Facilitet facilitet) {
        if (this.faciliteter.contains(facilitet)) {
            this.faciliteter.remove(facilitet);
            facilitet.removePersonChip(this);
        }
    }

    public ArrayList<Facilitet> getFaciliteter() {
        return new ArrayList<>(this.faciliteter);
    }

    public boolean checkSaldo (int prisFacilitet) {
        int samledePris = 0;
        for (Facilitet facilitet : this.faciliteter) {
            samledePris += facilitet.getPris();
        }

        return this.maxSaldo - samledePris - prisFacilitet >= 0;
    }

}
