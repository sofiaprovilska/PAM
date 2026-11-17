package zad23;

public class PodwojneEspresso extends DodatekDekorator {

    public PodwojneEspresso(Napoj napoj) {
        super(napoj);
    }

    public String opis() {
        return napoj.opis() + ", podwójne espresso";
    }

    public double cena() {
        return napoj.cena() + 4.00;
    }
}