package extra_programming.semesteropgave_jan_2018.application.model;

import java.util.ArrayList;

public class Tutor {

    private String navn, email;

    private Hold hold;
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    //------------------------------------------------------------------------------------------------------------------


    public String getNavn() {
        return this.navn;
    }

    public String getEmail() {
        return this.email;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Hold getHold() {
        return this.hold;
    }

    public void setHold (Hold hold) {
        if (hold != null && this.hold != hold) {
            if (this.hold != null) {
                this.hold.removeTutor(this);
            }

            this.hold = hold;
            hold.addTutor(this);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(this.arrangementer);
    }

    public void addArrangement (Arrangement arrangement) {
        if (!this.arrangementer.contains(arrangement))
        {
            this.arrangementer.add(arrangement);
        }
    }

    public boolean removeArrangement (Arrangement arrangement) {
        return this.arrangementer.remove(arrangement);
    }

    //------------------------------------------------------------------------------------------------------------------

    public double arrangementsPris () {
        double pris = 0.0;

        for (Arrangement arrangement : this.arrangementer) {
            pris += arrangement.getPris();
        }

        return pris;
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean harTidsoverlap (Arrangement arrangementTarget) {
        for (Arrangement arrangement : this.arrangementer) {
            if (arrangement.getDate().compareTo(arrangementTarget.getDate()) == 0
                    &&
                    arrangement.getStartTid().compareTo(arrangementTarget.getStartTid()) <= 0
                    &&
                    arrangement.getSlutTid().compareTo(arrangementTarget.getSlutTid()) >= 0) {
                return true;
            }
        }

        return false;
    }

}
