package zad23;

public class Syrop extends DodatekDekorator {

    private String smak;

    public Syrop(String smak, Napoj napoj) {
        super(napoj);
        this.smak = smak;
    }

    public String opis() {
        return napoj.opis() + ", syrop " + smak + "owy";
    }

    public double cena() {
        return napoj.cena() + 2.00;
    }
}