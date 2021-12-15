package application.model;

import java.util.ArrayList;

public class Parkeringshus {

    private String adresse;

    private ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();
    private int saldo = 0;

    public Parkeringshus(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void addSaldo(int saldo) {
        this.saldo += saldo;
    }

    public Parkeringsplads createParkeringsplads (int nummer) {
        Parkeringsplads parkeringsplads = new Parkeringsplads(this, nummer);
        this.parkeringspladser.add(parkeringsplads);
        return parkeringsplads;
    }

    public Invalideplads createInvalideplads (int nummer, double areal) {
        Invalideplads invalideplads = new Invalideplads(this, nummer, areal);
        this.parkeringspladser.add(invalideplads);
        return invalideplads;
    }

    public void addParkeringsplads (Parkeringsplads parkeringsplads) {
        if (!this.parkeringspladser.contains(parkeringsplads)) {
            this.parkeringspladser.add(parkeringsplads);
            parkeringsplads.setParkeringshus(this);
        }
    }

    public boolean removeParkeringsplads (Parkeringsplads parkeringsplads) {
        boolean removed = this.parkeringspladser.remove(parkeringsplads);

        if (removed) {
            parkeringsplads.setParkeringshus(null);
        }

        return removed;
    }

    public ArrayList<Parkeringsplads> getParkeringspladser () {
        return new ArrayList<>(this.parkeringspladser);
    }

    public int antalLedigePladser () {
        int ledigePladser = 0;

        for (Parkeringsplads plads : this.parkeringspladser) {
            if (plads.getBil() != null) {
                ledigePladser++;
            }
        }

        return ledigePladser;
    }

    public int findPladsMedBil (String regNummer) {
        int i = 0;
        int pladsNummer = -1;

        while (i < this.parkeringspladser.size() && pladsNummer == -1) {
            Parkeringsplads plads = this.parkeringspladser.get(i);

            if (plads.getBil().getRegNr().equals(regNummer)) {
                pladsNummer = plads.getNummer();
            } else {
                i++;
            }
        }

        return pladsNummer;
    }

    public int findAntalBiler (Bilmærke mærke) {
        int antalBiler = 0;

        for (Parkeringsplads plads : this.parkeringspladser) {
            if (plads.getBil() != null && plads.getBil().getMærke() == mærke) {
                antalBiler++;
            }
        }

        return antalBiler;
    }

    public ArrayList<String> optagnePladser () {
        ArrayList<String> optagnePladser = new ArrayList<>();

        for (Parkeringsplads plads : this.parkeringspladser) {
            Bil bil = plads.getBil();

            if (bil != null) {
                optagnePladser.add(String.format("Plads %d: %s, %s", plads.getNummer(), bil.getRegNr(), bil.getMærke().getStr()));
            }
        }

        return optagnePladser;
    }

    @Override
    public String toString () {
        return this.adresse;
    }

}
