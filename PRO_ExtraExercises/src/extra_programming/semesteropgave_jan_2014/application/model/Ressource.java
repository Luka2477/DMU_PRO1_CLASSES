package extra_programming.semesteropgave_jan_2014.application.model;

import java.util.ArrayList;

public class Ressource {

    private String navn, beskrivelse;

    private ArrayList<Event> events = new ArrayList<>();

    public Ressource(String navn, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }

    //------------------------------------------------------------------------------------------------------------------

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return this.beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    //------------------------------------------------------------------------------------------------------------------

    public void addEvent (Event event) {
        if (!this.events.contains(event)) {
            this.events.add(event);
            event.addRessource(this);
        }
    }

    public boolean removeEvent (Event event) {
        boolean removed = this.events.remove(event);

        if (removed) {
            event.removeRessource(this);
        }

        return removed;
    }

    public ArrayList<Event> getEvents () {
        return new ArrayList<>(this.events);
    }

}
