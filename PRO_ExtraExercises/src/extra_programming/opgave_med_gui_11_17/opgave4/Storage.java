package extra_programming.opgave_med_gui_11_17.opgave4;

import java.util.ArrayList;

class Storage {

    private static ArrayList<Gruppe> grupper = new ArrayList<>();
    private static ArrayList<PersonChip> personChips = new ArrayList<>();
    private static ArrayList<Facilitet> faciliteter = new ArrayList<>();

    public static void addGruppe (Gruppe gruppe) {
        Storage.grupper.add(gruppe);
    }

    public static ArrayList<Gruppe> getGrupper () {
        return new ArrayList<>(Storage.grupper);
    }

    public static void addPersonChip (PersonChip personChip) {
        Storage.personChips.add(personChip);
    }

    public static ArrayList<PersonChip> getPersonChips () {
        return new ArrayList<>(Storage.personChips);
    }

    public static void addFacilitet (Facilitet facilitet) {
        Storage.faciliteter.add(facilitet);
    }

    public static ArrayList<Facilitet> getFaciliteter () {
        return new ArrayList<>(Storage.faciliteter);
    }

}
