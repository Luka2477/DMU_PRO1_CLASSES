package opgave3;

class Synsmand extends Mekaniker {
    private int synDenneUge = 0;

    Synsmand (String navn, String adresse, int timeloenssats, int svendeproeveAar) {
        super(navn, adresse, timeloenssats, svendeproeveAar);
    }

    public void addSyn () {
        this.synDenneUge++;
    }

    public int getSynDenneUge() {
        return this.synDenneUge;
    }

    public void setSynDenneUge(int synDenneUge) {
        this.synDenneUge = synDenneUge;
    }

    @Override
    public int beregnLoen () {
        return super.beregnLoen() + this.synDenneUge * 29;
    }
}
