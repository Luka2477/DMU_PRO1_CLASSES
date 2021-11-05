package opgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private final String name;
    private int age;

    private final ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    @Override
    public String toString () {
        return String.format("My name is %s and I am %d years old!", this.name, this.age);
    }

    public void addGift (Gift gift) {
        if (!this.gifts.contains(gift)) {
            this.gifts.add(gift);
        }
    }

    public void removeGift (Gift gift) {
        this.gifts.remove(gift);
    }

    public ArrayList<Gift> getGifts () {
        return new ArrayList<>(this.gifts);
    }

    public double getTotalPrice () {
        return this.gifts.stream().mapToDouble(Gift::getPrice).sum();
    }

    public List<Person> getGiftPersons () {
        return this.gifts.stream().map(Gift::getPerson).collect(Collectors.toList());
    }
}
