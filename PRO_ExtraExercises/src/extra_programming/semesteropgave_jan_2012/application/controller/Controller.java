package extra_programming.semesteropgave_jan_2012.application.controller;

import extra_programming.semesteropgave_jan_2012.application.model.Hold;
import extra_programming.semesteropgave_jan_2012.application.model.Medlem;
import extra_programming.semesteropgave_jan_2012.application.model.Tilmelding;
import extra_programming.semesteropgave_jan_2012.storage.Storage;

import java.util.ArrayList;

public abstract class Controller {

    public static Hold createHold (String navn, String disciplin, int maxAntal) {
        Hold hold = new Hold(navn, disciplin, maxAntal);
        Storage.storeHold(hold);
        return hold;
    }

    public static void updateHold (Hold hold, String navn, String disciplin, int maxAntal) {
        hold.setNavn(navn);
        hold.setDisciplin(disciplin);
        hold.setMaxAntal(maxAntal);
    }

    public static ArrayList<Hold> getAlleHold () {
        return Storage.getAlleHold();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Tilmelding createTilmelding (Hold hold, boolean aktiv, boolean VIPmedlem, Medlem medlem) {
        return hold.createTilmelding(aktiv, VIPmedlem, medlem);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Medlem createMedlem (String navn, String adresse, String email, int mobiltlf) {
        Medlem medlem = new Medlem(navn, adresse, email, mobiltlf);
        Storage.storeMedlem(medlem);
        return medlem;
    }

    public static ArrayList<Medlem> getMedlemmer () {
        return Storage.getMedlemmer();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void createSomeObjects () {
        Hold h1 = createHold("Hold1", "Disciplin1", 5);
        Hold h2 = createHold("Hold2", "Disciplin2", 5);

        Medlem m1 = createMedlem("Peter", "Herning", "peter@gmail.com", 11112222);
        Medlem m2 = createMedlem("Jens", "Viborg", "jens@gmail.com", 33334444);
        Medlem m3 = createMedlem("Berta", "Cercedia", "berta@gmail.com", 55556666);
        Medlem m4 = createMedlem("Lukas", "Aarhus", "lukas@gmail.com", 77778888);
        Medlem m5 = createMedlem("Lasse", "Odense", "lasse@gmail.com", 99990000);

        Tilmelding t1 = createTilmelding(h1, true, true, m1);
        Tilmelding t2 = createTilmelding(h1, true, false, m2);
        Tilmelding t3 = createTilmelding(h1, true, true, m3);
        Tilmelding t4 = createTilmelding(h2, true, false, m4);
        Tilmelding t5 = createTilmelding(h2, true, true, m5);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Hold> findStoreHold (int antal) {
        ArrayList<Hold> storeHold = new ArrayList<>();

        for (Hold hold : getAlleHold()) {
            if (hold.getMaxAntal() >= antal) {
                storeHold.add(hold);
            }
        }

        return storeHold;
    }

}
