package extra_programming.opgave_med_gui_11_17.opgave6.application.controller;

import extra_programming.opgave_med_gui_11_17.opgave6.application.model.Facilitet;
import extra_programming.opgave_med_gui_11_17.opgave6.application.model.Gruppe;
import extra_programming.opgave_med_gui_11_17.opgave6.application.model.PersonChip;
import extra_programming.opgave_med_gui_11_17.opgave6.storage.Storage;

import java.util.ArrayList;

public class Controller {

    public static Gruppe createGruppe (int nr) {
        Gruppe gruppe = new Gruppe(nr);
        Storage.addGruppe(gruppe);
        return gruppe;
    }

    public static Facilitet createFacilitet (String navn, int minimumsalder, int pris) {
        Facilitet facilitet = new Facilitet(navn, minimumsalder, pris);
        Storage.addFacilitet(facilitet);
        return facilitet;
    }

    public static PersonChip createPersonChip (Gruppe gruppe, int nr, String navn, int maxSaldo, int alder) {
        if (gruppe != null) {
            PersonChip personChip = gruppe.createPersonChip(nr, navn, maxSaldo, alder);
            Storage.addPersonChip(personChip);
            return personChip;
        }
        return null;
    }

    public static ArrayList<Facilitet> getFaciliteter () {
        return Storage.getFaciliteter();
    }

    public static void createSomeObjects () {
        Gruppe gruppe = Controller.createGruppe(1);

        PersonChip peter = Controller.createPersonChip(gruppe, 1, "Peter", 200, 12);
        PersonChip søren = Controller.createPersonChip(gruppe, 2, "Søren", 0, 35);
        PersonChip camilla = Controller.createPersonChip(gruppe, 3, "Camilla", 300, 15);

        Facilitet badeland = Controller.createFacilitet("Badeland", 3, 0);
        Facilitet bowling = Controller.createFacilitet("Bowling", 10, 50);
        Facilitet billard = Controller.createFacilitet("Billard", 15, 75);

        peter.addFacilitet(badeland);
        peter.addFacilitet(billard);

        søren.addFacilitet(badeland);

        camilla.addFacilitet(badeland);
        camilla.addFacilitet(bowling);
        camilla.addFacilitet(billard);
    }
}
