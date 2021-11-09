package opgave3;

import java.awt.*;
import java.util.ArrayList;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;

    private TrainingPlan trainingPlan;
    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.club = club;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     * @param club something
     */
    public void setClub(String club) {
        this.club = club;
    }
    
    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double best = Double.MAX_VALUE;
        for (double time: lapTimes) {
        	if(best > time) {
        		best = time;
        	}
        }
        return best;
    }

    public TrainingPlan getTrainingPlan () {
        return this.trainingPlan;
    }

    /**
     * Set the training plan of the swimmer.
     * Pre: trainingPlan != null
     *
     * @param trainingPlan the plan to be set
     */
    public void setTrainingPlan (TrainingPlan trainingPlan) {
        if (this.trainingPlan != trainingPlan) {
            this.trainingPlan = trainingPlan;
            trainingPlan.addSwimmer(this);
        }
    }

    public void removeTrainingPlan () {
        this.trainingPlan = null;
    }

    public int allTrainingHours () {
        return this.trainingPlan.getWeeklyStrengthHours() + this.trainingPlan.getWeeklyWaterHours();
    }
}
