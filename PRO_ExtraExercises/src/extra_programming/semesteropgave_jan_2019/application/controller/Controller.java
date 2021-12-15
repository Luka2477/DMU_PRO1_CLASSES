package extra_programming.semesteropgave_jan_2019.application.controller;

import extra_programming.semesteropgave_jan_2019.application.model.Bestilling;
import extra_programming.semesteropgave_jan_2019.application.model.Forestilling;
import extra_programming.semesteropgave_jan_2019.application.model.Kunde;
import extra_programming.semesteropgave_jan_2019.application.model.Plads;
import extra_programming.semesteropgave_jan_2019.storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Controller {

    public static Forestilling createForestilling (String navn, LocalDate startDato, LocalDate slutDato) {
        Forestilling forestilling = new Forestilling(navn, startDato, slutDato);
        Storage.storeForestilling(forestilling);
        return forestilling;
    }

    public static ArrayList<Forestilling> getForestillinger () {
        return Storage.getForestillinger();
    }

    public static Kunde createKunde (String navn, String mobil) {
        Kunde kunde = new Kunde(navn, mobil);
        Storage.storeKunde(kunde);
        return kunde;
    }

    public static ArrayList<Kunde> getKunder () {
        return Storage.getKunder();
    }

    public static Bestilling createBestillingMedPladser (Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {
        Bestilling bestilling;

        if (dato.isAfter(forestilling.getStartDato()) && dato.isBefore(forestilling.getSlutDato())) {
            for (Plads plads : pladser) {
                if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
                    throw new RuntimeException("Plads på række " + plads.getRække() + " med nr " + plads.getNr() + " er optaget på " + dato);
                }
            }

            bestilling = forestilling.createBestilling(kunde, dato);
            for (Plads plads : pladser) {
                bestilling.addPlads(plads);
            }
        } else {
            throw new RuntimeException("Bestilling fra " + kunde.getNavn() + " på " + dato + " er udenfor forestillingstiderne");
        }

        return bestilling;
    }

    public static void oversigtOverForestillinger (String filnavn) {
        try {
            PrintWriter writer = new PrintWriter("pro_extraexercises/src/extra_programming/semesteropgave_jan_2019/textfiler/" + filnavn);

            for (Forestilling forestilling : getForestillinger()) {
                writer.println(forestilling.getNavn());
            }

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initStorage () {
        Forestilling f1 = createForestilling("Evita", LocalDate.of(2019, 1, 10), LocalDate.of(2019, 1, 20));
        Forestilling f2 = createForestilling("Lykke Per", LocalDate.of(2019, 2, 1), LocalDate.of(2019, 2, 10));
        Forestilling f3 = createForestilling("Chess", LocalDate.of(2019, 1, 21), LocalDate.of(2019, 1, 30));

        Kunde k1 = createKunde("Anders Hansen", "11223344");
        Kunde k2 = createKunde("Peter Jensen", "12345678");
        Kunde k3 = createKunde("Niels Madsen", "12341234");

        ArrayList<Plads> pladser = new ArrayList<>(Arrays.asList(
                new Plads(10, 10, 100),
                new Plads(10, 11, 100)));
        Bestilling b1 = createBestillingMedPladser(f1, k1, LocalDate.of(2019, 1, 15), pladser);
    }





    public static void main(String[] args) {
        initStorage();
        oversigtOverForestillinger("forestillinger.txt");
    }
}
