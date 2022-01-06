package extra_programming.semesteropgave_jan_2018.storage;

import extra_programming.semesteropgave_jan_2018.application.model.Arrangement;
import extra_programming.semesteropgave_jan_2018.application.model.Tutor;
import extra_programming.semesteropgave_jan_2018.application.model.Uddannelse;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<Uddannelse> uddannelser = new ArrayList<>();
    private static ArrayList<Tutor> tutorer = new ArrayList<>();
    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------


    public static ArrayList<Uddannelse> getUddannelser() {
        return new ArrayList<>(uddannelser);
    }

    public static void storeUddannelse (Uddannelse uddannelse) {
        if (!uddannelser.contains(uddannelse)) {
            uddannelser.add(uddannelse);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(tutorer);
    }

    public static void storeTutorer (Tutor tutor) {
        if (!tutorer.contains(tutor)) {
            tutorer.add(tutor);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public static void storeArrangementer (Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

}
