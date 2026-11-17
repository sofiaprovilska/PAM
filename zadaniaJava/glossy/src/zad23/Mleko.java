package zad23;

public class Mleko extends DodatekDekorator {

    public Mleko(Napoj napoj) {
        super(napoj);
    }

    public String opis() {
        return napoj.opis() + ", mleko";
    }

    public double cena() {
        return napoj.cena() + 1.50;
    }
}