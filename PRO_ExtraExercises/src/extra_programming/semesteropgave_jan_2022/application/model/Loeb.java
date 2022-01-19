package extra_programming.semesteropgave_jan_2022.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Loeb {

    private LocalDate dato, earlyBirdDate;
    private String sted;
    private int normalPris, earlyBirdPris;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Forhindring> forhindringer = new ArrayList<>();

    public Loeb(LocalDate dato, LocalDate earlyBirdDate, String sted, int normalPris, int earlyBirdPris) {
        this.dato = dato;
        this.earlyBirdDate = earlyBirdDate;
        this.sted = sted;
        this.normalPris = normalPris;
        this.earlyBirdPris = earlyBirdPris;
    }

    //------------------------------------------------------------------------------------------------------------------


    public LocalDate getDato() {
        return this.dato;
    }

    public LocalDate getEarlyBirdDate() {
        return this.earlyBirdDate;
    }

    public String getSted() {
        return this.sted;
    }

    public int getNormalPris() {
        return this.normalPris;
    }

    public int getEarlyBirdPris() {
        return this.earlyBirdPris;
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Tilmelding> getTilmeldinger () {
        return new ArrayList<>(this.tilmeldinger);
    }

    public Tilmelding createTilmelding (String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer) {
        Tilmelding tilmelding = new Tilmelding(this, navn, kvinde, tilmeldingsdato, løbeNummer);
        this.tilmeldinger.add(tilmelding);
        return tilmelding;
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Forhindring> getForhindringer () {
        return new ArrayList<>(this.forhindringer);
    }

    public void addForhindring (Forhindring forhindring) {
        if (!this.forhindringer.contains(forhindring)) {
            this.forhindringer.add(forhindring);
            forhindring.addLøb(this);
        }
    }

    public boolean removeForhindring (Forhindring forhindring) {
        boolean found = this.forhindringer.remove(forhindring);

        if (found) {
            forhindring.removeLøb(this);
        }

        return found;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S2

    public int earlyBirdIndtjening () {
        int indtjening = 0;

        for (Tilmelding tilmelding : this.tilmeldinger) {
            if (tilmelding.getTilmeldingsdato().compareTo(this.earlyBirdDate) <= 0) {
                indtjening += this.earlyBirdPris;
            }
        }

        return indtjening;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S5

    public double gennemsnitStrafSekunder (Forhindring forhindring) {
        int count = 0, strafSekunder = 0;

        for (Tilmelding tilmelding : this.tilmeldinger) {
            for (Note note : tilmelding.getNoter()) {
                if (note.getForhindring() == forhindring) {
                    strafSekunder += note.getStafSekunder();
                    count++;
                }
            }
        }

        return (double) strafSekunder / count;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S8

    public String getVinder () {
        int min = Integer.MAX_VALUE;
        Tilmelding vinder = null;

        for (Tilmelding tilmelding : this.tilmeldinger) {
            if (tilmelding.getLøbstid() != -1) {
                if (tilmelding.resultatTid() < min) {
                    min = tilmelding.resultatTid();
                    vinder = tilmelding;
                }
            }
        }

        return String.format("%d %s %d", vinder.getLøbeNummer(), vinder.getNavn(), vinder.resultatTid());
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S9

    public String getInformation (String deltagerNavn) {
        int i = 0;
        Tilmelding deltager = null;

        while (i < this.tilmeldinger.size() && deltager == null) {
            Tilmelding tilmelding = this.tilmeldinger.get(i);

            if (tilmelding.getNavn().equalsIgnoreCase(deltagerNavn)) {
                deltager = tilmelding;
            } else {
                i++;
            }
        }

        return (deltager != null)
                ?
                String.format("Nummer: %d | Navn: %s | Resultattid: %d sek.%nAntal ikke korrekt gennemførte forhindringer: %d",
                deltager.getLøbeNummer(), deltager.getNavn(), deltager.resultatTid(), deltager.getNoter().size())
                :
                "Deltageren findes ikke";
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S11

    @Override
    public String toString () {
        return String.format("%s %tF %d", this.sted, this.dato, this.normalPris);
    }

}
