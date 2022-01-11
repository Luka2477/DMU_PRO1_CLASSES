package extra_programming.semesteropgave_jun_2021.application.model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp> {

    private String sted;
    private LocalDate dato;
    private LocalTime tid;

    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getSted() {
        return this.sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getDato() {
        return this.dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getTid() {
        return this.tid;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }


    //------------------------------------------------------------------------------------------------------------------

    public Deltagelse createDeltagelse (Spiller spiller) {
        Deltagelse deltagelse = new Deltagelse(spiller);
        this.deltagelser.add(deltagelse);
        return deltagelse;
    }

    public boolean deleteDeltagelse (Deltagelse deltagelse) {
        boolean found = this.deltagelser.remove(deltagelse);

        if (found) {
            deltagelse.setSpiller(null);
        }

        return found;
    }

    public ArrayList<Deltagelse> getDeltagelser () {
        return new ArrayList<>(this.deltagelser);
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<String> afbud () {
        ArrayList<String> afbud = new ArrayList<>();

        for (Deltagelse deltagelse : this.deltagelser) {
            if (deltagelse.isAfbud()) {
                afbud.add(deltagelse.getSpiller().getNavn() + " | " + deltagelse.getBegrundelse());
            }
        }

        return afbud;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public int compareTo (Kamp kamp) {
        int compare = this.dato.compareTo(kamp.getDato());

        if (compare == 0) {
            compare = this.tid.compareTo(kamp.getTid());

            if (compare == 0) {
                compare = this.sted.compareTo(kamp.getSted());
            }
        }

        return compare;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void spillerHonorar (String tekstFil) {
        try {
            PrintWriter writer = new PrintWriter(tekstFil);

            for (Deltagelse deltagelse : this.deltagelser) {
                if (!deltagelse.isAfbud()) {
                    Spiller spiller = deltagelse.getSpiller();
                    double honorar = (spiller instanceof Professionel) ? ((Professionel) spiller).getKampHonorar() : 10;

                    writer.printf("%s | %.2f%n", spiller.getNavn(), honorar);
                }
            }

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return String.format("%s\t  %s  %s", this.sted, this.dato.format(dtf), this.tid);
    }

}
