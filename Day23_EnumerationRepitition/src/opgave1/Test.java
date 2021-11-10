package opgave1;

import java.util.ArrayList;

public class Test {
    public static int samletPris (ArrayList<Hund> hunde, Race race) {
        int sum = 0;
        for (Hund hund : hunde) {
            if (hund.getRace() == race) {
                sum += hund.getPris();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Hund> hunde = new ArrayList<>();
        hunde.add(new Hund("Fiddo", true, 12000, Race.BOKSER));
        hunde.add(new Hund("Bailey", true, 15000, Race.PUDDEL));
        hunde.add(new Hund("Cody", false, 8000, Race.TERRIER));
        hunde.add(new Hund("Dennis", true, 10000, Race.BOKSER));
        hunde.add(new Hund("Mother", false, 19999, Race.BOKSER));

        System.out.printf("Den samlede pris for boksere er %d%n", samletPris(hunde, Race.BOKSER));
    }
}
