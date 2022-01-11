package extra_programming.semesteropgave_jun_2021.application.model;

public class Professionel extends Spiller {

    private double kampHonorar;

    public Professionel(String navn, int årgang, double kampHonorar) {
        super(navn, årgang);
        this.kampHonorar = kampHonorar;
    }

    //------------------------------------------------------------------------------------------------------------------

    public double getKampHonorar() {
        return this.kampHonorar;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public double kampHonorar () {
        double honorar = 0.0;
        double afbud = 0.0;

        for (Deltagelse deltagelse : this.getDeltagelser()) {
            if (!deltagelse.isAfbud()) {
                honorar += this.kampHonorar;
            } else {
                afbud++;
            }
        }

        return honorar * (1 - afbud / this.getDeltagelser().size());
    }

}
