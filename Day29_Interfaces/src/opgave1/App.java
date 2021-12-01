package opgave1;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Chili c1 = new Chili("1", 100000);
        Chili c2 = new Chili("2", 20000);
        Chili c3 = new Chili("3", 150000);

        System.out.println(Arrays.asList(c1, c2, c3));
        System.out.println(App.max(new Measurable[]{c1, c2, c3}));
        System.out.println(App.avg(new Measurable[]{c1, c2, c3}));
    }

    public static Measurable max (Measurable[] objects) {
        double max = Double.MIN_VALUE;
        Measurable maxMeasurable = null;
        for (Measurable measurable : objects) {
            if (measurable.getMeasure() > max) {
                max = measurable.getMeasure();
                maxMeasurable = measurable;
            }
        }
        return maxMeasurable;
    }

    public static double avg (Measurable[] objects) {
        double sum = 0.0;
        for (Measurable measurable : objects) {
            sum += measurable.getMeasure();
        }
        return sum / objects.length;
    }
}
