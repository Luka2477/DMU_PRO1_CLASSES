package opgave3.application.model;

public class Customer {

    private String name;

    public Customer (String name) {
        this.name = name;
    }

    // --------------------------------------------------------

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString () {
        return this.name;
    }
}
