package p3_6;

public class PersonTester {
    public static void main(String[] args) {
        Person p = new Person("Lukas");
        System.out.println(p.getFriendNames() + " | Expected: ");

        Person berta = new Person("Berta");
        p.befriend(berta);
        System.out.println(p.getFriendNames() + " | Expected: Berta");

        Person casper = new Person("Casper");
        p.befriend(casper);
        System.out.println(p.getFriendNames() + " | Expected: Berta Casper");

        p.unfriend(berta);
        System.out.println(p.getFriendNames() + " | Expected: Casper");
    }
}
