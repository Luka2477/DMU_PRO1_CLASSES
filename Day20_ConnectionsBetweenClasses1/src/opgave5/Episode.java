package opgave5;

import java.util.ArrayList;

public class Episode {
    private final int number;
    private final ArrayList<String> guestActors;
    private final int lengthMinutes;

    public Episode(int number, ArrayList<String> guestActors, int lengthMinutes) {
        this.number = number;
        this.guestActors = guestActors;
        this.lengthMinutes = lengthMinutes;
    }

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
