package opgave3;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        int[] years = {2020, 2021, 2019, 2020, 2018};
        String[] licenses = {"DK 12 345", "DK 12 344", "DK 12 333", "DK 12 222", "DK 11 111"};
        int[] dayPrices = {100, 110, 75, 80, 150};

        Rental rental1 = new Rental(1, "03-11-2021", 14);
        Rental rental2 = new Rental(2, "04-11-2021", 21);

        ArrayList<Car> cars = new ArrayList<>();

        for (int i=0; i<years.length; i++) {
            cars.add(new Car(licenses[i], years[i]));
            cars.get(i).setDayPrice(dayPrices[i]);

            if (i < years.length-1) {
                rental1.addCar(cars.get(i));
            }

            if (i > 0) {
                rental2.addCar(cars.get(i));
            }
        }

        System.out.println("Price for rental 1 is " + rental1.getPrice());
        System.out.println("Price for rental 2 is " + rental2.getPrice());
    }
}
