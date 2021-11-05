package opgave2;

public class Gift {
    private final String description;
    private double price;

    private Person person;

    public Gift (String description) {
        this.description = description;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public double getPrice () {
        return this.price;
    }

    public void setPerson (Person person) {
        this.person = person;
    }

    public Person getPerson () {
        return this.person;
    }
}
