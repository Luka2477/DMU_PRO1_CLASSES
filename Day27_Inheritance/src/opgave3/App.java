package opgave3;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Product p1 = new Product(0, "Banan", 10);
        Product p2 = new Product(1, "Citron", 12);
        Product p3 = new Product(2, "Advocado", 18);
        Product p4 = new Product(3, "Oksekød (250g)", 25);
        Product p5 = new Product(4, "Kiks", 15);

        PercentDiscount d1 = new PercentDiscount(15);
        FixedDiscount d2 = new FixedDiscount(250, 1000);

        Customer c1 = new Customer("Lukas Knudsen", LocalDate.of(2000, 2, 19), d1);
        Customer c2 = new Customer("Lasse Knudsen", LocalDate.of(1996, 6, 16), d2);

        Order o1 = new Order(0);
        o1.createOrderLine(6, p1);
        o1.createOrderLine(2, p2);
        Order o2 = new Order(1);
        o2.createOrderLine(2, p3);
        o2.createOrderLine(1, p4);

        c1.addOrder(o1);
        c1.addOrder(o2);

        Order o3 = new Order(0);
        o3.createOrderLine(4, p3);
        o3.createOrderLine(5, p4);
        Order o4 = new Order(1);
        o4.createOrderLine(2, p5);
        o4.createOrderLine(10, p3);
        Order o5 = new Order(2);
        o5.createOrderLine(4, p2);
        o5.createOrderLine(12, p1);
        Order o6 = new Order(3);
        o6.createOrderLine(20, p4);
        o6.createOrderLine(4, p5);

        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);
        c2.addOrder(o6);

        System.out.printf("%s samlet køb uden rabat: %f | med rabat: %f%n", c1.getName(), c1.totalBuy(), c1.totalBuyWithDiscount());
        System.out.printf("%s samlet køb uden rabat: %f | med rabat: %f%n", c2.getName(), c2.totalBuy(), c2.totalBuyWithDiscount());
    }
}
