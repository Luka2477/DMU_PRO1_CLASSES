package opgave4;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Chili c1 = new Chili("1", 100000);
        Chili c2 = new Chili("2", 20000);
        Chili c3 = new Chili("3", 150000);

        System.out.println(Arrays.asList(c1, c2, c3));
        System.out.println(Data.max(new Measurable[]{c1, c2, c3}));
        System.out.println(Data.avg(new Measurable[]{c1, c2, c3}));
    }

}
