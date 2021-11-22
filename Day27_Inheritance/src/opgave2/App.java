package opgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static int samletLoen (ArrayList<Mekaniker> list) {
        int sum = 0;
        for (Mekaniker mekaniker : list) {
            sum += mekaniker.beregnLoen();
        }
        return sum;
    }

    public static void main(String[] args) {
        Mekaniker m1 = new Mekaniker("Lukas", "Risdalsvej 46", 2020, 200);
        Mekaniker m2 = new Mekaniker("Hej", "HejMedDig", 2000, 350);

        Vaerkfoerer v1 = new Vaerkfoerer("Jeppe", "En vej", 2019, 250, 2021, 100);
        Vaerkfoerer v2 = new Vaerkfoerer("Omar", "En anden vej", 2016, 275, 2019, 150);

        ArrayList<Mekaniker> list = new ArrayList<>(Arrays.asList(m1, m2, v1, v2));

        System.out.println(App.samletLoen(list));

        Synsmand s1 = new Synsmand("Sidsel", "En helt anden vej", 2020, 200);
        s1.setSynDenneUge(15);

        list.add(s1);

        System.out.println(App.samletLoen(list));
    }
}
