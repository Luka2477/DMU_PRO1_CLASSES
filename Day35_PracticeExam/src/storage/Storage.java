package storage;

import application.model.Bil;
import application.model.Parkeringshus;

import java.util.ArrayList;

public abstract class Storage {

    private static ArrayList<Parkeringshus> parkeringshuse = new ArrayList<>();
    private static ArrayList<Bil> biler = new ArrayList<>();

    public static void addParkeringshus (Parkeringshus parkeringshus) {
        if (!parkeringshuse.contains(parkeringshus)) {
            parkeringshuse.add(parkeringshus);
        }
    }

    public static ArrayList<Parkeringshus> getParkeringshuse () {
        return new ArrayList<>(parkeringshuse);
    }

    public static void addBil (Bil bil) {
        if (!biler.contains(bil)) {
            biler.add(bil);
        }
    }

    public static ArrayList<Bil> getBiler () {
        return new ArrayList<>(biler);
    }

}
