package extra_programming.semesteropgave_jan_2016.storage;

import extra_programming.semesteropgave_jan_2016.application.model.Bane;
import extra_programming.semesteropgave_jan_2016.application.model.Medlem;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<Bane> baner = new ArrayList<>();
    private static ArrayList<Medlem> medlemmer = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------

    public static void addBane (Bane bane) {
        if (!Storage.baner.contains(bane)) {
            Storage.baner.add(bane);
        }
    }

    public static ArrayList<Bane> getBaner () {
        return new ArrayList<>(Storage.baner);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void addMedlem (Medlem medlem) {
        if (!Storage.medlemmer.contains(medlem)) {
            Storage.medlemmer.add(medlem);
        }
    }

    public static ArrayList<Medlem> getMedlemmer () {
        return new ArrayList<>(Storage.medlemmer);
    }

}
