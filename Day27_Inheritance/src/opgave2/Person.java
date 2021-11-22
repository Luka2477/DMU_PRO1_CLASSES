package opgave2;

class Person {
    private String navn;
    private String adresse;

    Person (String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
