package application.controller;

import application.model.*;
import storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Controller {

    public static Parkeringshus createParkeringshus (String adresse) {
        Parkeringshus parkeringshus = new Parkeringshus(adresse);
        Storage.addParkeringshus(parkeringshus);
        return parkeringshus;
    }

    public static ArrayList<Parkeringshus> getParkeringshuse () {
        return Storage.getParkeringshuse();
    }

    public static Parkeringsplads createParkeringsplads (Parkeringshus parkeringshus, int nummer) {
        return parkeringshus.createParkeringsplads(nummer);
    }

    public static Invalideplads createInvalideplads (Parkeringshus parkeringshus, int nummer, double areal) {
        return parkeringshus.createInvalideplads(nummer, areal);
    }

    public static Bil createBil (String regNr, Bilmærke mærke) {
        Bil bil = new Bil(regNr, mærke);
        Storage.addBil(bil);
        return bil;
    }

    public static boolean parkerBil (Parkeringsplads parkeringsplads, Bil bil) {
        boolean set = false;

        if (parkeringsplads.getBil() == null) {
            parkeringsplads.setBil(bil);
            set = true;
        }

        return set;
    }

    public static boolean parkerBil (Parkeringshus parkeringshus, Bil bil) {
        boolean set = false;

        for (Parkeringsplads plads : parkeringshus.getParkeringspladser()) {
            if (plads.getBil() == null) {
                parkerBil(plads, bil);
                set = true;
                break;
            }
        }

        return set;
    }

    public static ArrayList<Bil> getBiler () {
        return Storage.getBiler();
    }

    public static void writeOptagnePladser (Parkeringshus hus, String filnavn) {
        try {
            PrintWriter writer = new PrintWriter("day35_practiceexam/textfiler/" + filnavn);

            for (String str : hus.optagnePladser()) {
                writer.println(str);
            }

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initStorage () {
        Bil b1 = createBil("AB 11 222", Bilmærke.AUDI);
        Bil b2 = createBil("EF 33 444", Bilmærke.MERCEDEZ);
        Bil b3 = createBil("BD 55 666", Bilmærke.VW);

        Parkeringshus ph1 = createParkeringshus("Havnegade 12, 8000 Aarhus");

        ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            parkeringspladser.add(createParkeringsplads(ph1, i));
        }

        ArrayList<Invalideplads> invalidepladser = new ArrayList<>();
        for (int i = 101; i <= 110; i++) {
            invalidepladser.add(createInvalideplads(ph1, i, 18));
        }

        parkerBil(parkeringspladser.get(10), b1);
        parkerBil(parkeringspladser.get(66), b2);
        parkerBil(invalidepladser.get(5), b3);
    }





    public static void main(String[] args) {
        initStorage();
        writeOptagnePladser(getParkeringshuse().get(0), "optagnePladser.txt");
    }

}
