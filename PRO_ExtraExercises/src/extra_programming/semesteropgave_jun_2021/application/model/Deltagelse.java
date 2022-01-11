package extra_programming.semesteropgave_jun_2021.application.model;

public class Deltagelse {

    private boolean afbud;
    private String begrundelse;

    private Spiller spiller;

    public Deltagelse(Spiller spiller) {
        this.spiller = spiller;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setAfbud (boolean afbud) {
        this.afbud = afbud;
    }

    public boolean isAfbud() {
        return this.afbud;
    }

    public void setBegrundelse(String begrundelse) {
        this.begrundelse = begrundelse;
    }

    public String getBegrundelse() {
        return this.begrundelse;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setSpiller (Spiller spiller) {
        if (spiller != null && spiller != this.spiller) {
            if (this.spiller != null) {
                this.spiller.removeDeltagelse(this);
            }

            this.spiller = spiller;
            spiller.addDeltagelse(this);
        }
    }

    public Spiller getSpiller() {
        return this.spiller;
    }

}
