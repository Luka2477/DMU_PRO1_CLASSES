package opgave4;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String adresse;

    private final ArrayList<Bolig> boliger = new ArrayList<>();

    public Kollegie (String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public void setNavn (String navn) {
        this.navn = navn;
    }

    public String getNavn () {
        return this.navn;
    }

    public void setAdresse (String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse () {
        return this.adresse;
    }

    public Bolig createBolig (int kvm, String adresse, int prisPrMaaned) {
        Bolig bolig = new Bolig(kvm, adresse, prisPrMaaned);
        this.boliger.add(bolig);
        return bolig;
    }

    public void addBolig (Bolig bolig) {
        if (!this.boliger.contains(bolig)) {
            this.boliger.add(bolig);
            bolig.setKollegie(this);
        }
    }

    public void removeBolig (Bolig bolig) {
        if (this.boliger.contains(bolig)) {
            this.boliger.remove(bolig);
            bolig.removeKollegie();
        }
    }

    public ArrayList<Bolig> getBoliger () {
        return new ArrayList<>(this.boliger);
    }

    public int getAntalLejeaftaler () {
        return this.boliger.stream().mapToInt(bolig -> bolig.getLejeaftaler().size()).sum();
    }

    public double gennemsnitligAntalDage () {
        int antalDage = 0;
        int antalSlutteLejeaftaler = 0;

        for (Bolig bolig : this.boliger) {
            for (Lejeaftale lejeaftale : bolig.getLejeaftaler()) {
                if (lejeaftale.getTilDato() != null) {
                    antalDage += ChronoUnit.DAYS.between(lejeaftale.getFraDato(), lejeaftale.getTilDato());
                    antalSlutteLejeaftaler++;
                }
            }
        }

        return antalDage / (double) ((antalSlutteLejeaftaler != 0) ? antalSlutteLejeaftaler : 1);
    }
}
