package opgave5;

class Food extends Item {

    private int shelfLife;

    Food(String name, double price, String description, int shelfLife) {
        super(name, price, description);

        this.shelfLife = shelfLife;
    }

    @Override
    public double calculatePrice () {
        return this.getPrice() * 1.05;
    }
}
