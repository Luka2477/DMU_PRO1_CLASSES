package opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {

    private LocalDate fraDato;
    private LocalDate tilDato;

    private Bolig bolig;

    private ArrayList<Lejer> lejere = new ArrayList<>();

    Lejeaftale (LocalDate fraDato, Bolig bolig) {
        this.fraDato = fraDato;

        this.bolig = bolig;
    }

    public LocalDate getFraDato () {
        return this.fraDato;
    }

    public void setTilDato (LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public LocalDate getTilDato () {
        return this.tilDato;
    }

    public Bolig getBolig () {
        return this.bolig;
    }

    public void addLejer (Lejer lejer) {
        if (!this.lejere.contains(lejer)) {
            this.lejere.add(lejer);
        }
    }

    public void removeLejer (Lejer lejer) {
        this.lejere.remove(lejer);
    }

    public ArrayList<Lejer> getLejere () {
        return new ArrayList<>(this.lejere);
    }
}
