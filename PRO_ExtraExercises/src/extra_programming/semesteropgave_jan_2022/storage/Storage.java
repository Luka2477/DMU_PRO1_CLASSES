package extra_programming.semesteropgave_jan_2022.storage;

import extra_programming.semesteropgave_jan_2022.application.model.Forhindring;
import extra_programming.semesteropgave_jan_2022.application.model.Loeb;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<Loeb> løb = new ArrayList<>();
    private static ArrayList<Forhindring> forhindringer = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Loeb> getLøb() {
        return løb;
    }

    public static void storeLøb (Loeb løb) {
        if (!Storage.løb.contains(løb)) {
            Storage.løb.add(løb);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Forhindring> getForhindringer() {
        return forhindringer;
    }

    public static void storeForhindring (Forhindring forhindring) {
        if (!forhindringer.contains(forhindring)) {
            forhindringer.add(forhindring);
        }
    }

}
