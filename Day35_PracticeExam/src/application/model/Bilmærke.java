package application.model;

public enum Bilmærke {
    VW("Volkswagen"), AUDI("Audi"), MERCEDEZ("Mercedez"), PEUGOET("Peugeot");

    private final String str;

    Bilmærke (String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }

}
