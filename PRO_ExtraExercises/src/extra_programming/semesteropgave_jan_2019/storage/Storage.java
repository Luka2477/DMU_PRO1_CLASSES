package extra_programming.semesteropgave_jan_2019.storage;

import extra_programming.semesteropgave_jan_2019.application.model.Forestilling;
import extra_programming.semesteropgave_jan_2019.application.model.Kunde;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static final ArrayList<Kunde> kunder = new ArrayList<>();

    public static void storeForestilling (Forestilling forestilling) {
        if (!forestillinger.contains(forestilling)) {
            forestillinger.add(forestilling);
        }
    }

    public static ArrayList<Forestilling> getForestillinger() {
        return new ArrayList<>(forestillinger);
    }

    public static void storeKunde (Kunde kunde) {
        if (!kunder.contains(kunde)) {
            kunder.add(kunde);
        }
    }

    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }

}
