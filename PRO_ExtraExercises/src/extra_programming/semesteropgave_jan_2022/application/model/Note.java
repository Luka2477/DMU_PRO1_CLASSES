package extra_programming.semesteropgave_jan_2022.application.model;

public class Note {

    private int stafSekunder;

    private Forhindring forhindring;

    public Note(int stafSekunder, Forhindring forhindring) {
        this.stafSekunder = stafSekunder;
        this.forhindring = forhindring;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getStafSekunder() {
        return this.stafSekunder;
    }

    public Forhindring getForhindring() {
        return this.forhindring;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S11

    @Override
    public String toString () {
        return String.format("%s | Straftid: %d", this.forhindring.getNavn(), this.stafSekunder);
    }

}
