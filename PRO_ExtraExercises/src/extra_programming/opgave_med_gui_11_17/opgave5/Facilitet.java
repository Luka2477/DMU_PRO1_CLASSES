package extra_programming.opgave_med_gui_11_17.opgave5;

import java.util.ArrayList;

class Facilitet {

    private String navn;
    private int minimumsalder;
    private int pris;

    private ArrayList<PersonChip> personChips = new ArrayList<>();

    Facilitet (String navn, int minimumsalder, int pris) {
        this.navn = navn;
        this.minimumsalder = minimumsalder;
        this.pris = pris;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getMinimumsalder() {
        return this.minimumsalder;
    }

    public void setMinimumsalder(int minimumsalder) {
        this.minimumsalder = minimumsalder;
    }

    public int getPris() {
        return this.pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public void addPersonChip (PersonChip personChip) {
        if (!this.personChips.contains(personChip)) {
            this.personChips.add(personChip);
            personChip.addFacilitet(this);
        }
    }

    public void removePersonChip (PersonChip personChip) {
        if (this.personChips.contains(personChip)) {
            this.personChips.remove(personChip);
            personChip.removeFacilitet(this);
        }
    }

    public ArrayList<PersonChip> getPersonChips() {
        return new ArrayList<>(this.personChips);
    }

}
