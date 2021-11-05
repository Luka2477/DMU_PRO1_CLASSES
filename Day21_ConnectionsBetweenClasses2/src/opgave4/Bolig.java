package opgave4;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {

    private int kvm;
    private String adresse;
    private int prisPrMaaned;

    private Kollegie kollegie;
    private final ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();

    public Bolig (int kvm, String adresse, int prisPrMaaned) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMaaned = prisPrMaaned;
    }

    public void setKvm (int kvm) {
        this.kvm = kvm;
    }

    public int getKvm () {
        return this.kvm;
    }

    public void setAdresse (String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse () {
        return this.adresse;
    }

    public void setPrisPrMaaned (int prisPrMaaned) {
        this.prisPrMaaned = prisPrMaaned;
    }

    public int getPrisPrMaaned () {
        return this.prisPrMaaned;
    }

    public void setKollegie (Kollegie kollegie) {
        if (this.kollegie != kollegie) {
            this.kollegie = kollegie;
            kollegie.addBolig(this);
        }
    }

    public void removeKollegie () {
        if (this.kollegie != null) {
            this.kollegie.removeBolig(this);
            this.kollegie = null;
        }
    }

    public Kollegie getKollegie () {
        return this.kollegie;
    }

    public Lejeaftale createLejeaftale (LocalDate fraDato) {
        Lejeaftale lejeaftale = new Lejeaftale(fraDato, this);
        this.lejeaftaler.add(lejeaftale);
        return lejeaftale;
    }

    public void removeLejeaftale (Lejeaftale lejeaftale) {
        this.lejeaftaler.remove(lejeaftale);
    }

    public ArrayList<Lejeaftale> getLejeaftaler () {
        return new ArrayList<>(this.lejeaftaler);
    }
}
