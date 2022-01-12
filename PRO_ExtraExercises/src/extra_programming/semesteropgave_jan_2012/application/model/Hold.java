package extra_programming.semesteropgave_jan_2012.application.model;

import java.util.ArrayList;

public class Hold {

    private String navn, disciplin;
    private int maxAntal;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Hold(String navn, String disciplin, int maxAntal) {
        this.navn = navn;
        this.disciplin = disciplin;
        this.maxAntal = maxAntal;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getDisciplin() {
        return this.disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public int getMaxAntal() {
        return this.maxAntal;
    }

    public void setMaxAntal(int maxAntal) {
        this.maxAntal = maxAntal;
    }


    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(this.tilmeldinger);
    }

    public Tilmelding createTilmelding (boolean aktiv, boolean VIPmedlem, Medlem medlem) {
        Tilmelding tilmelding = new Tilmelding(aktiv, VIPmedlem, medlem);
        this.tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    public void addTilmelding (Tilmelding tilmelding) {
        if (!this.tilmeldinger.contains(tilmelding)) {
            this.tilmeldinger.add(tilmelding);
        }
    }

    public boolean removeTilmelding (Tilmelding tilmelding) {
        return this.tilmeldinger.remove(tilmelding);
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getAntalTilmeldinger (String adresse) {
        int tilmeldinger = 0;

        for (Tilmelding tilmelding : this.tilmeldinger) {
            if (tilmelding.getMedlem().getAdresse().equalsIgnoreCase(adresse)) {
                tilmeldinger++;
            }
        }

        return tilmeldinger;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Medlem findVipMedlem () {
        int i = 0;
        Medlem vipMedlem = null;

        while (i < this.tilmeldinger.size() && vipMedlem == null) {
            Tilmelding tilmelding = this.tilmeldinger.get(i);

            if (tilmelding.isVIPmedlem()) {
                vipMedlem = tilmelding.getMedlem();
            } else {
                i++;
            }
        }

        return vipMedlem;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString () {
        return this.navn;
    }

}
