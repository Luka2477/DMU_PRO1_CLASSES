package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Modellerer en svømmer
 */
public class Svoemmer{
    private String navn;
    private String klub;
    private LocalDate foedselsdag;
    private ArrayList<Double> tider;

    /**
     * Initialiserer en ny svømmer med navn, fødselsdag, klub
     * og tider.
     * Pre: længden af tider er mindst 2
     */
    public Svoemmer(String navn, LocalDate foedselsdag, String klub, ArrayList<Double> tider) {
        this.navn = navn;
        this.foedselsdag = foedselsdag;
        this.klub = klub;
        this.tider = tider;
    }

    /**
     * Returnerer svømmerens navn.
     */
    public String getNavn () {
        return this.navn;
    }

    /**
     * Returnerer svømmerens årgang.
     */
    public LocalDate getFoedselsdag () {
        return this.foedselsdag;
    }

    /**
     * Returnerer svømmerens klub.
     */
    public String getKlub () {
        return this.klub;
    }

    /**
     * Registrerer svømmerens klub
     * @param klub klubbens navn
     */
    public void setKlub (String klub) {
        this.klub = klub;
    }

    /**
     * Returnerer den hurtigste tid svømmeren har opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double bedsteTid () {
        return this.tider.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået
     * Pre: Der er registreret mindst to tider for svømmeren
     */

    public double gennemsnitAfTid () {
        return this.tider.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    /**
     * Returnerer gennemsnittet af de tider svømmeren har
     * opnået idet den langsomste tid ikke er medregnet
     * Pre: Der er registreret mindst to tider for svømmeren
     */
    public double snitUdenDaarligste () {
        ArrayList<Double> temp = new ArrayList<>(this.tider);
        temp.remove(temp.stream().mapToDouble(Double::doubleValue).max().orElse(0.0));
        return temp.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}