package extra_programming.semesteropgave_jan_2014.storage;

import extra_programming.semesteropgave_jan_2014.application.model.Arrangement;
import extra_programming.semesteropgave_jan_2014.application.model.Ressource;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<Arrangement> arrangementer = new ArrayList<>();
    private static ArrayList<Ressource> ressourcer = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------

    public static void addArrangement (Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

    public static boolean removeArrangement (Arrangement arrangement) {
        return arrangementer.remove(arrangement);
    }

    public static ArrayList<Arrangement> getArrangementer () {
        return new ArrayList<>(arrangementer);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void addRessource (Ressource ressource) {
        if (!ressourcer.contains(ressource)) {
            ressourcer.add(ressource);
        }
    }

    public static boolean removeRessource (Ressource ressource) {
        return ressourcer.remove(ressource);
    }

    public static ArrayList<Ressource> getRessourcer () {
        return new ArrayList<>(ressourcer);
    }

}
