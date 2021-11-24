package opgave5;

class Electronics extends Item {

    private double avgEnergyUsePrHour;

    Electronics(String name, double price, String description, double avgEnergyUsePrHour) {
        super(name, price, description);

        this.avgEnergyUsePrHour = avgEnergyUsePrHour;
    }

    @Override
    public double calculatePrice () {
        double tax = this.getPrice() * 0.3;
        return this.getPrice() + ((tax >= 3.0) ? tax : 3);
    }
}
