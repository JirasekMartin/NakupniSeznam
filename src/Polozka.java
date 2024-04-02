public class Polozka {
    private String nazev;
    private String kategorie;

    public Polozka(String nazev, String kategorie) {
        this.nazev = nazev;
        this.kategorie = kategorie;
    }

    public String getNazev() {
        return this.nazev;
    }

    public String getKategorie() {
        return this.kategorie;
    }
}