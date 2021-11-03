package opgave5;

import java.util.ArrayList;

public class Episode {
    private int number;
    private ArrayList<String> guestActors;
    private int lengthMinutes;

    public int getNumber () {
        return this.number;
    }

    public int getLength () {
        return this.lengthMinutes;
    }

    public ArrayList<String> getGuestCast () {
        return new ArrayList<>(this.guestActors);
    }
}
