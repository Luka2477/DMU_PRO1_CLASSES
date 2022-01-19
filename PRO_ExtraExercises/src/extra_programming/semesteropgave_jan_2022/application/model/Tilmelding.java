package extra_programming.semesteropgave_jan_2022.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmelding implements Comparable<Tilmelding> {

    private String navn;
    private boolean kvinde;
    private LocalDate tilmeldingsdato;
    private int løbeNummer, løbstid = -1;

    private Loeb løb;
    private ArrayList<Note> noter = new ArrayList<>();

    public Tilmelding(Loeb løb, String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer) {
        this.løb = løb;
        this.navn = navn;
        this.kvinde = kvinde;
        this.tilmeldingsdato = tilmeldingsdato;
        this.løbeNummer = løbeNummer;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNavn() {
        return this.navn;
    }

    public boolean isKvinde() {
        return this.kvinde;
    }

    public LocalDate getTilmeldingsdato() {
        return this.tilmeldingsdato;
    }

    public int getLøbeNummer() {
        return this.løbeNummer;
    }

    public int getLøbstid() {
        return this.løbstid;
    }

    public void setLøbstid(int løbstid) {
        this.løbstid = løbstid;
    }

    //------------------------------------------------------------------------------------------------------------------

    public Loeb getLøb () {
        return this.løb;
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Note> getNoter () {
        return new ArrayList<>(this.noter);
    }

    public Note createNote (int strafSekunder, Forhindring forhindring) {
        Note note = new Note(strafSekunder, forhindring);
        this.noter.add(note);
        return note;
    }

    public boolean destroyNote (Note note) {
        return this.noter.remove(note);
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S3

    public Note registerStrafPåForhindring (String navnForhindring, int strafSekunder) {
        Forhindring targetForhindring = null;

        for (Forhindring forhindring : this.løb.getForhindringer()) {
            if (forhindring.getNavn().equalsIgnoreCase(navnForhindring)) {
                targetForhindring = forhindring;
            }
        }

        return (targetForhindring != null) ? this.createNote(strafSekunder, targetForhindring) : null;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S4

    public int resultatTid () {
        int strafSekunder = 0;

        for (Note note : this.noter) {
            strafSekunder += note.getStafSekunder();
        }

        return this.løbstid + strafSekunder;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S10

    @Override
    public int compareTo (Tilmelding tilmelding) {
        int compare = ((this.kvinde && tilmelding.isKvinde()) || (!this.kvinde && !tilmelding.kvinde))
                ?
                0
                :
                (this.kvinde && !tilmelding.isKvinde())
                        ?
                        -1
                        :
                        1;

        if (compare == 0) {
            compare = this.resultatTid() - tilmelding.resultatTid();
        }

        return compare;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S11

    @Override
    public String toString () {
        return String.format("%-4d  %s", this.løbeNummer, this.navn);
    }

}
