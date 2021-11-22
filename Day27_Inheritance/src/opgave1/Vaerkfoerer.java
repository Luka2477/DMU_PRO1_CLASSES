package opgave1;

class Vaerkfoerer extends Mekaniker {
    private int udnaevnelsesaar;
    private int tillaegPrUge;

    Vaerkfoerer (String navn, String adresse, int svendeproeveAar, int timeloenssaats, int udnaevnelsesaar, int tillaegPrUge) {
        super(navn, adresse, svendeproeveAar, timeloenssaats);

        this.udnaevnelsesaar = udnaevnelsesaar;
        this.tillaegPrUge = tillaegPrUge;
    }

    public int getUdnaevnelsesaar() {
        return this.udnaevnelsesaar;
    }

    public void setUdnaevnelsesaar(int udnaevnelsesaar) {
        this.udnaevnelsesaar = udnaevnelsesaar;
    }

    public int getTillaegPrUge() {
        return this.tillaegPrUge;
    }

    public void setTillaegPrUge(int tillaegPrUge) {
        this.tillaegPrUge = tillaegPrUge;
    }
}
