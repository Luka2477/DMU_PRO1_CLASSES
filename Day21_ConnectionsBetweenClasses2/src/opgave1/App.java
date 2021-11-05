package opgave1;

import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Rental rental1 = new Rental(1, "03-11-2021", 14);
        Rental rental2 = new Rental(2, "04-11-2021", 21);
        Rental rental3 = new Rental(3, "05-11-2021", 7);
        Rental rental4 = new Rental(4, "06-11-2021", 10);
        Rental rental5 = new Rental(5, "07-11-2021", 25);
        Rental rental6 = new Rental(6, "08-11-2021", 75);

        Car car1 = new Car("a", 2020);
        Car car2 = new Car("b", 2021);
        Car car3 = new Car("c", 2019);
        Car car4 = new Car("d", 2020);
        Car car5 = new Car("e", 2020);
        Car car6 = new Car("f", 2021);
        Car car7 = new Car("g", 2019);
        Car car8 = new Car("h", 2020);

        car1.setDayPrice(100 + new Random().nextInt(100));
        car2.setDayPrice(100 + new Random().nextInt(100));
        car3.setDayPrice(100 + new Random().nextInt(100));
        car4.setDayPrice(100 + new Random().nextInt(100));
        car5.setDayPrice(100 + new Random().nextInt(100));
        car6.setDayPrice(100 + new Random().nextInt(100));
        car7.setDayPrice(100 + new Random().nextInt(100));
        car8.setDayPrice(100 + new Random().nextInt(100));

        rental1.addCar(car1);
        rental1.addCar(car2);
        rental1.addCar(car3);
        rental2.addCar(car1);
        rental2.addCar(car2);
        rental2.addCar(car3);
        rental2.addCar(car4);
        rental2.addCar(car5);
        rental2.addCar(car6);
        rental3.addCar(car7);
        rental3.addCar(car8);
        rental3.addCar(car6);
        rental4.addCar(car5);
        rental5.addCar(car1);
        rental5.addCar(car2);
        rental6.addCar(car1);
        rental6.addCar(car2);
        rental6.addCar(car3);
        rental6.addCar(car7);

        System.out.printf("Price for rental: %f%n", rental1.getPrice());
        System.out.printf("Price for rental: %f%n", rental2.getPrice());
        System.out.printf("Price for rental: %f%n", rental3.getPrice());
        System.out.printf("Price for rental: %f%n", rental4.getPrice());
        System.out.printf("Price for rental: %f%n", rental5.getPrice());
        System.out.printf("Price for rental: %f%n", rental6.getPrice());

        System.out.printf("Longest rental: %d%n", car1.maxDaysRented());
        System.out.printf("Longest rental: %d%n", car2.maxDaysRented());
        System.out.printf("Longest rental: %d%n", car3.maxDaysRented());
        System.out.printf("Longest rental: %d%n", car4.maxDaysRented());
        System.out.printf("Longest rental: %d%n", car5.maxDaysRented());
        System.out.printf("Longest rental: %d%n", car6.maxDaysRented());
        System.out.printf("Longest rental: %d%n", car7.maxDaysRented());
        System.out.printf("Longest rental: %d%n", car8.maxDaysRented());
    }
}
