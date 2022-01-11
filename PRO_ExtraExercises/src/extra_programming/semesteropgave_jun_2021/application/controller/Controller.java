package extra_programming.semesteropgave_jun_2021.application.controller;

import extra_programming.semesteropgave_jun_2021.application.model.Deltagelse;
import extra_programming.semesteropgave_jun_2021.application.model.Kamp;
import extra_programming.semesteropgave_jun_2021.application.model.Professionel;
import extra_programming.semesteropgave_jun_2021.application.model.Spiller;
import extra_programming.semesteropgave_jun_2021.storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {

    public static Kamp createKamp (String sted, LocalDate dato, LocalTime tid) {
        Kamp kamp = new Kamp(sted, dato, tid);
        Storage.storeKamp(kamp);
        return kamp;
    }

    public static void updateKamp (Kamp kamp, String sted, LocalDate dato, LocalTime tid) {
        kamp.setSted(sted);
        kamp.setDato(dato);
        kamp.setTid(tid);
    }

    public static ArrayList<Kamp> getKampe () {
        return Storage.getKampe();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Deltagelse createDeltagelse (Kamp kamp, Spiller spiller) {
        return kamp.createDeltagelse(spiller);
    }

    public static void meldAfbud (Deltagelse deltagelse, String begrundelse) {
        deltagelse.setAfbud(true);
        deltagelse.setBegrundelse(begrundelse);
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Spiller createSpiller (String navn, int årgang) {
        Spiller spiller = new Spiller(navn, årgang);
        Storage.storeSpiller(spiller);
        return spiller;
    }

    public static Professionel createProfessionel (String navn, int årgang, double kampHonorar) {
        Professionel professionel = new Professionel(navn, årgang, kampHonorar);
        Storage.storeSpiller(professionel);
        return professionel;
    }

    public static ArrayList<Spiller> getSpillere () {
        return Storage.getSpillere();
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void createSomeObjects () {
        Spiller peter = createSpiller("Peter Jensen", 1999);
        Spiller lars = createSpiller("Lars Hansen", 2000);
        Spiller morten = createSpiller("Morten Petersen", 1999);

        Professionel sofus = createProfessionel("Sofus Kjeldsen", 1999, 100);
        Professionel janus = createProfessionel("Janus Nielsen", 2000, 120);

        Kamp herning = createKamp("Herning", LocalDate.of(2021, 6, 22), LocalTime.of(10, 30));
        Kamp viborg = createKamp("Viborg", LocalDate.of(2021, 6, 29), LocalTime.of(13, 30));

        Deltagelse delPeterHerning = createDeltagelse(herning, peter);
        Deltagelse delPeterViborg = createDeltagelse(viborg, peter);
        Deltagelse delLarsHerning = createDeltagelse(herning, lars);
        Deltagelse delLarsViborg = createDeltagelse(viborg, lars);
        Deltagelse delMortenHerning = createDeltagelse(herning, morten);
        Deltagelse delMortenViborg = createDeltagelse(viborg, morten);
        Deltagelse delSofusHerning = createDeltagelse(herning, sofus);
        Deltagelse delSofusViborg = createDeltagelse(viborg, sofus);
        Deltagelse delJanusHerning = createDeltagelse(herning, janus);
        Deltagelse delJanusViborg = createDeltagelse(viborg, janus);

        meldAfbud(delPeterHerning, "Skal læse til eksamen");
        meldAfbud(delSofusViborg, "Er syg");
    }

    //------------------------------------------------------------------------------------------------------------------

    public static String findKampSted (LocalDate dato, LocalTime tid) {
        String sted = "";
        int i = 0;
        ArrayList<Kamp> kampe = getKampe();

        while (i < kampe.size() && sted.isEmpty()) {
            Kamp kamp = kampe.get(i);

            if (kamp.getDato().isEqual(dato) && kamp.getTid().equals(tid)) {
                sted = kamp.getSted();
            } else {
                i++;
            }
        }

        return (sted.isEmpty()) ? null : sted;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Kamp> alleKampe (ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
        ArrayList<Kamp> resultat = new ArrayList<>();
        int i1 = 0, i2 = 0;

        while (i1 < list1.size() && i2 < list2.size()) {
            Kamp kamp1 = list1.get(i1), kamp2 = list2.get(i2);
            int compare = kamp1.compareTo(kamp2);

            if (compare < 0) {
                addKampToList(resultat, kamp1);
                i1++;
            } else if (compare > 0) {
                addKampToList(resultat, kamp2);
                i2++;
            } else {
                addKampToList(resultat, kamp1);
                i1++;
                i2++;
            }
        }

        if (i1 < list1.size()) {
            resultat.addAll(list1.subList(i1, list1.size()));
        } else if (i2 < list2.size()) {
            resultat.addAll(list2.subList(i2, list2.size()));
        }

        return resultat;
    }

    private static void addKampToList (ArrayList<Kamp> resultat, Kamp kamp) {
        if (!resultat.contains(kamp)) {
            resultat.add(kamp);
        }
    }

}
