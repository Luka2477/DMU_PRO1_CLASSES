package extra_programming.semesteropgave_jan_2012.application.model;

import java.util.ArrayList;

public class Medlem implements Comparable<Medlem> {

    private String navn, adresse, email;
    private int mobiltlf;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Medlem(String navn, String adresse, String email, int mobiltlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.email = email;
        this.mobiltlf = mobiltlf;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNavn() {
        return this.navn;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getEmail() {
        return this.email;
    }

    public int getMobiltlf() {
        return this.mobiltlf;
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(this.tilmeldinger);
    }

    public void addTilmelding (Tilmelding tilmelding) {
        if (!this.tilmeldinger.contains(tilmelding)) {
            this.tilmeldinger.add(tilmelding);
            tilmelding.setMedlem(this);
        }
    }

    public boolean removeTilmelding (Tilmelding tilmelding) {
        boolean found = this.tilmeldinger.remove(tilmelding);

        if (found) {
            tilmelding.setMedlem(null);
        }

        return found;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public int compareTo (Medlem medlem) {
        return this.navn.compareTo(medlem.getNavn());
    }

}
