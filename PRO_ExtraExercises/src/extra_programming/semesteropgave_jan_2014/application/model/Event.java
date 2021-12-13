package extra_programming.semesteropgave_jan_2014.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event implements Comparable<Event> {

    private String navn;
    private LocalDate startDato, slutDato;

    private Arrangement arrangement;
    private ArrayList<Ressource> ressourcer = new ArrayList<>();

    public Event(Arrangement arrangement, String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;

        this.setArrangement(arrangement);
    }

    //------------------------------------------------------------------------------------------------------------------


    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getStartDato() {
        return this.startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return this.slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void setArrangement (Arrangement arrangement) {
        if (this.arrangement == arrangement) {
            return;
        }

        if (arrangement != null) {
            if (this.arrangement != null) {
                this.arrangement.removeEvent(this);
            }

            arrangement.addEvent(this);
        }

        this.arrangement = arrangement;
    }

    public Arrangement getArrangement () {
        return this.arrangement;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void addRessource (Ressource ressource) {
        if (!this.ressourcer.contains(ressource)) {
            this.ressourcer.add(ressource);
            ressource.addEvent(this);
        }
    }

    public boolean removeRessource (Ressource ressource) {
        boolean removed = this.ressourcer.remove(ressource);

        if (removed) {
            ressource.removeEvent(this);
        }

        return removed;
    }

    public ArrayList<Ressource> getRessourcer () {
        return new ArrayList<>(this.ressourcer);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public int compareTo (Event event) {
        int comp = this.startDato.compareTo(event.getStartDato());

        if (comp == 0) {
            comp = this.slutDato.compareTo(event.getSlutDato());
        }

        return comp;
    }

    @Override
    public String toString () {
        return this.navn;
    }

}
