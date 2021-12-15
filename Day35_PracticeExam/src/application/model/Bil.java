package application.model;

public class Bil {

    private String regNr;
    private Bilmærke mærke;

    public Bil(String regNr, Bilmærke mærke) {
        this.regNr = regNr;
        this.mærke = mærke;
    }

    public String getRegNr() {
        return this.regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public Bilmærke getMærke() {
        return this.mærke;
    }

    public void setMærke(Bilmærke mærke) {
        this.mærke = mærke;
    }
}
