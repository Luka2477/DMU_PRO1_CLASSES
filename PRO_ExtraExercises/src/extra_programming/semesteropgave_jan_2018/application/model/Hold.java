package extra_programming.semesteropgave_jan_2018.application.model;

import java.util.ArrayList;

public class Hold {

    private String betegnelse, holdleder;

    private Uddannelse uddannelse;
    private ArrayList<Tutor> tutorer = new ArrayList<>();

    public Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
        this.uddannelse = uddannelse;
    }

    //------------------------------------------------------------------------------------------------------------------


    public String getBetegnelse() {
        return this.betegnelse;
    }

    public String getHoldleder() {
        return this.holdleder;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Uddannelse getUddannelse() {
        return this.uddannelse;
    }

    public void setUddannelse (Uddannelse uddannelse) {
        if (uddannelse != null && this.uddannelse != uddannelse) {
            if (this.uddannelse != null) {
                this.uddannelse.removeHold(this);
            }

            this.uddannelse = uddannelse;
            uddannelse.addHold(this);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(this.tutorer);
    }

    public void addTutor (Tutor tutor) {
        if (!this.tutorer.contains(tutor)) {
            this.tutorer.add(tutor);
            tutor.setHold(this);
        }
    }

    public boolean removeTutor (Tutor tutor) {
        boolean found = this.tutorer.contains(tutor);

        if (found) {
            this.tutorer.remove(tutor);
            tutor.setHold(null);
        }

        return found;
    }

    //------------------------------------------------------------------------------------------------------------------

    public double arrangementsPris () {
        double pris = 0.0;

        for (Tutor tutor : this.tutorer) {
            pris += tutor.arrangementsPris();
        }

        return pris;
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean harTidsoverlap (Arrangement arrangement) {
        boolean found = false;
        int i = 0;

        while (i < this.tutorer.size() && !found) {
            Tutor tutor = this.tutorer.get(i);

            if (tutor.harTidsoverlap(arrangement)) {
                found = true;
            } else {
                i++;
            }
        }

        return found;
    }

}
