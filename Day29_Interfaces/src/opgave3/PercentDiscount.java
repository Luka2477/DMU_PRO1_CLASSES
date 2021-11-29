package opgave3;

public class PercentDiscount implements Discount {

    private int discountPercentage;

    public PercentDiscount (int discountPercentage) {
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
