package opgave4;

import java.awt.*;
import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {


        TrainingPlan trainingPlan = new TrainingPlan('A', 16, 10);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        trainingPlan.createSwimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        trainingPlan.createSwimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        trainingPlan.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        System.out.print(trainingPlan);

        Swimmer swimmer = trainingPlan.getSwimmer("Mikkel", "AIA-Tranbjerg");
        trainingPlan.removeSwimmer(swimmer);

        System.out.print(trainingPlan);
    }
}
