package extra_programming.semesteropgave_jan_2018.application.controller;

import extra_programming.semesteropgave_jan_2018.application.model.Arrangement;
import extra_programming.semesteropgave_jan_2018.application.model.Hold;
import extra_programming.semesteropgave_jan_2018.application.model.Tutor;
import extra_programming.semesteropgave_jan_2018.application.model.Uddannelse;
import extra_programming.semesteropgave_jan_2018.storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {

    public static ArrayList<Uddannelse> getUddannelser () {
        return Storage.getUddannelser();
    }

    public static Uddannelse createUddannelse (String navn) {
        Uddannelse uddannelse = new Uddannelse(navn);
        Storage.storeUddannelse(uddannelse);
        return uddannelse;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Hold createHold (String betegnelse, String holdleder, Uddannelse uddannelse) {
        return uddannelse.createHold(betegnelse, holdleder);
    }

    public static ArrayList<Hold> holdUdenTutorer () {
        ArrayList<Hold> holdList = new ArrayList<>();

        for (Uddannelse uddannelse : getUddannelser()) {
            for (Hold hold : uddannelse.getHold()) {
                if (hold.getTutorer().isEmpty()) {
                    holdList.add(hold);
                }
            }
        }

        return holdList;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Tutor> getTutorer () {
        return Storage.getTutorer();
    }

    public static Tutor createTutor (String navn, String email) {
        Tutor tutor = new Tutor(navn, email);
        Storage.storeTutorer(tutor);
        return tutor;
    }

    public static void addTutorToHold (Tutor tutor, Hold hold) {
        hold.addTutor(tutor);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Arrangement> getArrangementer () {
        return Storage.getArrangementer();
    }

    public static Arrangement createArrangement (String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
        Arrangement arrangement = new Arrangement(titel, date, startTid, slutTid, pris);
        Storage.storeArrangementer(arrangement);
        return arrangement;
    }

    public static void addArrangementToTutor (Arrangement arrangement, Tutor tutor) {
        if (!tutor.harTidsoverlap(arrangement)) {
            tutor.addArrangement(arrangement);
        } else {
            throw new RuntimeException(String.format("%s kan ikke tage ansvar for %s, da der er tidsoverlap med et andet arrangement.",
                    tutor.getNavn(), arrangement.getTitel()));
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void tutorOversigtTilFil (String filnavn) {
        try {
            PrintWriter writer = new PrintWriter(filnavn);

            writer.println(String.format("%-20s  %-10s  %-10s  %-25s  %-20s", "Tutor", "Uddannelse", "Betegnelse", "E-Mail", "Holdleder"));
            writer.println("-".repeat(93));

            for (Uddannelse uddannelse : getUddannelser()) {
                for (String string : uddannelse.tutorOversigt()) {
                    writer.println(string);
                }
            }

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void initStorage () {
        Uddannelse dmu = createUddannelse("DMU");
        Uddannelse finø = createUddannelse("FINØ");

        Hold s = createHold("1dmE17S", "Margrethe Dybdahl", dmu);
        Hold t = createHold("1dmE17T", "Kristian Dorland", dmu);
        Hold u = createHold("1dmE17U", "Kell Ørhøj", dmu);
        Hold b = createHold("1fiE17B", "Karen Jensen", finø);

        Tutor anders = createTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor peter = createTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor niels = createTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor lone = createTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor mads = createTutor("Mads Miller", "mmm@students.eaaa.dk");

        Arrangement rusfest = createArrangement("Rusfest",
                LocalDate.of(2017, 8, 31),
                LocalTime.of(18, 0),
                LocalTime.of(23, 30),
                250);
        Arrangement fodbold = createArrangement("Fodbold",
                LocalDate.of(2017, 8, 30),
                LocalTime.of(14, 0),
                LocalTime.of(17, 30),
                100);
        Arrangement brætspil = createArrangement("Brætspil",
                LocalDate.of(2017, 8, 29),
                LocalTime.of(12, 0),
                LocalTime.of(16, 30),
                25);
        Arrangement mindeparken = createArrangement("Mindeparken",
                LocalDate.of(2017, 8, 30),
                LocalTime.of(18, 0),
                LocalTime.of(22, 0),
                25);

        //--------------------------------------------------------------------------------------------------------------

        addTutorToHold(anders, s);
        addTutorToHold(lone, s);
        addTutorToHold(peter, u);
        addTutorToHold(niels, u);
        addTutorToHold(mads, b);

        addArrangementToTutor(rusfest, anders);
        addArrangementToTutor(rusfest, peter);
        addArrangementToTutor(rusfest, mads);
        addArrangementToTutor(fodbold, niels);
        addArrangementToTutor(brætspil, lone);
        addArrangementToTutor(brætspil, niels);
        addArrangementToTutor(mindeparken, mads);
        addArrangementToTutor(mindeparken, anders);
    }

}
