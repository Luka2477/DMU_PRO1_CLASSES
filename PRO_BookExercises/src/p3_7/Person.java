package p3_7;

public class Person {
    final private String name;
    private String friends;

    public Person(String inputName) {
        this.name = inputName;
        this.friends = "";
    }

    public String getName() { return this.name; }

    public void befriend(Person p) {
        this.friends += " " + p.getName();
    }

    public void unfriend(Person p) {
        this.friends = this.friends.replace(" " + p.getName(), "");
    }

    public String getFriendNames() {
        return this.friends;
    }

    public int getFriendCount() {
        if(this.friends.length() == 0) return 0;

        int count = this.friends.substring(1).split(" ").length;
        return (count == 0) ? 1 : count;
    }
}
