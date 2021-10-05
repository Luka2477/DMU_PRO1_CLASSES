package p3_7;

public class PersonTester {
    public static void main(String[] args) {
        Person p = new Person("Lukas");
        System.out.println(p.getFriendNames() + " | Expected: ");
        System.out.println(p.getFriendCount() + " | Expected: 0");

        Person berta = new Person("Berta");
        p.befriend(berta);
        System.out.println(p.getFriendNames() + " | Expected: Berta");
        System.out.println(p.getFriendCount() + " | Expected: 1");

        Person casper = new Person("Casper");
        p.befriend(casper);
        System.out.println(p.getFriendNames() + " | Expected: Berta Casper");
        System.out.println(p.getFriendCount() + " | Expected: 2");

        p.unfriend(berta);
        System.out.println(p.getFriendNames() + " | Expected: Casper");
        System.out.println(p.getFriendCount() + " | Expected: 1");
    }
}
