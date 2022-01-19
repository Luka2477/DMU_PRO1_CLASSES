package extra_programming.semesteropgave_jan_2022.application.controller;

import extra_programming.semesteropgave_jan_2022.application.model.Forhindring;
import extra_programming.semesteropgave_jan_2022.application.model.Loeb;
import extra_programming.semesteropgave_jan_2022.application.model.Note;
import extra_programming.semesteropgave_jan_2022.application.model.Tilmelding;
import extra_programming.semesteropgave_jan_2022.storage.Storage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    public static Tilmelding createTilmelding (Loeb løb, String navn, boolean kvinde, LocalDate tilmeldingsdato, int løbeNummer) {
        return løb.createTilmelding(navn, kvinde, tilmeldingsdato, løbeNummer);
    }

    public static void løbFuldført (Tilmelding tilmelding, int løbstid) {
        tilmelding.setLøbstid(løbstid);
    }

    public static void registrerStraf (Tilmelding tilmelding, String forhindringsNanv, int strafSekunder) {
        tilmelding.registerStrafPåForhindring(forhindringsNanv, strafSekunder);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Note createNote (Tilmelding tilmelding, int strafSekunder, String forhindringsNavn) {
        return tilmelding.registerStrafPåForhindring(forhindringsNavn, strafSekunder);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Forhindring> getForhindringer () {
        return Storage.getForhindringer();
    }

    public static Forhindring createForhindring (int nummer, String navn) {
        Forhindring forhindring = new Forhindring(nummer, navn);
        Storage.storeForhindring(forhindring);
        return forhindring;
    }

    public static void addForhindringToLøb (Forhindring forhindring, Loeb løb) {
        løb.addForhindring(forhindring);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Loeb> getLøb () {
        return Storage.getLøb();
    }

    public static Loeb createLøb (LocalDate dato, LocalDate earlyBirdDate, String sted, int normalPris, int earlyBirdPris) {
        Loeb løb = new Loeb(dato, earlyBirdDate, sted, normalPris, earlyBirdPris);
        Storage.storeLøb(løb);
        return løb;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S7

    public static void initStorage () {
        Loeb løb = createLøb(LocalDate.of(2021, 8, 23),
                LocalDate.of(2021, 6, 23),
                "Hasle bakker",
                500,
                350);

        Forhindring f1 = createForhindring(1, "Stejl bakke");
        Forhindring f2 = createForhindring(2, "Meget stejl bakke");
        Forhindring f3 = createForhindring(3, "Mudderpøl");
        Forhindring f4 = createForhindring(4, "Over mur");
        Forhindring f5 = createForhindring(5, "Under gitter");

        addForhindringToLøb(f1, løb);
        addForhindringToLøb(f2, løb);
        addForhindringToLøb(f3, løb);
        addForhindringToLøb(f4, løb);
        addForhindringToLøb(f5, løb);

        Tilmelding t1 = createTilmelding(løb, "Sune", false, LocalDate.of(2021, 5, 12), 1);
        Tilmelding t2 = createTilmelding(løb, "Anne", true, LocalDate.of(2021, 7, 12), 2);
        Tilmelding t3 = createTilmelding(løb, "Bent", false, LocalDate.of(2021, 7, 14), 3);
        Tilmelding t4 = createTilmelding(løb, "Ole", false, LocalDate.of(2021, 5, 10), 4);
        Tilmelding t5 = createTilmelding(løb, "Lars", false, LocalDate.of(2021, 4, 8), 5);
        Tilmelding t6 = createTilmelding(løb, "Mette", true, LocalDate.of(2021, 8, 20), 6);

        løbFuldført(t1, 8733);

        løbFuldført(t2, 9132);
        registrerStraf(t2, "Over mur", 90);

        løbFuldført(t4, 8280);
        registrerStraf(t4, "Over mur", 220);

        løbFuldført(t5, 9126);
        registrerStraf(t5, "Over mur", 180);
        registrerStraf(t5, "Under gitter", 410);

        løbFuldført(t6, 12732);
    }

    //------------------------------------------------------------------------------------------------------------------
    // Opgave S10

    public static void resultaterTilFil (Loeb løb, String filNavn) {
        ArrayList<Tilmelding> tilmeldinger = løb.getTilmeldinger();
        tilmeldinger.sort(Tilmelding::compareTo);

        try {
            PrintWriter writer = new PrintWriter(filNavn);

            for (Tilmelding tilmelding : tilmeldinger) {
                if (tilmelding.getLøbstid() != -1) {
                    writer.printf("%-10s   %d%n", tilmelding.getNavn(), tilmelding.resultatTid());
                }
            }

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Til at teste om alt virker som det skal

    public static void main(String[] args) {
        initStorage();

        System.out.println(getLøb());
        System.out.println(getLøb().get(0).getTilmeldinger());
        System.out.println(getLøb().get(0).getVinder());
        System.out.println(getLøb().get(0).getInformation("Ole"));

        resultaterTilFil(getLøb().get(0), "PRO_ExtraExercises/src/extra_programming/semesteropgave_jan_2022/textfiler/resultattider.txt");
    }

}
