package p3_6;

public class Person {
    final private String name;
    private String friends;

    public Person(String inputName) {
        this.name = inputName;
        this.friends = "";
    }

    public String getName() {
        return this.name;
    }

    public void befriend(Person p) {
        this.friends += " " + p.getName();
    }

    public void unfriend(Person p) {
        this.friends = this.friends.replace(" " + p.getName(), "");
    }

    public String getFriendNames() {
        return this.friends;
    }
}
