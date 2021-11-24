package opgave3;

class Mekaniker extends Ansat {

    private int svendeproeveAar;

    Mekaniker (String navn, String adresse, int timeloenssaats, int svendeproeveAar) {
        super(navn, adresse, timeloenssaats);

        this.svendeproeveAar = svendeproeveAar;
    }

    public int getSvendeproeveAar() {
        return this.svendeproeveAar;
    }

    public void setSvendeproeveAar(int svendeproeveAar) {
        this.svendeproeveAar = svendeproeveAar;
    }

}
