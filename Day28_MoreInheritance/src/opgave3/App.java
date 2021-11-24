package opgave3;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static int samletLoen (ArrayList<Ansat> list) {
        int sum = 0;
        for (Ansat ansat : list) {
            sum += ansat.beregnLoen();
        }
        return sum;
    }

    public static void main(String[] args) {
        Mekaniker m1 = new Mekaniker("Lukas", "Risdalsvej 46", 200, 2020);
        Mekaniker m2 = new Mekaniker("Hej", "HejMedDig", 350, 2000);

        Vaerkfoerer v1 = new Vaerkfoerer("Jeppe", "En vej", 250, 2021, 100);
        Vaerkfoerer v2 = new Vaerkfoerer("Omar", "En anden vej", 275, 2019, 150);

        ArrayList<Ansat> list = new ArrayList<>(Arrays.asList(m1, m2, v1, v2));

        System.out.println(App.samletLoen(list));

        Synsmand s1 = new Synsmand("Sidsel", "En helt anden vej", 250, 2020);
        s1.setSynDenneUge(15);
        list.add(s1);

        System.out.println(App.samletLoen(list));

        Arbejdsdreng a1 = new Arbejdsdreng("Nicolai Knudsen", "Aarhus", 137);
        list.add(a1);

        System.out.println(App.samletLoen(list));
    }
}
