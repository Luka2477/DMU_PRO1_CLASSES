package extra_programming.opgave_med_gui_11_17.opgave1;

import java.util.ArrayList;

class Gruppe {

    private int nr;

    private PersonChip personChip;
    private ArrayList<PersonChip> personChips;

    Gruppe(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return this.nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public PersonChip getPersonChip() {
        return this.personChip;
    }

    public void setPersonChip(PersonChip personChip) {
        this.personChip = personChip;
    }

    public PersonChip createPersonChip (int nr, String navn, int maxSaldo, int alder) {
        PersonChip personChip = new PersonChip(nr, navn, maxSaldo, alder);
        this.personChips.add(personChip);
        return personChip;
    }

    public void removePersonChip (PersonChip personChip) {
        this.personChips.remove(personChip);
    }

    public ArrayList<PersonChip> getPersonChips() {
        return new ArrayList<>(this.personChips);
    }

}
