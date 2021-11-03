package opgave5;

import java.util.ArrayList;

public class Series {
    private final String title;
    private final ArrayList<String> cast;

    private final ArrayList<Episode> episodes = new ArrayList<>();

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

    public void createEpisode (int number, ArrayList<String> guestActors, int lengthMinutes) {
        Episode episode = new Episode(number, guestActors, lengthMinutes);
        this.episodes.add(episode);
    }

    public void removeEpisode (Episode episode) {
        this.episodes.remove(episode);
    }

    public Episode getEpisode (int number) {
        for (Episode episode : this.episodes) {
            if (episode.getNumber() == number) {
                return episode;
            }
        }

        return null;
    }

    public ArrayList<Episode> getEpisodes () {
        return new ArrayList<>(this.episodes);
    }

    public int totalLength () {
        return this.episodes.stream().mapToInt(Episode::getLength).sum();
    }

    public ArrayList<String> getGuestActors () {
        ArrayList<String> result = new ArrayList<>();

        for (Episode episode : this.episodes) {
            result.addAll(episode.getGuestCast());
        }

        return result;
    }
}
