package opgave2;

class Synsmand extends Mekaniker {
    private int synDenneUge = 0;

    Synsmand (String navn, String adresse, int svendeproeveAar, int timeloenssats) {
        super(navn, adresse, svendeproeveAar, timeloenssats);
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
