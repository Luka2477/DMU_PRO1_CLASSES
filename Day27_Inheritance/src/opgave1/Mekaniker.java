package opgave1;

class Mekaniker extends Person {
    private int svendeproeveAar;
    private int timeloenssaats;

    Mekaniker (String navn, String adresse, int svendeproeveAar, int timeloenssaats) {
        super(navn, adresse);

        this.svendeproeveAar = svendeproeveAar;
        this.timeloenssaats = timeloenssaats;
    }

    public int getSvendeproeveAar() {
        return this.svendeproeveAar;
    }

    public void setSvendeproeveAar(int svendeproeveAar) {
        this.svendeproeveAar = svendeproeveAar;
    }

    public int getTimeloenssaats() {
        return this.timeloenssaats;
    }

    public void setTimeloenssaats(int timeloenssaats) {
        this.timeloenssaats = timeloenssaats;
    }
}
