package p5_1;

public class Date {
    final private int day;
    final private int month;

    public Date(int day, int month) {
        this.day = day;
        this.month = month;
    }

    public String getSeason() {
        String season;

        if(this.month <= 3) season = "Winter";
        else if(this.month <= 6) season = "Spring";
        else if(this.month <= 9) season = "Summer";
        else season = "Fall";

        if(this.month % 3 == 0 && this.day >= 21) {
            switch (season) {
                case "Winter":
                    season = "Spring";
                    break;
                case "Spring":
                    season = "Summer";
                    break;
                case "Summer":
                    season = "Fall";
                    break;
                default:
                    season = "Winter";
                    break;
            }
        }

        return season;
    }
}
