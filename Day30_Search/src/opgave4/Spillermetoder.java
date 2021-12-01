package opgave4;

import java.util.ArrayList;
import java.util.Comparator;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        Spiller foundSpiller = null;
        int i = 0;

        while (i < spillere.size() && foundSpiller == null) {
            if (spillere.get(i).getMaal() == score) {
                foundSpiller = spillere.get(i);
            } else {
                i++;
            }
        }

        return foundSpiller;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3

    public Spiller findScoreBinær (ArrayList<Spiller> spillere, int score) {
        Spiller foundSpiller = null;
        int left = 0, right = spillere.size()-1;

        while (left <= right && foundSpiller == null) {
            int middle = (left + right) / 2;

            if (spillere.get(middle).getMaal() > score) {
                left = middle + 1;
            } else if (spillere.get(middle).getMaal() < score) {
                right = middle - 1;
            } else {
                foundSpiller = spillere.get(middle);
            }
        }

        return foundSpiller;
    }

    public String godSpiller (ArrayList<Spiller> spillere) {
        int i = 0;
        String navn = "";

        while (i < spillere.size() && navn.isEmpty()) {
            if (spillere.get(i).getMaal() > 50 && spillere.get(i).getHoejde() < 170) {
                navn = spillere.get(i).getNavn();
            } else {
                i++;
            }
        }

        return navn;
    }

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));
        System.out.println();

        // Tilføj kode der afprøver opgaver 4.2 og 4.3

        System.out.println("Spiller der har scoret mere end 50 mål og er mindre end 170cm: " + metoder.godSpiller(spillerListe));
        spillerListe.add(new Spiller("Lukas", 160, 75, 65));
        System.out.println("Spiller der har scoret mere end 50 mål og er mindre end 170cm: " + metoder.godSpiller(spillerListe));
        System.out.println();

        spillerListe.sort(Comparator.comparingInt(Spiller::getMaal).reversed());

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreBinær(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreBinær(spillerListe, 30));
    }

}
