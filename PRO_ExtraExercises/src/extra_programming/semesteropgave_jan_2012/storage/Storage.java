package extra_programming.semesteropgave_jan_2012.storage;

import extra_programming.semesteropgave_jan_2012.application.model.Hold;
import extra_programming.semesteropgave_jan_2012.application.model.Medlem;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static ArrayList<Hold> alleHold = new ArrayList<>();

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }

    public static void storeMedlem (Medlem medlem) {
        if (!medlemmer.contains(medlem)) {
            int i = 0;
            boolean found = false;

            while (i < medlemmer.size() && !found) {
                if (medlemmer.get(i).compareTo(medlem) > 0) {
                    found = true;
                } else {
                    i++;
                }
            }

            medlemmer.add(i, medlem);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Hold> getAlleHold() {
        return new ArrayList<>(alleHold);
    }

    public static void storeHold (Hold hold) {
        if (!alleHold.contains(hold)) {
            alleHold.add(hold);
        }
    }

}
