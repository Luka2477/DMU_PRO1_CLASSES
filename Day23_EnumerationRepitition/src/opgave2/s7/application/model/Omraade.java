package opgave2.s7.application.model;

public enum Omraade {
    STANDARD("Standard"),
    VIP("VIP"),
    BOERNE("Børne"),
    TURNERING("Turnering");

    private String value;

    Omraade (String value) {
        this.value = value;
    }

    @Override
    public String toString () {
        return this.value;
    }
}
