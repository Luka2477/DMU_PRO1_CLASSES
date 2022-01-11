package extra_programming.semesteropgave_jun_2021.application.model;

import java.util.ArrayList;

public class Spiller {

    private String navn;
    private int årgang;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller(String navn, int årgang) {
        this.navn = navn;
        this.årgang = årgang;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNavn() {
        return this.navn;
    }

    public int getÅrgang() {
        return this.årgang;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void addDeltagelse (Deltagelse deltagelse) {
        if (!this.deltagelser.contains(deltagelse)) {
            this.deltagelser.add(deltagelse);
            deltagelse.setSpiller(this);
        }
    }

    public boolean removeDeltagelse (Deltagelse deltagelse) {
        boolean found = this.deltagelser.remove(deltagelse);

        if (found) {
            deltagelse.setSpiller(null);
        }

        return found;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return this.deltagelser;
    }

    //------------------------------------------------------------------------------------------------------------------

    public double kampHonorar () {
        double honorar = 0.0;

        for (Deltagelse deltagelse : this.deltagelser) {
            if (!deltagelse.isAfbud()) {
                honorar += 10;
            }
        }

        return honorar;
    }

}
