package opgave5;

class Alcohol extends Item {

    private double alcoholPercent;

    Alcohol(String name, double price, String description, double alcoholPercent) {
        super(name, price, description);

        this.alcoholPercent = alcoholPercent;
    }

    @Override
    public double calculatePrice () {
        double taxPrice = this.getPrice() * 1.8;
        return (taxPrice > 90.0) ? this.getPrice() * 2.2 : taxPrice;
    }
}
