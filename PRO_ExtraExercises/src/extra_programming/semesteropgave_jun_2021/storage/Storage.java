package extra_programming.semesteropgave_jun_2021.storage;

import extra_programming.semesteropgave_jun_2021.application.model.Kamp;
import extra_programming.semesteropgave_jun_2021.application.model.Spiller;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<Kamp> kampe = new ArrayList<>();
    private static ArrayList<Spiller> spillere = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------

    public static void storeKamp (Kamp kamp) {
        if (!kampe.contains(kamp)) {
            kampe.add(kamp);
        }
    }

    public static ArrayList<Kamp> getKampe() {
        return new ArrayList<>(kampe);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void storeSpiller (Spiller spiller) {
        if (!spillere.contains(spiller)) {
            spillere.add(spiller);
        }
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }

}
