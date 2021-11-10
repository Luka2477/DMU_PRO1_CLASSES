package opgave1;

public class Hund {
    private String navn;
    private boolean stamtavle;
    private int pris;
    private Race race;

    Hund (String navn, boolean stamtavle, int pris, Race race) {
        this.navn = navn;
        this.stamtavle = stamtavle;
        this.pris = pris;
        this.race = race;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean isStamtavle() {
        return stamtavle;
    }

    public void setStamtavle(boolean stamtavle) {
        this.stamtavle = stamtavle;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
