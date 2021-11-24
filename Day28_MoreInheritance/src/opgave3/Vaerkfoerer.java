package opgave3;

class Vaerkfoerer extends Ansat {
    private int udnaevnelsesaar;
    private int tillaegPrUge;

    Vaerkfoerer (String navn, String adresse, int timeloenssaats, int udnaevnelsesaar, int tillaegPrUge) {
        super(navn, adresse, timeloenssaats);

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

    @Override
    public int beregnLoen () {
        return super.beregnLoen() + this.tillaegPrUge * 37;
    }
}
