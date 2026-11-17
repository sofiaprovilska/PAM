package zad23;

public class BitaSmietana extends DodatekDekorator {

    public BitaSmietana(Napoj napoj) {
        super(napoj);
    }

    public String opis() {
        return napoj.opis() + ", bita śmietana";
    }

    public double cena() {
        return napoj.cena() + 2.50;
    }
}