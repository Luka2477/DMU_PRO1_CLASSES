package opgave5;

import java.util.ArrayList;
import java.util.Arrays;

class Cart {

    private ArrayList<Item> items = new ArrayList<>();

    public ArrayList<Item> getItems () {
        return new ArrayList<>(this.items);
    }

    public void addItem (Item item) {
        this.items.add(item);
    }

    public void addItems (Item... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void removeItem (Item item) {
        this.items.remove(item);
    }

    public double totalPrice () {
        double sum = 0;
        for (Item item : this.items) {
            sum += item.calculatePrice();
        }
        return sum;
    }

}
