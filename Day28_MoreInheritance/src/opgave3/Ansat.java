package opgave3;

abstract class Ansat extends Person {

    private int timeloenssats;

    Ansat (String navn, String adresse, int timeloenssats) {
        super(navn, adresse);

        this.timeloenssats = timeloenssats;
    }

    public int getTimeloenssats() {
        return this.timeloenssats;
    }

    public void setTimeloenssats(int timeloenssats) {
        this.timeloenssats = timeloenssats;
    }

    public int beregnLoen () {
        return this.timeloenssats * 37;
    }
}
