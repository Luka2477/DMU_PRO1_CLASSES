package opgave5;

import java.util.ArrayList;

public class Series {
    private final String title;
    private final ArrayList<String> cast;

    public Series(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }

    public String getTitle () {
        return this.title;
    }

    public ArrayList<String> getCast () {
        return new ArrayList<>(this.cast);
    }
}
