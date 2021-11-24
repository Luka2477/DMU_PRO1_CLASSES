package extra_programming.opgave_med_gui_11_17.opgave3;

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

    public PersonChip findPersonChip (String navn) {
        for (PersonChip personChip : this.personChips) {
            if (personChip.getNavn().equalsIgnoreCase(navn)) {
                return personChip;
            }
        }
        return null;
    }

    public ArrayList<String> oversigtFaciliteter (String navn) {
        PersonChip personChip = this.findPersonChip(navn);

        if (personChip != null) {
            ArrayList<String> strings = new ArrayList<>();
            for (Facilitet facilitet : personChip.getFaciliteter()) {
                strings.add(String.format("Navn: %s | Pris: %d", facilitet.getNavn(), facilitet.getPris()));
            }
            return strings;
        }
        return null;
    }

}
