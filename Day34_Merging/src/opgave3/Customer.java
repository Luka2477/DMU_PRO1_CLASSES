package opgave3;

public class Customer implements Comparable<Customer> {

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo (Customer customer) {
        int comp = this.name.compareTo(customer.getName());

        if (comp == 0) {
            comp = this.age - customer.getAge();
        }

        return comp;
    }

    @Override
    public String toString () {
        return this.name + " " + this.age;
    }

}
