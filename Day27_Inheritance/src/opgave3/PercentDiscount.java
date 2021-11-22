package opgave3;

public class PercentDiscount extends Discount {

    private int discountPercentage;

    public PercentDiscount (int discountPercentage) {
        super();

        this.discountPercentage = discountPercentage;
    }

    public int getDiscountPercentage() {
        return this.discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscount (double price) {
        return price * (0.01 * discountPercentage);
    }
}
