package extra_programming.semesteropgave_jan_2012.application.model;

public class Tilmelding {

    private boolean aktiv, VIPmedlem;

    private Medlem medlem;

    public Tilmelding(boolean aktiv, boolean VIPmedlem, Medlem medlem) {
        this.aktiv = aktiv;
        this.VIPmedlem = VIPmedlem;
        this.medlem = medlem;
    }

    //------------------------------------------------------------------------------------------------------------------

    public boolean isAktiv() {
        return this.aktiv;
    }

    public boolean isVIPmedlem() {
        return this.VIPmedlem;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Medlem getMedlem() {
        return this.medlem;
    }

    public void setMedlem (Medlem medlem) {
        if (this.medlem != medlem) {
            if (this.medlem != null) {
                this.medlem.removeTilmelding(this);
            }

            if (medlem != null) {
                medlem.addTilmelding(this);
            }

            this.medlem = medlem;
        }
    }

}
