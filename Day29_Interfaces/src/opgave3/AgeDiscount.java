package opgave3;

public class AgeDiscount implements Discount {

    private int age;

    public AgeDiscount(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public double getDiscount (double price) {
        return price * (0.01 * this.age);
    }
}
