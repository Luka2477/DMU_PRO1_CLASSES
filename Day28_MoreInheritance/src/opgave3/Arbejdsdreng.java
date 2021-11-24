package opgave3;

public class Arbejdsdreng extends Ansat {

    public Arbejdsdreng (String navn, String adresse, int timeloenssats) {
        super(navn, adresse, timeloenssats);
    }

    @Override
    public int beregnLoen () {
        return this.getTimeloenssats() * 25;
    }
}
