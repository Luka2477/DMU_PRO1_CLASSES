package extra_programming.semesteropgave_jan_2022.application.model;

import java.util.ArrayList;

public class Forhindring {

    private int nummer;
    private String navn;

    private ArrayList<Loeb> løb = new ArrayList<>();

    public Forhindring(int nummer, String navn) {
        this.nummer = nummer;
        this.navn = navn;
    }

    //------------------------------------------------------------------------------------------------------------------

    public int getNummer() {
        return this.nummer;
    }

    public String getNavn() {
        return this.navn;
    }

    //------------------------------------------------------------------------------------------------------------------

    public ArrayList<Loeb> getLøb() {
        return this.løb;
    }

    public void addLøb (Loeb løb) {
        if (!this.løb.contains(løb)) {
            this.løb.add(løb);
            løb.addForhindring(this);
        }
    }

    public boolean removeLøb (Loeb løb) {
        boolean found = this.løb.remove(løb);

        if (found) {
            løb.removeForhindring(this);
        }

        return found;
    }

}
