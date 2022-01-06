package extra_programming.semesteropgave_jan_2018.application.model;

import java.util.ArrayList;

public class Uddannelse {

    private String navn;

    private ArrayList<Hold> hold = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    //------------------------------------------------------------------------------------------------------------------


    public String getNavn() {
        return this.navn;
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Hold> getHold() {
        return new ArrayList<>(this.hold);
    }

    public Hold createHold (String betegnelse, String holdleder) {
        Hold hold = new Hold(betegnelse, holdleder, this);
        addHold(hold);
        return hold;
    }

    public void addHold (Hold hold) {
        if (!this.hold.contains(hold)) {
            this.hold.add(hold);
            hold.setUddannelse(this);
        }
    }

    public boolean removeHold (Hold hold) {
        boolean found = this.hold.contains(hold);

        if (found) {
            this.hold.remove(hold);
            hold.setUddannelse(null);
        }

        return found;
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<String> tutorOversigt () {
        ArrayList<String> strings = new ArrayList<>();

        for (Hold hold : this.hold) {
            for (Tutor tutor : hold.getTutorer()) {
                strings.add(String.format("%-20s  %-10s  %-10s  %-25s  %-20s",
                        tutor.getNavn(), this.getNavn(), hold.getBetegnelse(), tutor.getEmail(), hold.getHoldleder()));
            }
        }

        return strings;
    }
}
