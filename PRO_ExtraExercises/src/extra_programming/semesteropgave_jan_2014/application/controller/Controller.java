package extra_programming.semesteropgave_jan_2014.application.controller;

import extra_programming.semesteropgave_jan_2014.application.model.Arrangement;
import extra_programming.semesteropgave_jan_2014.application.model.Event;
import extra_programming.semesteropgave_jan_2014.application.model.Ressource;
import extra_programming.semesteropgave_jan_2014.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    public static Arrangement createArrangement (String navn, String ansvarlig, LocalDate premiereDato, int pris) {
        Arrangement arrangement = new Arrangement(navn, ansvarlig, premiereDato, pris);
        Storage.addArrangement(arrangement);
        return arrangement;
    }

    public static boolean removeArrangement (Arrangement arrangement) {
        return Storage.removeArrangement(arrangement);
    }

    public static ArrayList<Arrangement> getArrangementer () {
        return Storage.getArrangementer();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Event createEvent (Arrangement arrangement, String navn, LocalDate startDato, LocalDate slutDato) {
        return arrangement.createEvent(navn, startDato, slutDato);
    }

    public static ArrayList<Event> allEvents () {
        ArrayList<Event> events = new ArrayList<>();

        for (Arrangement arrangement : getArrangementer()) {
            events.addAll(arrangement.getEventer());
        }

        bubbleSort(events);

        return events;
    }

    private static void bubbleSort (ArrayList<Event> events) {
        for (int i = events.size()-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if (events.get(j-1).compareTo(events.get(j)) > 0) {
                    swap(events, j-1, j);
                }
            }
        }
    }

    private static void swap (ArrayList<Event> events, int i1, int i2) {
        Event temp = events.get(i1);
        events.set(i1, events.get(i2));
        events.set(i2, temp);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Ressource createRessource (String navn, String beskrivelse) {
        Ressource ressource = new Ressource(navn, beskrivelse);
        Storage.addRessource(ressource);
        return ressource;
    }

    public static boolean removeRessource (Ressource ressource) {
        return Storage.removeRessource(ressource);
    }

    public static ArrayList<Ressource> getRessourcer () {
        return Storage.getRessourcer();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void initStorage () {
        Arrangement a1 = createArrangement("Stand Up", "Jens Jensen", LocalDate.of(2014, 2, 4), 450);
        Arrangement a2 = createArrangement("Musical", "Lene Krogh", LocalDate.of(2014, 2, 7), 390);

        Ressource r1 = createRessource("Lys show", "Disco lys med 7 kugler");
        Ressource r2 = createRessource("Scene show", "To etagers scene med trappe");

        Event e1 = createEvent(a1, "Prøve 1 del 1", LocalDate.of(2014, 1, 1), LocalDate.of(2014, 1, 1));
        Event e2 = createEvent(a1, "Prøve 1 del 2", LocalDate.of(2014, 1, 15), LocalDate.of(2014, 1, 16));
        Event e3 = createEvent(a1, "Prøve 2 del 1", LocalDate.of(2014, 2, 1), LocalDate.of(2014, 2, 6));
    }

}
