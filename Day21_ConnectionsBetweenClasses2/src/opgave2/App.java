package opgave2;

public class App {

    public static void main(String[] args) {
        Person person = new Person("Lukas Knudsen", 21);
        Person person2 = new Person("Sidsel", 22);

        Gift computer = new Gift("Computer");
        computer.setPrice(2000);
        computer.setPerson(person);
        Gift starwars = new Gift("Starwars");
        starwars.setPrice(100);
        starwars.setPerson(person2);
        Gift superman = new Gift("Super man");
        superman.setPrice(150);
        superman.setPerson(person2);

        person.addGift(computer);
        person.addGift(starwars);
        person.addGift(superman);

        System.out.println(person);
        System.out.println(person.getTotalPrice());
        System.out.println(person.getGiftPersons());
    }
}
