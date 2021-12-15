package extra_programming.semesteropgave_jan_2019.application.model;

public class Plads {

    private final int række, nr, pris;

    public Plads(int række, int nr, int pris) {
        this.række = række;
        this.nr = nr;
        this.pris = pris;
    }

    public int getRække() {
        return this.række;
    }

    public int getNr() {
        return this.nr;
    }

    public int getPris() {
        return this.pris;
    }

    @Override
    public String toString () {
        return String.format("Række: %d, nr: %d, kr %d", this.række, this.nr, this.pris);
    }

}
